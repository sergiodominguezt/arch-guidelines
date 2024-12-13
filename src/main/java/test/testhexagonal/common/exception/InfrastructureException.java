package test.testhexagonal.common.exception;

import lombok.Getter;
import test.testhexagonal.common.enums.ErrorCode;

@Getter
public class InfrastructureException extends RuntimeException {
    private final String errorMessage;
    private final ErrorCode errorCode;

    public InfrastructureException(String errorMessage, ErrorCode errorCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

}
