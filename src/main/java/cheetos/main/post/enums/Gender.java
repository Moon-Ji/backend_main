package cheetos.main.post.enums;


import lombok.Getter;

public enum Gender {

    MAN(0,"남자"),
    WOMAN(1,"여자")
    ;


    Gender(int code, String kor) {
        this.code = code;
        this.kor = kor;
    }
    @Getter
    private int code;
    @Getter
    private String kor;
}
