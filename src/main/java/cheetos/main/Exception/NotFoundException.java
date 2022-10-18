package cheetos.main.Exception;

import cheetos.main.post.enums.ErrorCode;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}