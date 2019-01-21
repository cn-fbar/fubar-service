package cs.io.fubar.fubarservice.user;

import cs.io.fubar.fubarservice.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public List<AppUser> getUsers() {
        List<AppUser> appUserList = new ArrayList<AppUser>();
        appUserList = (List<AppUser> ) appUserRepository.findAll();
        return appUserList;
    }

    public AppUser getUser(long id) {
        AppUser appUser = null;
        Optional<AppUser> appUserOptional = appUserRepository.findById(Long.valueOf(id));
        appUser = appUserOptional.get();
        return appUser;
    }

    public AppUser saveUser(AppUser appUser) {
        AppUser appUserUpdated = null;
        appUserUpdated = appUserRepository.save(appUser);
        return appUserUpdated;
    }

    public void deleteUser(AppUser appUser) {
        appUserRepository.delete(appUser);
    }
}