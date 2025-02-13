package web.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.example.model.User;
import web.example.service.UserService;

@Controller
public class UserController {
    private static final String REDIRECT_USERS = "redirect:/users";
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return REDIRECT_USERS;
    }

    @GetMapping(value = "/users")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping(value = "/users/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping(value = "users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/users")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return REDIRECT_USERS;
    }

    @GetMapping(value = "/users/edit")
    public String edit(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id == null) {
            return REDIRECT_USERS;
        }
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PostMapping(value = "/users/update")
    public String update(@RequestParam("id") int id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return REDIRECT_USERS;
    }

    @PostMapping(value = "/users/delete")
    public String delete(@RequestParam("id") int id) {
        userService.removeUserById(id);
        return REDIRECT_USERS;
    }
}