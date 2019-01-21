package cs.io.fubar.fubarservice.user;

import cs.io.fubar.fubarservice.entity.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AppRole getAppRole(@PathVariable String id) {
        Optional<AppRole> role = roleService.getAppRole(id);

        AppRole appRoleuser = role.get();
        return appRoleuser;
    }

    @RequestMapping("/roles")
    public List<AppRole> getAppRoles() {
        List<AppRole> roles = (List<AppRole>) roleService.getAppRoles();
        for (int i = 0; i < roles.size(); i++) {
            System.out.println("App role : " + roles);
        }
        return roles;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public AppRole updateAppRole(@RequestBody AppRole appAppRole) {
        roleService.save(appAppRole);
        System.out.println("App role info modified : " + appAppRole);
        return appAppRole;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public AppRole deleteAppRole(@RequestBody AppRole appAppRole) {
        roleService.deleteAppRole(appAppRole);
        System.out.println("App role info deleted : " + appAppRole);
        return appAppRole;
    }

    @RequestMapping(method = RequestMethod.POST)
    public AppRole createAppRole(@RequestBody AppRole appAppRole) {
        roleService.save(appAppRole);
        System.out.println("App role info saved : " + appAppRole);
        return appAppRole;
    }

    @RequestMapping("/getTestMessage")
    public String getTestMessage() {
        return "TestMessage";
    }
}
