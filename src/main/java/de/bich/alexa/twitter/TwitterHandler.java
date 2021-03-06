package de.bich.alexa.twitter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import de.bich.alexa.model.TwitterStatus;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Component
public class TwitterHandler {
	
	public final String API_KEY_PROPERTY = "API_KEY";

    public final String API_SECRET_PROPERTY = "API_SECRET";

    public final String TOKEN_PROPERTY = "TOKEN_KEY";

    public final String TOKEN_SECRET_PROPERTY = "TOKEN_SECRET";

    // security values needed for connecting to the twitter account (defined in config.properties)
    private String apiKey;

    private String apiSecret;

    private String token;

    private String tokenSecret;

    // connection to twitter
    private Twitter twitter;

    @PostConstruct
    public void init() {
    	final Properties prop = new Properties();

        try (final InputStream input = TwitterHandler.class.getResourceAsStream("/config.properties")) {
            // load a properties file
            prop.load(input);

            // get the property values
            apiKey = prop.getProperty(API_KEY_PROPERTY);
            apiSecret = prop.getProperty(API_SECRET_PROPERTY);
            token = prop.getProperty(TOKEN_PROPERTY);
            tokenSecret = prop.getProperty(TOKEN_SECRET_PROPERTY);
            
            twitter = TwitterFactory.getSingleton();
            twitter.setOAuthConsumer(apiKey, apiSecret);
            AccessToken accessToken = new AccessToken(token, tokenSecret);
            twitter.setOAuthAccessToken(accessToken);

        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public List<TwitterStatus> findTweetsByUser(String username) throws TwitterException{
    	List<TwitterStatus> statusList = new ArrayList<>();
		for (Status s:twitter.getUserTimeline(username)) {
			statusList.add(convert(s));
		}
		return statusList;
    }
	
	public TwitterStatus getLatestStatusByUser(String username) throws TwitterException {
		return findTweetsByUser(username).get(0);
	}
	
	private TwitterStatus convert(Status status) {
    	TwitterStatus twitterStatus = new TwitterStatus();
    	twitterStatus.setStatusTimeStamp(status.getCreatedAt());
    	twitterStatus.setText(status.getText());
    	twitterStatus.setTwitterStatusId(status.getId());
    	twitterStatus.setTwitterUserId(status.getUser().getId());
    	twitterStatus.setUsername(status.getUser().getScreenName());
    	return twitterStatus;
    }
}
