package zw.co.afrosoft.persistence.gender;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.afrosoft.domain.gender.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long>{

}
