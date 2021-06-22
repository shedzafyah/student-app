package zw.co.afrosoft.api.gender;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zw.co.afrosoft.domain.gender.Gender;
import zw.co.afrosoft.service.gender.GenderService;
@RestController
public class GenderController {
	
	private GenderService genderService;

	@Autowired
	public GenderController(GenderService genderService) {
		this.genderService = genderService;
	}
	
	@GetMapping("/listgender")
	public List<Gender> listall(){
		return genderService.findAll();
		
	}
	
	@PostMapping("/addgender")
	public void add(@RequestBody Gender gender) {
		genderService.save(gender);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/gender/{id}")
	public void delete(@PathVariable Long id) {
		genderService.remove(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/gender/{id}")
	public ResponseEntity<Gender> update(@RequestBody Gender gender, @PathVariable Long id){
		try {
			Gender existingGender = genderService.findById(id);
			existingGender.setName(gender.getName());
			genderService.save(existingGender);
			return new ResponseEntity<Gender>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Gender>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
