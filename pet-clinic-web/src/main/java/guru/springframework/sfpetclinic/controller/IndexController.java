package guru.springframework.sfpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController
{
    @RequestMapping({"/", "/index", "/index.html"})
    public String index()
    {
        System.out.println("Showing index page");
        return "index";
    }
}
