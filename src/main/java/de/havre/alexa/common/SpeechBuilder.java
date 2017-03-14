package de.havre.alexa.common;

import com.amazon.speech.ui.SsmlOutputSpeech;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by TAAHAAL6 on 23.02.2017.
 */
public class SpeechBuilder {

    private StringBuilder builderString = new StringBuilder();

    public static SpeechBuilder create() {
        return new SpeechBuilder();
    }

    public SpeechBuilder sayText(String text) {
        if (text != null)
            builderString.append(text);
        return this;
    }

    public SpeechBuilder sayPhonnumber(String number) {
        if (number.startsWith("+")) {
            number = number.replace("+", "");
            this.sayText("plus");
        }
        builderString.append("<say-as interpret-as=\"digits\">" + number + "</say-as>");
        return this;
    }

    public SpeechBuilder sayDate(Date date) {
        builderString.append("Am <say-as interpret-as=\"date\">" + getDateString(date) + "</say-as> ");
        return this;
    }

    public SpeechBuilder sayTime(Date date) {
        builderString.append(getTimeString(date));
        return this;
    }

    public SpeechBuilder wait(int seconds) {
        builderString.append("<break time=\""+seconds+"s\"/>");
        return this;
    }

    public SsmlOutputSpeech build() {
        SsmlOutputSpeech outputSpeech = new SsmlOutputSpeech();
        outputSpeech.setSsml("<speak>" + builderString.toString() + "</speak>");
        return outputSpeech;
    }

    private String getDateString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    private String getTimeString(Date date) {
        SimpleDateFormat h = new SimpleDateFormat("H");
        SimpleDateFormat m = new SimpleDateFormat("m");
        return h.format(date) + " Uhr " + m.format(date);
    }

}
