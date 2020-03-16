package guru.springframework.sfpetclinic.controller;

import guru.springframework.sfpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners")
public class OwnerController
{
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService)
    {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model)
    {
        model.addAttribute("owners", this.ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners()
    {
        return "notimplemented";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") long ownerId)
    {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.ownerService.findById(ownerId));
        return mav;
    }
}
