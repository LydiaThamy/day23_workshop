package sg.nus.edu.iss.day23_workshop.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    
    private int statusCode;
    private Date timeStamp;
    private String message;
    private String description;
    
}
