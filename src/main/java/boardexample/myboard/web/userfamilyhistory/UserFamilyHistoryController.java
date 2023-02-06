package boardexample.myboard.web.userfamilyhistory;


import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/myFamily")
@RequiredArgsConstructor
public class UserFamilyHistoryController {
    private final UserFamilyHistoryService userFamilyHistoryService;

    @GetMapping
    public String UserFamilyHistoryPage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        List<UserFamilyResponse> familyHistory = userFamilyHistoryService.findByUserAllFamilyHistory(loginUser.getId());

        model.addAttribute("historyList", familyHistory);
        return "myFamily";
    }

    @GetMapping("/add")
    public String UserFamilyAddPage(){


        return "myFamilyAdd";
    }

    @PostMapping("/add")
    public String UserFamilySave(@ModelAttribute("form")UserFamilyRequest form, HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);

        userFamilyHistoryService.save(loginUser.getId(), form);
        return "redirect:/myFamily";
    }

    @PostMapping("/update")
    public String userFamilyUpdate( Model model, UserFamilyResponse form
    ,HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        userFamilyHistoryService.update(form.getId(), form, loginUser.getId());
        return "redirect:/myFamily";
    }

    @GetMapping("/{myFamilyId}/delete")
    public String userFamilyDelete(@PathVariable("myFamilyId") Long myFamilyId, HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        userFamilyHistoryService.delete(myFamilyId, loginUser.getId());
        return "redirect:/myFamily";
    }

}
