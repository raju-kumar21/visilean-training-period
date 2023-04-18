package com.jwtdemo3neo4j.jwtdemo3neo4j.customException;

import org.springframework.stereotype.Component;

@Component
public class Permission extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorCode;

    private String errorMessage;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Permission(String errorCode, String errorMessage) {

        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Permission() {
    }

}
