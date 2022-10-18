package cheetos.main.post.service;

import cheetos.main.Exception.S3ConvertImgException;
import org.springframework.web.multipart.MultipartFile;

public interface ImgService extends PostService {

    // 이미지를 s3에 업로드
    String uploadImgToS3(MultipartFile imageFile) throws S3ConvertImgException;
}
