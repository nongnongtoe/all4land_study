package boardexample.myboard.web.allvaccine;


import boardexample.myboard.web.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vaccineApi")
public class allVaccineRestController {
    private final allVaccineService vaccineService;

    @GetMapping("/{id}")
    public allVaccineResponse findById(@PathVariable Long id){
        return vaccineService.findById(id);
    }

    @GetMapping
    public Result findAllVaccine(){
        List<allVaccineResponse> allVaccine = vaccineService.findAllVaccine();
        return new Result<>(allVaccine);
    }


}
