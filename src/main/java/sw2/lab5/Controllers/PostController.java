package sw2.lab5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sw2.lab5.Entity.Post;
import sw2.lab5.Repository.PostRepository;

import java.util.Optional;

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

    @GetMapping("borrar")
    public String borrar(@RequestParam("id") int id, Model model, RedirectAttributes attr){
        Optional<Post> opt = postRepository.findById(id);
        if (opt.isPresent()){
            attr.addFlashAttribute("msg", "Post eliminado exitósamente");
            postRepository.deleteById(id);
        }
        return "redirect:/posts";
    }

    @GetMapping("crear")
    public String nuevo(@ModelAttribute("post") Post post){
        return "post/Form";
    }
}
