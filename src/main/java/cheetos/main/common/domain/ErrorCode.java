package cheetos.main.common.domain;

import lombok.Getter;

public class ErrorCode {

    //TODO : 추가로 정의되어야할 에러 enum 코드 정의가 필요
    public enum ErrorStatus {
        NO_CONTENTS(40001, "데이터가 없습니다"),
        NO_AUTH(401, "접근 권한이 없습니다")
        ;

        @Getter
        public int errCode;

        @Getter
        public String errMsg;


        ErrorStatus(int errCode, String errMsg) {
            this.errCode = errCode;
            this.errMsg = errMsg;
        }
    }
}