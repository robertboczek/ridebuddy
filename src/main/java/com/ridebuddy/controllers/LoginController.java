package com.ridebuddy.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ridebuddy.dao.CredentialsDao;
import com.ridebuddy.models.Credentials;
import com.ridebuddy.ui.models.FbLogin;
import com.ridebuddy.ui.models.FbUser;
import com.ridebuddy.ui.models.Login;
import com.ridebuddy.ui.models.User;
import com.ridebuddy.util.HttpClientUtil;
import com.ridebuddy.util.ObjectMapperUtil;

@Controller
public class LoginController extends AbstractController {

	private static final Logger logger = Logger
			.getLogger(LoginController.class);

	@Autowired
	private CredentialsDao credentialsDao;

	@Autowired
	private HttpClientUtil httpClientUtil;
	
	@Autowired
	private ObjectMapperUtil fbUserMapperUtil;

	private static final String accessToken = "access_token=";
	private static final String expiresKey = "&expires=";
	private static final String FbUserDetailsUrl = "https://graph.facebook.com/me?access_token=";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Login login, BindingResult result, Model model) {
		model.asMap().put("login", login);
		return "login";
	}

	@RequestMapping(value = "/fbLogin")
	public String fbLogin(FbLogin fbLogin, HttpSession session) {
		logger.info("Received FB login: " + fbLogin);
		FbUser fbUser = null;
		try {
			fbUser = getFbUser("https://graph.facebook.com/oauth/access_token?client_id=204946226368181&redirect_uri=http://ec2-50-16-158-177.compute-1.amazonaws.com:8080/whereismymobile/fbLogin&client_secret=961f70d8402f92d77b492d74e5408a&code="
					+ fbLogin.getCode());
		} catch (Exception e) {
			logger.error("Error while getting fb token", e);
			return "redirect:login";
		}

		List<Credentials> credentialsList = credentialsDao.getById(fbUser.getEmail());
		Credentials credentials = null;
		boolean shouldSave = false;
		if (credentialsList.size() == 1) {
			credentials = credentialsList.get(0);
			shouldSave = setFields(credentials, fbUser);
		} else {
			credentials = new Credentials();
			credentials.setEmail(fbUser.getEmail());
			shouldSave = setFields(credentials, fbUser);
		}
		if (shouldSave) {
			credentialsDao.save(credentials);
		}
		User user = new User(credentials);
		saveUserInSession(session, user);
		
		return "redirect:welcome";
	}

	private boolean setFields(Credentials credentials, FbUser fbUser) {
		if (!fbUser.getFirst_name().equals(credentials.getFirstName()) ||
				!fbUser.getLast_name().equals(credentials.getLastName()) ||
				StringUtils.isEmpty(credentials.getImgSrc())) {
			credentials.setFirstName(fbUser.getFirst_name());
			credentials.setLastName(fbUser.getLast_name());
			credentials.setImgSrc("http://graph.facebook.com/" + fbUser.getId() + "/picture");
			return true;
		} else {
			return false;
		}
	}

	private FbUser getFbUser(String address) throws Exception {

		String response = httpClientUtil.getRequest(address);
		String token = response.substring(
				response.indexOf(accessToken) + accessToken.length(),
				response.indexOf(expiresKey));
		// TODO save session
		String expires = response.substring(response.indexOf(expiresKey) + expiresKey.length());

		String userDetailsUrl = FbUserDetailsUrl + token;
		String userDetails = httpClientUtil.getRequest(userDetailsUrl);
		logger.info("FB User details: " + userDetails);
		
		return fbUserMapperUtil.readValue(userDetails, FbUser.class);
	}
}
