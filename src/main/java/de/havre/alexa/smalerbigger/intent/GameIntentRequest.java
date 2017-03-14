package de.havre.alexa.smalerbigger.intent;

import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import de.havre.alexa.common.IntentRequestListener;
import de.havre.alexa.common.SpeechBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by TAAHAAL6 on 09.03.2017.
 */
@Service
public class GameIntentRequest implements IntentRequestListener {

    public SpeechletResponse onIntent(IntentRequest intent, Session session) throws SpeechletException {

        String requiredNumber = (String) session.getAttribute("requiredNumber");
        String counter = (String) session.getAttribute("counter");
        String givenNumber = intent.getIntent().getSlot("number").getValue();

        try {
            int givenNumberInt = Integer.parseInt(givenNumber);
            int requiredNumberInt = Integer.parseInt(requiredNumber);
            int counterInt = Integer.parseInt(counter);
            counterInt++;
            session.setAttribute("counter", counterInt);

            if (givenNumberInt > requiredNumberInt) {
                // Create the Simple card content.
                SimpleCard card = new SimpleCard();
                card.setTitle("GrösserKleiner");
                card.setContent("Meine Zahl ist kleiner");

                SpeechBuilder builder = SpeechBuilder.create()
                        .sayText("Meine Zahl ist kleiner");
                SpeechBuilder repromtBuilder = SpeechBuilder.create()
                        .sayText("Möchtest du nicht nochmal raten?");
                Reprompt repromt = new Reprompt();
                repromt.setOutputSpeech(repromtBuilder.build());

                return SpeechletResponse.newAskResponse(builder.build(), repromt, card);
            } else if (givenNumberInt > requiredNumberInt) {
                // Create the Simple card content.
                SimpleCard card = new SimpleCard();
                card.setTitle("GrösserKleiner");
                card.setContent("Meine Zahl ist grösser");

                SpeechBuilder builder = SpeechBuilder.create()
                        .sayText("Meine Zahl ist grösser");

                SpeechBuilder repromtBuilder = SpeechBuilder.create()
                        .sayText("Möchtest du nicht nochmal raten?");

                Reprompt repromt = new Reprompt();
                repromt.setOutputSpeech(repromtBuilder.build());

                return SpeechletResponse.newAskResponse(builder.build(), repromt, card);
            } else if (givenNumberInt > requiredNumberInt) {
                // Create the Simple card content.
                SimpleCard card = new SimpleCard();
                card.setTitle("GrösserKleiner");
                card.setContent("Super, genau das war meine Zahl");

                SpeechBuilder builder = SpeechBuilder.create()
                        .sayText("Super, genau das war meine Zahl")
                        .wait(1);
                return SpeechletResponse.newTellResponse(builder.build(), card);
            }
        } catch (Exception e) {
            // Create the Simple card content.
            SimpleCard card = new SimpleCard();
            card.setTitle("GrösserKleiner");
            card.setContent("Bitte nur Zahlen zwischen 0 und 100");


            SpeechBuilder builder = SpeechBuilder.create()
                    .sayText("Bitte nur Zahlen zwischen 0 und 100");

            SpeechBuilder repromtBuilder = SpeechBuilder.create()
                    .sayText("Möchtest du nicht nochmal raten?");

            Reprompt repromt = new Reprompt();
            repromt.setOutputSpeech(repromtBuilder.build());

            return SpeechletResponse.newAskResponse(builder.build(), repromt, card);
        }

        throw new SpeechletException("bad");
    }

    public String getIntentName() {
        return "GameIntent";
    }

}
