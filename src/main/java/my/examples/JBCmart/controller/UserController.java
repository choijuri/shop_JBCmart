package my.examples.JBCmart.controller;

import my.examples.JBCmart.domain.User;
import my.examples.JBCmart.dto.JoinForm;
import my.examples.JBCmart.service.UserService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //로그인
    @GetMapping("/login")
    public String login(
            @RequestParam(name = "fail",
                    required = false,
                    defaultValue = "false") String errorFlag){

        return "users/login"; // view name 을 리턴한다.
    }

    //회원가입
    @GetMapping("/join")
    public String join(){
        return "users/joinform";
    }

    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }

        if(!joinForm.getPassword().equals(joinForm.getPassword2()))
            throw new IllegalArgumentException("암호와 암호확인이 일치하지 않아요.");


        User user = new User();
        user.setUserId(joinForm.getUserId());
        user.setEmail(joinForm.getEmail());
        user.setName(joinForm.getName());
        user.setPhone(joinForm.getPhone());

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPasswd(passwordEncoder.encode(joinForm.getPassword()));

        User joinuser = userService.join(user);
        return "redirect:/users/welcome";
    }


    //가입성공
    @GetMapping("/welcome")
    public String welcome(){
        return "users/welcome";
    }


}
