package boardexample.myboard.web.userfamilyhistory;


import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
