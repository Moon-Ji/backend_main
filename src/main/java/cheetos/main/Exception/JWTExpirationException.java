package cheetos.main.Exception;

import cheetos.main.post.enums.ErrorCode;

public class JWTExpirationException extends RuntimeException{

    public JWTExpirationException(String message) {
        super(message);
    }

    public JWTExpirationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
