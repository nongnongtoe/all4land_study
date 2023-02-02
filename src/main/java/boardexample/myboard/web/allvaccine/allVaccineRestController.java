package boardexample.myboard.web.allvaccine;


import boardexample.myboard.web.dto.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vaccineApi")
@Slf4j
public class allVaccineRestController {
    private final allVaccineService vaccineService;


    @GetMapping
    public Result findAllVaccine(){
        List<allVaccineResponse> allVaccine = vaccineService.findAllVaccine();
        return new Result<>(allVaccine);
    }

    @PostMapping("/searchVaccine")
    public List<allVaccineResponse> findBySearchVaccineList(RequestVaccineDto requestVaccineDto){
        List<allVaccineResponse> vaccineList = vaccineService.findBySearchVaccineList(requestVaccineDto);
        log.info(String.valueOf(vaccineList));
        return vaccineList;
    }


}
