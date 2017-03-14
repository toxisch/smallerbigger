package de.havre.alexa.common;

import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;

/**
 * Created by TAAHAAL6 on 09.03.2017.
 */
public interface IntentRequestListener {
    SpeechletResponse onIntent(IntentRequest var1, Session var2) throws SpeechletException;

    String getIntentName();
}
