package in.sandesh.expensetrackerapp.repository;

import in.sandesh.expensetrackerapp.enitites.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;




@Repository



public interface RoleRepository extends JpaRepository<UserRole, Long> {
  Optional<UserRole> findByName(String name);
}
