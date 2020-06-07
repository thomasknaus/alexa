package de.knaus.alexa.handler;

import com.amazon.speech.speechlet.SpeechletResponse;
import de.knaus.alexa.helper.AskResponseHelper;

public class HandleWelcome {

    public static SpeechletResponse getWelcomeResponse() {
        String speechOutput = "Welcome to HelloSkill! Ask something!";
        String repromptText = "You want to ask something?";

        return AskResponseHelper.newAskResponse(speechOutput, false, repromptText, false);
    }

}
