package de.bich.alexa.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.StandardCard;

import de.bich.alexa.twitter.TwitterHandler;
import twitter4j.TwitterException;

@Component
public class RecentScherbenHandler implements IntentHandler{
	
	@Autowired
	private TwitterHandler twitterHandler;

	@Override
	public SpeechletResponse handleIntent(Intent intent, IntentRequest request, Session session) {
		// TODO Auto-generated method stub
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		String text = "";
		try {
			text = twitterHandler.getLatestStatusByUser("Scherben81").getText();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speech.setText(text);
		
		StandardCard card = new StandardCard();
		card.setTitle("Scherben");
		card.setText(text);
		
		return SpeechletResponse.newTellResponse(speech, card);
		
	}

}
