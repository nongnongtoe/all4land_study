package boardexample.myboard.web.uservaccine;


import boardexample.myboard.web.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Long save(@RequestBody MyVaccineRequest request){
        return userVaccineService.save(request.getUser().getId(), request);
    }

    @PutMapping("/vaccine/{vaccineId}")
    public void update(@PathVariable("vaccineId") Long vaccineId, @RequestBody MyVaccineRequest request){
        userVaccineService.update(vaccineId, request);
    }

    @DeleteMapping("/vaccine/{vaccineId}")
    public void delete(@PathVariable("vaccineId") Long vaccineId){
        userVaccineService.delete(vaccineId);
    }

}
