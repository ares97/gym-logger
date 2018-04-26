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
    }
}
