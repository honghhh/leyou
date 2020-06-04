package com.leyou.page.web;

import com.leyou.page.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String toHello(Model model) {
        model.addAttribute("msg", "hello, Thymeleaf");
        return "hello";
    }

    @GetMapping("show2")
    public String show2(Model model){
        User user = new User();
        user.setAge(21);
        user.setName("Jack Chen");
        user.setFriend(new User("李小龙", 30, null));
        model.addAttribute("user", user);

        List<User> list = new ArrayList<>();
        User user2 = new User();
        user2.setAge(21);
        user2.setName("Jack Chen21");
        user2.setFriend(new User("李小龙21", 30, null));
        list.add(user2);
        User user3 = new User();
        user3.setAge(21);
        user3.setName("Jack Chen22");
        user3.setFriend(new User("李小龙22", 30, null));
        list.add(user3);
        model.addAttribute("list", list);
        return "show2";
    }
}
