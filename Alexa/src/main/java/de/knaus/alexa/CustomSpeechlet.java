package de.knaus.alexa;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;
import de.knaus.alexa.handler.HandleWelcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomSpeechlet implements Speechlet {

    private static final Logger log = LoggerFactory.getLogger(CustomSpeechlet.class);

    @Override
    public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
    }

    @Override
    public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
        return HandleWelcome.getWelcomeResponse();
    }

    @Override
    public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {

        Intent intent = request.getIntent();
        if (intent == null)
            throw new SpeechletException("Unrecognized intent");

        String intentName = intent.getName();

        if ( intentName.equals("TerriblyInterestingIntent") ) {

            String speechText = "Hello, World.  I am a Spring Boot custom skill.";

            SimpleCard card = new SimpleCard();
            card.setTitle("Hello World");
            card.setContent(speechText);

            PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
            speech.setText(speechText);

            SpeechletResponse response = SpeechletResponse.newTellResponse(speech, card);
            return response;
        }
        else {
            throw new SpeechletException("I don't understand that intent.");
        }
    }

    @Override
    public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {

    }
}
