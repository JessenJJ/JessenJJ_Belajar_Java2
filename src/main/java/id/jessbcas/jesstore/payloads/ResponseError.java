package id.jessbcas.jesstore.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseError {
    private int status;
    private String error;
    private String message;
}
