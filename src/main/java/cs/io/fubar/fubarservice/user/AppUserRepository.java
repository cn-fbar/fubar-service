package cs.io.fubar.fubarservice.user;


import cs.io.fubar.fubarservice.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
}
