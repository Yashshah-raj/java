package navkar.jewels.com.navkar.resources.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {
	private String clientId;
	private String secretId;
	private FacebookConnectionFactory factory ;
	
	public LoginController(@Value("${spring.social.facebook.clientid}") String clientId,@Value("${spring.social.facebook.secretid}") String secretId) {
		this.clientId=clientId;
		this.secretId=secretId;
		this.factory= new FacebookConnectionFactory(clientId,
				secretId);
	}
	
	@GetMapping(value = "/facebook")
	public String producer() {
		OAuth2Operations operations = factory.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri("http://localhost:8088/api/");
		params.setScope("email,public_profile");
		String url = operations.buildAuthenticateUrl(params);
		return "redirect:" + url;
	}
	
	@GetMapping(value = "/")
	public String rediredt(@RequestParam("code") String authorizationCode) {
		OAuth2Operations operations=factory.getOAuthOperations();
		AccessGrant accessToken=operations.exchangeForAccess(authorizationCode,"http://localhost:8088/api/", null);
		Connection<Facebook> connection=factory.createConnection(accessToken);
		Facebook facebook=connection.getApi();
		String[] fields = {"id","email","first_name","last_name"};
		User userProfile=facebook.fetchObject("me",User.class, fields);
		
		return "redirected: Welcome "+userProfile.getFirstName() + "  "+ userProfile.getLastName() +" & your mail id is : "+userProfile.getEmail();
	}
}
