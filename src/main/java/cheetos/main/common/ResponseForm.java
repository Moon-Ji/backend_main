package cheetos.main.common;

import java.util.HashMap;
import java.util.Map;

import cheetos.main.common.domain.CommonCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ResponseForm<T> {

    private Map<String, Object> meta = new HashMap<>();
    private Object data;

    /**
     * data 와 함께 응답값을 내려주는 경우(정상)
     * @param data
     */
    public ResponseForm (T data) {
        meta.put(CommonCode.keys.CODE.getKey(), CommonCode.Code.SUCCESS.getCode());
        meta.put(CommonCode.keys.MESSAGE.getKey(), CommonCode.Code.SUCCESS.getMessage());

        this.data = data;
    }

    /**
     * 에러 발생시 에러코드와 에러 메시지 반환
     */
    public ResponseForm () {
        meta.put(CommonCode.keys.CODE.getKey(), CommonCode.Code.FAIL.getCode());
        meta.put(CommonCode.keys.MESSAGE.getKey(), CommonCode.Code.FAIL.getMessage());
    }
}
