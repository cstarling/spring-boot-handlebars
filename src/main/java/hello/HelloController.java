package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "World");
        return "hello";
    }


    @RequestMapping("/test")
    public ModelAndView test(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        //model.addAttribute("name", "World");

        modelAndView.setViewName("hello");
        modelAndView.addObject("name", null);
        return modelAndView;
    }

}