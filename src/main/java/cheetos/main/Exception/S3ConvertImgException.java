package cheetos.main.Exception;

import cheetos.main.post.enums.ErrorCode;

public class S3ConvertImgException extends RuntimeException {

    public S3ConvertImgException(String message) {
        super(message);
    }

    public S3ConvertImgException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
