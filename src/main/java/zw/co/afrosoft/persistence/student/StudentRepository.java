package zw.co.afrosoft.persistence.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import zw.co.afrosoft.domain.student.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query(value = "SELECT s FROM Student s WHERE s.lastname=:lastname")
	public List<Student> findByLastname(@Param("lastname") String lastname);
	
	@Query(name = "findByAge",value = "SELECT s FROM Student s WHERE s.age=:age")
	public List<Student> findByAge(@Param("age") int age );
	
}
