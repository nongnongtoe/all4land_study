package boardexample.myboard.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/userapi")
public class UserRestController {
    private final UserService userService;

    @PostMapping
    public Long join(@RequestBody @Validated UserSaveForm saveForm, BindingResult result){
        if(result.hasErrors()){
            throw new IllegalStateException("오류발생");
        }

        return userService.save(saveForm);
    }
}
