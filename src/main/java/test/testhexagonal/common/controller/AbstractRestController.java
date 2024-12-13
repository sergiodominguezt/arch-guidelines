package test.testhexagonal.common.controller;


import test.testhexagonal.common.dto.ResponseDTO;
import test.testhexagonal.common.enums.ErrorCode;

/**
 * Abstract class that implements general controller functionalities.
 */
public abstract class AbstractRestController {

    protected ResponseDTO buildSuccessResponseDTO(Object result) {
        return ResponseDTO.builder()
                .successful(true)
                .data(result)
                .message(ErrorCode.OK.getMessage())
                .code(ErrorCode.OK.getCode())
                .build();
    }
}
