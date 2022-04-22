package uz.pdp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entitiy.Role;
import uz.pdp.entitiy.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRoleName(RoleName roleName);
}
