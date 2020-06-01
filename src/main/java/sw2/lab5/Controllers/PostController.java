package sw2.lab5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sw2.lab5.Repository.PostRepository;

@Controller
@RequestMapping(value ="/posts")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("")
    public String principal(Model model){
        model.addAttribute("lista", postRepository.findAll());
        return "index";
    }

    public String borrar(@RequestParam("id") int id, Model model){
        model.addAttribute("lista", postRepository.findAll());
        return "index";
    }

}
