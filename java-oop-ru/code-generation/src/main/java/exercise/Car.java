package exercise;

import lombok.*;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
@Getter
@AllArgsConstructor
@NoArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public static Car unserialize(String jsomString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsomString, Car.class);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    // END
}
