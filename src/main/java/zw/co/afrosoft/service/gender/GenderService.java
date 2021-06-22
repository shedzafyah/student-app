package zw.co.afrosoft.service.gender;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.afrosoft.domain.gender.Gender;
import zw.co.afrosoft.persistence.gender.GenderRepository;

@Service
@Transactional
public class GenderService {
	private GenderRepository genderRepo;
	
	@Autowired
	public GenderService(GenderRepository genderRepo) {
		this.genderRepo = genderRepo;
	}
	
	public void save(Gender gender) {
		genderRepo.save(gender);
	}
	
	public List<Gender> findAll() {
		return genderRepo.findAll();
	}
	
	public Gender findById(Long id) {
		return genderRepo.findById(id).get();
	}
	
	public void remove(Long id) {
		genderRepo.deleteById(id);
	}
	
}
