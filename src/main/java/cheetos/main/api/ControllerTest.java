package cheetos.main.api;

import cheetos.main.common.ResponseForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class ControllerTest {

    @GetMapping("/1")
    public String test1() {
        return "test controller";
    }

    @GetMapping("/2")
    public ResponseForm test2() {
        return new ResponseForm();
    }

    @GetMapping("/3")
    public ResponseForm test3(@ModelAttribute MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return new ResponseForm();
    }
}
