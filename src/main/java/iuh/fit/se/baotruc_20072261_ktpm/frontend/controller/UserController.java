package iuh.fit.se.baotruc_20072261_ktpm.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import iuh.fit.se.baotruc_20072261_ktpm.backend.models.User;
import iuh.fit.se.baotruc_20072261_ktpm.backend.service.UserService;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public String login(Model model, @RequestParam("email") String email, @RequestParam("password") String passWord){
//        Optional<User> loginAccount = userService.findByEmailAndPasswordHash(email,passWord);
//        if(loginAccount.isEmpty()){
//            model.addAttribute("loginStatus", false);
//        }
//        else{
//            model.addAttribute("loginAccount", loginAccount);
//            return "/home";
//        }
//        return "/index";
//    }
//    @GetMapping("/home")
//    public String home(Model model){
//        return "/home";
//    }
}