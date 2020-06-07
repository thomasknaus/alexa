package de.knaus.alexa.config;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;
import de.knaus.alexa.CustomSpeechlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlexaConfig {

    @Autowired
    private CustomSpeechlet mySpeechlet;

    @Bean
    public ServletRegistrationBean registerServlet() {

        SpeechletServlet speechletServlet = new SpeechletServlet();
        speechletServlet.setSpeechlet(mySpeechlet);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(speechletServlet, "/service");
        return servletRegistrationBean;
    }
}
