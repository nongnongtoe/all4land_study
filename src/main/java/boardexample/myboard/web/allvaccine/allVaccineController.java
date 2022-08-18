package boardexample.myboard.web.allvaccine;


import boardexample.myboard.domain.allvaccine.AllVaccine;
import boardexample.myboard.web.allvaccine.dto.vaccineSaveForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vaccine")
public class allVaccineController {
    private final allVaccineService vaccineService;

    @GetMapping("/add")
    public String addVaccineForm(@ModelAttribute("vaccine") vaccineSaveForm saveForm){
        return "vaccine/vaccineSave";
    }

    @PostMapping("/add")
    public String addVaccine(@ModelAttribute("vaccine") vaccineSaveForm saveForm){
        vaccineService.save(saveForm);

        return "redirect:/";
    }

    @GetMapping("/list")
    public String vaccineList(Model model){
        List<AllVaccine> vaccines = vaccineService.vaccineList();
        model.addAttribute("vaccines", vaccines);
        return "vaccine/vaccineList";
    }

    @GetMapping("/{vaccineId}/delete")
    public String deleteVaccine(@PathVariable("vaccineId") Long id){
        vaccineService.deleteVaccine(id);

        return "redirect:/vaccine/list";
    }
}
