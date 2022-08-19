package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    User findByEmail(String email);
    boolean findByIdIsBefore(Integer id);
    User findByEmailAndPassword(String email,String password);

}
