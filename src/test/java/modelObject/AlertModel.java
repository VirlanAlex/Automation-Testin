package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AlertModel {

    private String alertText;

    public String getAlertText() {
        return alertText;
    }

    public void setAlertText(String alertText) {
        this.alertText = alertText;
    }

    public AlertModel(String jasonFilePath) {
        populateObject(jasonFilePath);
    }

    public void populateObject(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(/*valueToUpdate*/ this)
                    .readValue(Files.readAllBytes(Paths.get(jsonFilePath)));
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }
}
