package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.context.annotation.Bean;

// BEGIN
import org.springframework.web.context.annotation.RequestScope;
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    @RequestScope
    public static Daytime getDayTime() {
        var getHourNow = LocalDateTime.now().getHour();
        if(6 <= getHourNow && getHourNow < 22) {
            return new Day();
        } else {
            return new Night();
        }
    }
    // END
}
