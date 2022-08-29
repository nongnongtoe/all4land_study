package boardexample.myboard.web.Child;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.web.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/child/user/{userId}")
    public Result findAll(@PathVariable("userId") Long userId){
        List<ChildResponse> userAllChild = childService.findByUserAllChild(userId);
        return new Result(userAllChild);
    }

    //저장
    @PostMapping("/child")
    public Long save(@RequestBody ChildRequest request){
        return childService.save(request.getUser().getId(),request);
    }

    //업데이트
    @PutMapping("/child/{id}")
    public void updateChild(@PathVariable("id") Long id, @RequestBody ChildRequest request){
        childService.update(id, request.getName());
    }

    //삭제
    @DeleteMapping("/child/{id}")
    public void deleteChild(@PathVariable("id") Long id){
        childService.delete(id);
    }
}
