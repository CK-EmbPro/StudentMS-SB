package net.springbootcourse.springBootDemo.Repository;

import net.springbootcourse.springBootDemo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
