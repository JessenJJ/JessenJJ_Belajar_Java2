package id.jessbcas.jesstore.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseData<T> extends Response {
    private T data;

    public ResponseData(String message, boolean success, T data) {
        super(message, success);
        this.data = data;
    }
    
}
