package com.kgl1688.mvc;

import com.kgl1688.entity.User;
import com.kgl1688.service.UserService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<?> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value="/users", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody User user) {

        return userService.createUser(user);

    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@RequestBody User user, @PathVariable int id) {
        userService.updateUser(user);
        return user;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteUser(@PathVariable int id) throws NotFoundException{
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
