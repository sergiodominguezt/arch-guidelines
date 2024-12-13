package test.testhexagonal.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private boolean successful;
    private ErrorData data;
    private String message;
    private int code;
}