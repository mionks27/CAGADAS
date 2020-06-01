package sw2.lab5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sw2.lab5.Entity.Usuario;
import sw2.lab5.Repository.UsusarioRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UsusarioRepository ususarioRepository;

    @GetMapping(value = {"","/list"})
    public String listar(Model model){
        model.addAttribute("lista",ususarioRepository.findAll());
        return "User/list";
    }

    @PostMapping("guardar")
    public String guardarEmployee(@ModelAttribute("user") @Valid Usuario user, BindingResult bindingResult, RedirectAttributes attr, Model model) {

        if (bindingResult.hasErrors()){
            return "employee/form";
        }else{
            if (user.getId_user() == 0) {
                attr.addFlashAttribute("msg", "Empleado creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Empleado actualizado exitosamente");
            }
            ususarioRepository.save(user);
            return "redirect:/user/list";
        }
    }


    @GetMapping("editar")
    public String editarEmployee(@ModelAttribute("user")  Usuario user,Model model, @RequestParam("id") int id) {
        Optional<Usuario> user1 = ususarioRepository.findById(id);
        if (user1.isPresent()) {
            user = user1.get();
            model.addAttribute("user", user);
            return "User/form";
        } else {
            return "redirect:/user/list";
        }
    }

    @GetMapping("perfil")
    public String editarPerfil(@ModelAttribute("user")  Usuario user,Model model, @RequestParam("id") int id) {
        Optional<Usuario> user1 = ususarioRepository.findById(id);
        if (user1.isPresent()) {
            user = user1.get();
            model.addAttribute("user", user);
            return "User/form";
        } else {
            return "redirect:/user/list";
        }
    }

    @GetMapping("borrar")
    public String borrarEmpleado(@RequestParam("id") int id, RedirectAttributes attr) {
        Optional<Usuario> usuario1 = ususarioRepository.findById(id);
        if (usuario1.isPresent()) {
            ususarioRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Borrado exitosamente");
        }


        return "redirect:/employee/lista";
    }




}
