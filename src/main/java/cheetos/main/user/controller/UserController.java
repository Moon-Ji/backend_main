package cheetos.main.user.controller;

import cheetos.main.user.User;
import cheetos.main.user.domain.Role;
import cheetos.main.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    @ResponseBody
    public String main() {
        return "main";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute User user) {
//        user.setUserRole(Role.USER);

        userRepository.save(user);
        return "redirect:/loginForm";
    }

    @GetMapping("/map")
    @ResponseBody
    public String map() {
        return "map";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin";
    }
}
