package com.example.repository;

import com.example.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    List<Employee> findByAgeIn(List<Integer> ages);
    List<Employee> findByAgeBetween(Integer min, Integer max);
    List<Employee> findByAge(Integer age);
    List<Employee> findByAgeOrderByFirstNameDesc(Integer age);

    long countByAgeAfter(Integer age);

    @Query(value = "SELECT e FROM Employee e WHERE e.age IN :ages")
    List<Employee> findByAgeInQuery(@Param("ages") List<Integer> ages);

    @Query("""
        SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END
        FROM Employee e 
        WHERE lower(e.firstName) LIKE lower(:firstName) 
    """)
    boolean existsByEmailLikeQuery(@Param("firstName") String firstName);

    @Query(nativeQuery = true, value = "SELECT * FROM employees e WHERE e.married = true")
    List<Employee> findAllByMarriedTrueQuery();

    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.married = false WHERE e.birthDate > :birthDate")
    void updateMarriedToFalseByBirthDateAfterQuery(@Param("birthDate") LocalDate birthDate);

}
