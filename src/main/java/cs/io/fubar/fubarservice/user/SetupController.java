package cs.io.fubar.fubarservice.user;

import cs.io.fubar.fubarservice.entity.AppRole;
import cs.io.fubar.fubarservice.entity.AppUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/setup")
public class SetupController {
    Logger log = LogManager.getLogger(SetupController.class);

    @Autowired
    RoleService roleService;

    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    UserService userService;

    @GetMapping("/init")
    public String createTestData() {

        clearTestData();

        AppRole role1 = new AppRole("Admin");
        role1 = roleService.save(role1);
        AppUser user11 = new AppUser("Deiveehan", "Nallazhagappan", "deiveehan@gmail.com","deivee", "deivee", role1);
        userService.saveUser(user11);

        AppRole role2 = new AppRole("Chef");
        role2 = roleService.save(role2);
        AppUser user21 = new AppUser("Jayashree", "Nagaprabhu", "jayashreenagaprabhu@gmail.com", "jaya", "jaya", role2);
        userService.saveUser(user21);
        AppUser user22 = new AppUser("Vasantha", "Deiveehan", "vasanthadeiveehan@gmail.com","devi", "devi", role2);
        userService.saveUser(user22);

        AppRole role3 = new AppRole("User");
        role3 = roleService.save(role3);
        AppUser user31 = new AppUser("Benny", "Chacko", "bennychacko@gmail.com","benny", "benny", role3);
        userService.saveUser(user31);

        log.info("Test data created !!");
        return "Test data created..";
    }

    @Transactional
    @RequestMapping("/clear")
    public void clearTestData() {
        appRoleRepository.deleteAll();
        appUserRepository.deleteAll();
    }
}
