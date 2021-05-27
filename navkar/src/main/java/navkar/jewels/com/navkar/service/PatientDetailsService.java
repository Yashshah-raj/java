package navkar.jewels.com.navkar.service;

import navkar.jewels.com.navkar.DTO.PatientDetailsRequestDto;

public interface PatientDetailsService {

	public String generateBillAndSavePatient(PatientDetailsRequestDto patientDetailsRequestDto) throws Exception;
}
