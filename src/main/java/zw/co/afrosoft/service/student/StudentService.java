package zw.co.afrosoft.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.afrosoft.domain.student.Student;
import zw.co.afrosoft.persistence.student.StudentRepository;

@Service
@Transactional
public class StudentService {
	
	private StudentRepository studentRepo;

	@Autowired
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public void save(Student student) {
		studentRepo.save(student);
	}
	
	public Student find(Long id) {
		return studentRepo.findById(id).get();
	}
	
	public List<Student> findAll(){
		return studentRepo.findAll();
	}
	
	public void delete(Long id) {
		studentRepo.deleteById(id);
	}
	
	public List<Student> findByAge(int age){
		return studentRepo.findByAge(age);
	}
	
}
