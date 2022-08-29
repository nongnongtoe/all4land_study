package boardexample.myboard.web.childfamilyhistory;


import boardexample.myboard.web.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/child")
public class ChildFamilyHistoryRestController {

    private final ChildFamilyHistoryService childFamilyHistoryService;

    @GetMapping("/history/{id}")
    public ChildFamilyHistoryResponse findById(@PathVariable Long id){
        return childFamilyHistoryService.findById(id);
    }

    @GetMapping("/historyList/{childId}")
    public Result findAll(@PathVariable Long childId){
        List<ChildFamilyHistoryResponse> historyList = childFamilyHistoryService.findByChildAllHistory();
        return new Result(historyList);
    }

    @PostMapping("/history")
    public Long save(@RequestBody ChildFamilyHistoryRequest request){
        return childFamilyHistoryService.save(request.getChild().getId(), request);
    }

    @PutMapping("/history/{id}")
    public void update(@PathVariable Long id, @RequestBody ChildFamilyHistoryRequest request){
        childFamilyHistoryService.update(id, request);
    }

    @DeleteMapping("/history/{id}")
    public void delete(@PathVariable Long id){
        childFamilyHistoryService.delete(id);
    }


}
