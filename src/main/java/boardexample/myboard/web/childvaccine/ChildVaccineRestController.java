package boardexample.myboard.web.childvaccine;


import boardexample.myboard.web.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/child")
public class ChildVaccineRestController {
    private final ChildVaccineService childVaccineService;

    @GetMapping("/vaccine/{vaccineId}")
    public VaccineResponse findOne(@PathVariable("vaccineId") Long vaccineId){
        return childVaccineService.findById(vaccineId);
    }

    @GetMapping("/vaccineList/{childId}")
    public Result findByChildAllVaccine(@PathVariable Long childId){
        List<VaccineResponse> vaccine = childVaccineService.findByChildAllVaccine(childId);
        return new Result(vaccine);
    }

    @PostMapping("/vaccine")
    public Long save(@RequestBody VaccineRequest request){
        return childVaccineService.save(request.getChild().getId(), request);
    }



    @DeleteMapping("/vaccine/{vaccineId}")
    public void delete(@PathVariable Long vaccineId){
        childVaccineService.delete(vaccineId);
    }
}
