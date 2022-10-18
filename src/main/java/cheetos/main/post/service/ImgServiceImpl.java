package cheetos.main.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImgServiceImpl implements ImgService {

    private static final String SAMPLE_IMG_URL = "/img_test";

    /**
     * S3 에 이미지를 업로드하고 주소값을 반환한다.
     * @param imageFile
     * @return
     */
    public String uploadImgToS3(MultipartFile imageFile) {
        //TODO : 이미지 저장정보를 구현
        return SAMPLE_IMG_URL;
    }
}
