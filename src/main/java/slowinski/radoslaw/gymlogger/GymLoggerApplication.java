package slowinski.radoslaw.gymlogger;


import com.jsunsoft.http.HttpRequest;
import com.jsunsoft.http.HttpRequestBuilder;
import com.jsunsoft.http.ResponseDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class GymLoggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymLoggerApplication.class, args);
        new GymLoggerApplication().pokeSecondServer();
    }


    private void pokeSecondServer(){
        HttpRequest<String> httpRequest = HttpRequestBuilder
                .createPost("https://gym-logger-poke.herokuapp.com/", String.class)
                .responseDeserializer(ResponseDeserializer.ignorableDeserializer()).build();

        Executors.newScheduledThreadPool(1)
                .scheduleAtFixedRate(httpRequest::execute, 0, 360, TimeUnit.SECONDS);
    }
}
