package boardexample.myboard.web.Child;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.dto.Result;
import boardexample.myboard.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChildRestController {
    private final ChildService childService;

    //단건조회
    @GetMapping("/child/{id}")
    public ChildResponse findOne(@PathVariable("id") Long id){
        return childService.findById(id);
    }

    //전체조회
    @GetMapping("/child/user")
    public Result findAll(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute(SessionConst.LOGIN_USER);
        List<ChildResponse> userAllChild = childService.findByUserAllChild(user.getId());
        return new Result(userAllChild);
    }

    //저장
    @PostMapping("/child")
    public Long save(@RequestBody ChildRequest request, HttpServletRequest servletRequest){
        HttpSession session = servletRequest.getSession(false);
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        return childService.save(loginUser.getId(), request);
    }

    //업데이트
    @PutMapping("/child/{id}")
    public void updateChild(@PathVariable("id") Long id, @RequestBody ChildRequest request, HttpServletRequest servletRequest){
        HttpSession session = servletRequest.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        childService.update(id, request.getName(), loginUser.getId());
    }

    //삭제
    @DeleteMapping("/child/{id}")
    public void deleteChild(@PathVariable("id") Long id, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        childService.delete(id, loginUser.getId());
    }
}
