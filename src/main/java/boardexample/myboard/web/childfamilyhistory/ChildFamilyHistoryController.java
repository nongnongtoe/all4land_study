package boardexample.myboard.web.childfamilyhistory;


import boardexample.myboard.domain.familydiseasehistory.ChildFamilyHistory;
import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/childrenHistory")
public class ChildFamilyHistoryController {
    private final ChildFamilyHistoryService childFamilyHistoryService;

    @GetMapping("/{childId}")
    public String createChildHistoryPage(@PathVariable("childId") Long childId, Model model, HttpServletRequest request){

        List<ChildFamilyHistory> historyList = childFamilyHistoryService.findByChildIdHistoryList(childId);

        model.addAttribute("historyList", historyList);
        return "childrenHistoryList";
    }


    @GetMapping("/{childId}/add")
    public String createChildHistoryAddPage(@PathVariable("childId") Long childId, Model model){
        model.addAttribute("childId", childId);
        return "childrenHistoryAdd";
    }

    @PostMapping("/{childId}/add")
    public String createChildHistoryAdd(@PathVariable("childId") Long childId, ChildFamilyHistoryRequest request,Model model){
        childFamilyHistoryService.save(childId, request);
        return "redirect:/";
    }

    @PostMapping("/edit/{childId}")
    public String updateChildHistory(@PathVariable("childId") Long childId, ChildFamilyHistoryRequest request){

        childFamilyHistoryService.update(request.getId(), request,childId);
        return "redirect:/childrenHistory/" + childId ;
    }

    @GetMapping("/{childHistoryId}/delete")
    public String deleteChildHistory(@PathVariable("childHistoryId") Long childHistoryId){

        childFamilyHistoryService.delete(childHistoryId);
        return "redirect:/";
    }
}
