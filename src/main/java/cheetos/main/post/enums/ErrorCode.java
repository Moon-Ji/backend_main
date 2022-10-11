package cheetos.main.post.enums;

import lombok.Getter;

public enum ErrorCode {

    NOT_FOUND_POST_ERROR("포스트를 찾을 수 업습니다!"),
    S3_CONVERT_ERROR("이미지 변환중 에러가 발생하였습니다!")
    ;

    @Getter
    private String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
