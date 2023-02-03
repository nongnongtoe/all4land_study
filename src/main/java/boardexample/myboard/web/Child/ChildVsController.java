package boardexample.myboard.web.Child;

import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/childrenVs")
public class ChildVsController {
    private final ChildService childService;

    @GetMapping
    public String childListPage(Model model, HttpServletRequest request){
        User user = getUser(request);
        List<ChildResponse> child = childService.findByUserAllChild(user.getId());
        model.addAttribute("child", child);
        return "childrenVs";
    }

    @GetMapping("/add")
    public String childAddPage(){
        return "childrenAddVs";
    }


    @PostMapping("/add")
    public String childAdd(ChildRequest childRequest ,HttpServletRequest request){
        User user = getUser(request);
        childService.save(user.getId(), childRequest);
        return "redirect:/childrenVs";
    }


    private User getUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute(SessionConst.LOGIN_USER);
        return user;
    }
}
