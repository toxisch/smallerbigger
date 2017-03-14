package de.havre.alexa.common;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by TAAHAAL6 on 22.02.2017.
 */
public class SpringSpeechletServlet extends SpeechletServlet implements HttpRequestHandler {

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getPathInfo().contains("auth"))
        {
            Map<String, String[]> parameterMap = request.getParameterMap();
            String state = parameterMap.get("state")[0];

            String uri = "https://layla.amazon.com/spa/skill/account-linking-status.html?vendorId=MF9J2OZESPGIO#access_token=n3QI2duxQ4Q8UcAI3rtzm5PbQjkj&token_type=Bearer&expires_in=86399&scope=write-voip-simrings%20read-token-info%20read-voip-simrings%20read-voip-eventsubscriptions%20write-voip-eventsubscriptions%20read-voip-calls%20read-voip-numbers%20read-voip-phonebook%20write-voip-callforwardings%20write-voip-calls%20read-voip-callforwardings&state="+state;
            System.out.println(uri);
            response.sendRedirect(uri);
        }
        else service(request, response);
    }
}
