package zw.co.afrosoft.api.student;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zw.co.afrosoft.domain.student.Student;
import zw.co.afrosoft.service.student.StudentService;

@RestController
public class StudentController {

	private StudentService studentService;

	public StudentController() {
		
	}
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/liststudents")
	public List<Student> list() {
		return studentService.findAll();
	}
	
	@PostMapping("/addstudent")
	public void add(@RequestBody Student student) {
		studentService.save(student);
	}
	
	@DeleteMapping("/student/{id}")
	public void delete(@PathVariable Long id) {
		studentService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/student/{id}")
	public ResponseEntity<Student>name(@RequestBody Student student, @PathVariable Long id) {
		try {
			Student existingStudent = studentService.find(id);
			existingStudent.setFirstname(student.getFirstname());
			existingStudent.setLastname(student.getLastname());
			existingStudent.setAge(student.getAge());
			existingStudent.setGender(student.getGender());
			studentService.save(existingStudent);
			return new ResponseEntity<Student>(HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/student/{id}")
	public Student find(@PathVariable Long id){
		return studentService.find(id);
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/student/{age}")
	public List<Student> findbyAge(@PathVariable int age){
		return studentService.findByAge(age);
	}
	
}
