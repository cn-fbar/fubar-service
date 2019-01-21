package cs.io.fubar.fubarservice.user;


import cs.io.fubar.fubarservice.entity.AppUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger log = LogManager.getLogger(SetupController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<AppUser> getUsers() {
        List<AppUser> appUserList = new ArrayList<AppUser>();
        appUserList = (List<AppUser> ) userService.getUsers();
        return appUserList;
    }

    @RequestMapping("/{id}")
    public AppUser getUser(@PathVariable long id) {
        AppUser appUser = userService.getUser(id);
        return appUser;
    }

    @RequestMapping(method = RequestMethod.POST)
    public AppUser saveUser(@RequestBody AppUser appUser) {
        AppUser appUserUpdated = null;
        appUserUpdated = userService.saveUser(appUser);
        return appUserUpdated;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public AppUser updateUser(@RequestBody AppUser appUser) {
        AppUser appUserUpdated = null;
        appUserUpdated = userService.saveUser(appUser);
        return appUserUpdated;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody AppUser appUser) {
        userService.deleteUser(appUser);
    }

    @RequestMapping("/sayHi/{name}")
    public String sayHiTestDistTracing(@PathVariable String name) {
        log.info("Hi.. " + name);
        return "Value returned from controller: " + name;
    }
}
