package sw2.lab5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sw2.lab5.Repository.PostRepository;

@Controller
public class HomeController {

    @Autowired
    PostRepository postRepository;

    @GetMapping(value = "/")
    public String home() {
        return "redirect:/posts";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("lista", postRepository.findAll());
        return "index";
    }
}