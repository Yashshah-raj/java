package navkar.jewels.com.navkar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import navkar.jewels.com.navkar.domain.PatientDetails;

public interface PatientDetailsRepo extends JpaRepository<PatientDetails, Integer> {

}
