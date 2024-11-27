package lk.ijse.gdse.aad68.NoteTakerV2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("api/v1/welcome")
public class WelcomeController {

    @GetMapping
    public String welcome(Model model) {
        //data pass karnawa view ekt
        model.addAttribute("message", "Welcome to Note Taker V2");
        return "welcome";
    }
}
