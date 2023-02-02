package boardexample.myboard.web.allvaccine;


import boardexample.myboard.web.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vaccineApi")
public class allVaccineRestController {
    private final allVaccineService vaccineService;


    @GetMapping
    public Result findAllVaccine(){
        List<allVaccineResponse> allVaccine = vaccineService.findAllVaccine();
        return new Result<>(allVaccine);
    }

    @GetMapping("/searchVaccine")
    public Result findBySearchVaccineList(RequestVaccineDto requestVaccineDto){
        List<allVaccineResponse> vaccineList = vaccineService.findBySearchVaccineList(requestVaccineDto);
        return new Result<>(vaccineList);
    }


}
