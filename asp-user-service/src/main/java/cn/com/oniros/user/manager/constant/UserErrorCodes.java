package cn.com.oniros.user.manager.constant;

import cn.com.oniros.http.ErrorCode;

/**
 * cn.com.oniros.user.manager.constant.UserErrorCodes
 *
 * @author Li Xiaoxu
 * 2024/4/14 17:36
 */
public enum UserErrorCodes implements ErrorCode {

    USER_EXISTS(30001L, "User already exists"),

    UNKNOWN_USER(30002L, "Unknown user");

    private final Long errorCode;

    private final String message;

    UserErrorCodes(Long errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }


    public Long getErrorCode() {
        return errorCode;
    }


    public String getMessage() {
        return message;
    }
}
