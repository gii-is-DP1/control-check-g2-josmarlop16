package org.springframework.samples.petclinic.feeding;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feeding")
public class FeedingController {

    @Autowired FeedingService feedingService;
    @Autowired PetService petService;

    private static final String VIEWS_FEEDING_CREATE_OR_UPDATE_FORM = "feedings/createOrUpdateFeedingForm";

    @GetMapping(path = "/create")
    public String initCreationForm(ModelMap modelMap) {
        String view = VIEWS_FEEDING_CREATE_OR_UPDATE_FORM;
        modelMap.addAttribute("feeding", new Feeding());
        modelMap.addAttribute("feedingTypes", feedingService.getAllFeedingTypes());
        modelMap.addAttribute("pets", petService.getAllPets());
        return view;
    }


    //LO INTENTE PERO NO TENIA CLARO COMO CONTINUAR...
    /*
    @PostMapping(path = "create")
    public String processCreationForm(@Valid Feeding feeding, BindingResult result, ModelMap modelMap) throws UnfeasibleFeedingException {
        String view = "welcome";
        if (result.hasErrors()) {
            modelMap.addAttribute("feeding", feeding);
            modelMap.addAttribute("feedingType", feedingService.getAllFeedingTypes());
            return VIEWS_FEEDING_CREATE_OR_UPDATE_FORM;
        } else {
            feedingService.save(feeding);
            modelMap.addAttribute("message", "Feeding succesfully saved!");
        }
        return view;
    }
    */
    
    
}
