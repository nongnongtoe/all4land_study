package boardexample.myboard.web.allvaccine;


import boardexample.myboard.domain.allvaccine.AllVaccine;
import boardexample.myboard.web.allvaccine.dto.updateVaccineForm;
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
        return "vaccineAddForm";
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
        return "vaccines";
    }
    @GetMapping("/{vaccineId}/edit")
    public String updateForm(@PathVariable("vaccineId")Long id
            , Model model){
        AllVaccine vaccine = vaccineService.findVaccine(id);
        int start=vaccine.getStartVaccine();
        int end=vaccine.getEndVaccine();
        String title=vaccine.getTitle();
        updateVaccineForm form = new updateVaccineForm(start, end, title);
        model.addAttribute("vaccine", form);
        return "vaccine/vaccineEdit";
    }

    @PostMapping("/{vaccineId}/edit")
    public String updateVaccine(@PathVariable("vaccineId")Long id
            , @ModelAttribute("vaccine")updateVaccineForm vaccineForm){
        vaccineService.updateVaccine(id, vaccineForm);
        return "redirect:/vaccine/list";
    }

    @GetMapping("/{vaccineId}/delete")
    public String deleteVaccine(@PathVariable("vaccineId") Long id){
        vaccineService.deleteVaccine(id);

        return "redirect:/vaccine/list";
    }
}
