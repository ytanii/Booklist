package ytanii.booklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ytanii.booklist.model.User;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

}
