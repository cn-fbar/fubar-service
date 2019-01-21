package cs.io.fubar.fubarservice.user;

import cs.io.fubar.fubarservice.entity.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

//    final static Logger logger = Logger.getLogger(RoleService.class);

    @Autowired
    AppRoleRepository roleRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public List<AppRole> getAppRoles() {
        List<AppRole> roles = (List<AppRole>) roleRepository.findAll();
        for (int i = 0; i < roles.size(); i++) {
//            logger.info("App role : " + roles);
        }
        return roles;
    }

    public Optional<AppRole> getAppRole(@PathVariable String id) {
        Optional<AppRole> role = roleRepository.findById(Long.parseLong(id));
//        logger.info("App roles : " + role);
        return role;
    }

    @Transactional
    public AppRole save(@RequestBody AppRole appAppRole) {
        roleRepository.save(appAppRole);
//        logger.info("App role info modified : " + appAppRole);
        return appAppRole;
    }


    public AppRole deleteAppRole(@RequestBody AppRole appAppRole) {
        roleRepository.delete(appAppRole);
//        logger.info("App role info deleted : " + appAppRole);
        return appAppRole;
    }

    public String clearRoles() {
        List<AppRole> approles = (List<AppRole>) roleRepository.findAll();
        for (AppRole a:approles
                ) {
            roleRepository.delete(a);
        }
        return "Roles";
    }
}
