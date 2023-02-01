package boardexample.myboard.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/add")
    public String userAddForm(@ModelAttribute("user") UserSaveForm user){
        return "addUserForm";
    }

    @PostMapping("/add")
    public String userAdd(@Validated @ModelAttribute("user") UserSaveForm user, BindingResult result){
        if(result.hasErrors()){
            return "addUserForm";
        }
        userService.save(user);
        return "redirect:/";
    }
}
