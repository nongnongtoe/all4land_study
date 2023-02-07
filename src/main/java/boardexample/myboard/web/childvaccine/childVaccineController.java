package boardexample.myboard.web.childvaccine;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/childVaccine")
public class childVaccineController {

    private final ChildVaccineService childVaccineService;

    @GetMapping("/{childId}")
    public String childVaccineListPage(@PathVariable("childId") Long childId, Model model){
        List<VaccineResponse> vaccineList = childVaccineService.findByChildAllVaccine(childId);

        model.addAttribute("vaccineList", vaccineList);
        model.addAttribute("childId", childId);
        return "childrenVaccineList";
    }

    @GetMapping("/{childId}/add")
    public String childVaccineListAddPage(@PathVariable("childId") Long childId, Model model){
        model.addAttribute("childId", childId);
        return "childrenVaccineAdd";
    }

    @PostMapping("/{childId}/add")
    public String childVaccineListAdd(@PathVariable("childId") Long childId, Model model, VaccineRequest request){
        childVaccineService.save(childId, request);
        return "redirect:/childVaccine/" + childId;
    }

    @PostMapping("/edit/{childId}")
    public String childVaccineEdit(@PathVariable("childId") Long childId,Model model, VaccineRequest request){
        childVaccineService.update(request.getId(), request, childId);
        return "redirect:/";
    }

    @GetMapping("/{childVaccineId}/delete")
    public String deleteChildVaccineList(@PathVariable("childVaccineId") Long childVaccineId){
        childVaccineService.delete(childVaccineId);

        return "redirect:/";
    }
}
