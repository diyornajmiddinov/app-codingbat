package uz.pdp.codingbat.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class ApiResult {
    private boolean success;
    private String message;

    public ApiResult(final boolean success, final String message) {
        this.success = success;
        this.message = message;
    }


}
