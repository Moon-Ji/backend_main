package cheetos.main.post.enums;
import lombok.Getter;

public enum LocalCodes {

    YEONCHEON(1,"연천"),
    CHULWON(2,"철원"),
    HWACHUN(3,"화천"),
    YANGGU(4,"양구"),
    INJAE(5,"인제"),
    GOSUNG(6,"고성"),
    PAJU(7,"파주"),
    YANGJU(8,"양주"),
    YONGDUCHUN(9,"용두천"),
    POCHUN(10,"포천"),
    GAPYUNG(11,"가평"),
    CHUNCHUN(12,"춘천"),
    SOCKCHO(13,"속초"),
    YANGYANG(14, "양양"),
    GANGHWA(15,"강화"),
    GIMPO(16,"김포"),
    GOYANG(17,"고양"),
    EUJUNGBOO(18,"의정부"),
    NAMYANGJOO(19,"가평"),
    HONGCHUN(20,"홍천"),
    INCHEON(21, "인천"),
    SEOUL(22, "서울"),
    GURI(23, "구리"),
    HANAM(24, "하남"),
    YANGPYUNG(25, "양평"),
    HWAINGSUNG(26,"횡성"),
    PYUNGCHANG(27,"평창"),
    GANGLEUNG(28,"강릉"),
    SUNGNAM(29,"성남"),
    GWANGJU(30,"광주"),
    YUJOO(31,"여주"),
    WONJOO(32,"원주"),
    JUNGSUN(33,"정선"),
    SAMCHUCK(34,"삼척"),
    HWASUNG(35,"화성"),
    YONGIN(36,"용인"),
    LEECHEON(37,"이천"),
    CHUNGJOO(38,"충주"),
    JAECHEON(39,"제천"),
    YEONGWORL(40,"영월"),
    JUNGSEON(41,"정선"),
    PYENGTAEK(42,"평택"),
    ANSUNG(43,"안성"),
    DANYANG(44,"단양"),
    TAEBAEK(45,"태백"),
    EUMSUNG(46, "음성"),
    DANGJIN(47,"당진"),
    ASAN(48,"아산"),
    CHEONAN(49,"천안"),
    JINCHEON(50,"진천"),
    TAEAN(51,"태안"),
    SEOSAN(52,"서산"),
    YEAHSAN(53,"예산"),
    GWAISAN(54,"괴산"),
    MOONGYUNG(55,"문경"),
    YEACHEON(56,"예천"),
    YEONGJOO(57,"영주"),
    BONGWHA(58,"봉화"),
    WOOLJIN(59,"울진"),
    HONGSUNG(60,"홍성"),
    GONGJOO(61,"공주"),
    YEONGI(62,"연기"),
    JUNGYANG(63,"정양"),
    CHUNGWON(64,"청원"),
    BORYUNG(65,"보령"),
    BOOYEO(66,"부여"),
    NONSAN(67,"논산"),
    GAERYONG(68,"계룡"),
    DAEJEON(69,"대전"),
    BOEUN(70,"보은"),
    SANGJOO(71,"상주"),
    ANDONG(72,"안동"),
    YEONGYANG(73,"영양"),
    SEOCHUN(74,"서천"),
    ICKSAN(74,"익산"),
    WANJOO(75,"완주")
    ;







    @Getter
    private int code;

    @Getter
    private String name;

    LocalCodes(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
