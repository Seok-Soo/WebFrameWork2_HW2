package kr.ac.hansung.cse.hellospringdatajpa.repo;

import kr.ac.hansung.cse.hellospringdatajpa.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Integer>
{
    Optional<MyUser> findByEmail(String email);


    @Query(value = """
    SELECT u.* FROM users u
    JOIN user_role ur ON u.id = ur.user_id
    WHERE ur.role_id = :roleId
    """, nativeQuery = true)
    List<MyUser> findUsersByRoleId(@Param("roleId") Long roleId);
}