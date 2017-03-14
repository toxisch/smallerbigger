package de.havre.alexa.smalerbigger;

import de.havre.alexa.common.SpringSpeechletServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "de.havre.alexa.smalerbigger")
public class AlexaConfig {

    @Autowired
    private VoiceSpeechlet voiceSpeechlet;

    @Bean(name = "alexa")
    public SpringSpeechletServlet registerServlet() {
        SpringSpeechletServlet speechletServlet = new SpringSpeechletServlet();
        speechletServlet.setSpeechlet(voiceSpeechlet);
        return speechletServlet;
    }

}