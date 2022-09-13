package cheetos.main.post.dto;

import cheetos.main.post.enums.LocalCodes;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.ToString;

public class WritePostDto {

    @Getter
    @ToString
    public static class WritePost {

        private LocalCodes location;

        private String representImg;

        private String title;

        private LocalDateTime travelDate;

        private
    }

}
