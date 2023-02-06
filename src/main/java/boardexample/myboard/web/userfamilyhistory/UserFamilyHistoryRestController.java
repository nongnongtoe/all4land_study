package boardexample.myboard.web.userfamilyhistory;


import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.dto.Result;
import boardexample.myboard.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserFamilyHistoryRestController {
    private final UserFamilyHistoryService userFamilyHistoryService;

    @GetMapping("/familyhistory/{familyId}")
    public UserFamilyResponse findById(@PathVariable("familyId") Long id){
        return userFamilyHistoryService.findById(id);
    }

    @GetMapping("/familyhistorylist")
    public Result findByUserAllHistoryList(HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        List<UserFamilyResponse> familyHistory = userFamilyHistoryService.findByUserAllFamilyHistory(loginUser.getId());
        return new Result(familyHistory);
    }

    @PostMapping("/familyhistory")
    public Long save(@RequestBody UserFamilyRequest request, HttpServletRequest servletRequest){
        HttpSession session = servletRequest.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        return userFamilyHistoryService.save(loginUser.getId(), request);
    }



    @DeleteMapping("/familyhistory/{familyId}")
    public void delete(@PathVariable("familyId") Long id, HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        userFamilyHistoryService.delete(id, loginUser.getId());
    }


}
