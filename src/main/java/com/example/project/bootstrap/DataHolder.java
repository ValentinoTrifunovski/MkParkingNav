package com.example.project.bootstrap;

import com.example.project.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(new User("kostadin.mishev", "km", "Kostadin", "Mishev"));
        users.add(new User("riste.stojanov", "rs", "Riste", "Stojanov"));
        users.add(new User("stefan.popov", "sp", "Stefan", "Popov"));
    }

}
