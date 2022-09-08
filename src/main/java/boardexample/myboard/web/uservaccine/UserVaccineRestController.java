package boardexample.myboard.web.uservaccine;


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
public class UserVaccineRestController {
    private final UserVaccineService userVaccineService;

    @GetMapping("/vaccine/{vaccineId}")
    public MyVaccineResponse findById(@PathVariable("vaccineId") Long id){
        return userVaccineService.findById(id);
    }

    @GetMapping("/vaccineList/{userId}")
    public Result findByUserAll(@PathVariable("userId") Long userId){
        List<MyVaccineResponse> userAllVaccine = userVaccineService.findByUserAllVaccine(userId);
        return new Result<>(userAllVaccine);
    }

    @PostMapping("/vaccine")
    public Long save(@RequestBody MyVaccineRequest request, HttpServletRequest servletRequest){
        HttpSession session = servletRequest.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        return userVaccineService.save(loginUser.getId(), request);
    }

    @PutMapping("/vaccine/{vaccineId}")
    public void update(@PathVariable("vaccineId") Long vaccineId, @RequestBody MyVaccineRequest request, HttpServletRequest servletRequest){
        HttpSession session = servletRequest.getSession(false);
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        userVaccineService.update(vaccineId, request, loginUser.getId());
    }

    @DeleteMapping("/vaccine/{vaccineId}")
    public void delete(@PathVariable("vaccineId") Long vaccineId, HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        userVaccineService.delete(vaccineId, loginUser.getId());
    }

}
