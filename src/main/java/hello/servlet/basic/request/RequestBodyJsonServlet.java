package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@WebServlet(name="requestBodyJsonServlet", urlPatterns="/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
    
    private final ObjectMapper objectMapper = new ObjectMapper(); //JSON을 java오브젝트로 파싱해주는 라이브러리
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, UTF_8);
        System.out.println("messageBody = " + messageBody);// JSON도 문자라서 그대로 나온다.

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println("helloData.userName = " + helloData.getUsername());
        System.out.println("helloData.userAge = " + helloData.getAge());
    }
}
