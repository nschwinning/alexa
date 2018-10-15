package de.bich.alexa.handlers;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.StandardCard;

public class RecentScherbenHandler implements IntentHandler{

	@Override
	public SpeechletResponse handleIntent(Intent intent, IntentRequest request, Session session) {
		// TODO Auto-generated method stub
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText("Bla");
		
		StandardCard card = new StandardCard();
		card.setTitle("Scherben");
		card.setText("Blubb");
		
		return SpeechletResponse.newTellResponse(speech, card);
		
	}

}
