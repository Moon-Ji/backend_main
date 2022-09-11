package cheetos.main.common.domain;

import lombok.Getter;

public class CommonCode {

    /**
     * 응답 키값을 설정
     */
    public enum keys {
        CODE("code"),
        STATUS("status"),
        MESSAGE("message")
        ;

        @Getter
        private String key;

        keys(String key) {
            this.key = key;
        }
    }

    /**
     * 응답 코드값을 설정
     * 정상일 경우만 응답, 에러발생시 에러 enum을 통해 설정
     */
    public enum Code {
        SUCCESS(0, "SUCCESS"),
        FAIL(-1, "FAILED")
        ;

        @Getter
        private int code;

        @Getter
        private String message;

        Code(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
