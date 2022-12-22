package com.midasin.bp.mlogmember.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private final ErrorMessage errorMessage;

    public String getMessage() {
        return errorMessage.name();
    }
}
