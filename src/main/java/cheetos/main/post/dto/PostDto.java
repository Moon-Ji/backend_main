package cheetos.main.post.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

public class PostDto {

    @Getter
    @ToString
    public static class MainPostDataReq {

        private List<LocationInfo> map = new ArrayList<>();
    }

    public static class LocationInfo {
        private LocalCode location;
        private String representImg;
    }
}
