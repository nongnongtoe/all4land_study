package boardexample.myboard.web.userfamilyhistory;


import boardexample.myboard.web.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/familyhistorylist/{userId}")
    public Result findByUserAllHistoryList(@PathVariable("userId") Long userId){
        List<UserFamilyResponse> familyHistory = userFamilyHistoryService.findByUserAllFamilyHistory(userId);
        return new Result(familyHistory);
    }

    @PostMapping("/familyhistory")
    public Long save(@RequestBody UserFamilyRequest request){
        return userFamilyHistoryService.save(request);
    }

    @PutMapping("/familyhistory/{familyId}")
    public void update(@PathVariable("familyId") Long id, @RequestBody UserFamilyRequest request){
        userFamilyHistoryService.update(id, request);
    }


    @DeleteMapping("/familyhistory/{familyId}")
    public void delete(@PathVariable("familyId") Long id){
        userFamilyHistoryService.delete(id);
    }


}
