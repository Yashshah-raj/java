package navkar.jewels.com.navkar.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import navkar.jewels.com.navkar.DTO.PatientDetailsRequestDto;
import navkar.jewels.com.navkar.domain.PatientDetails;
import navkar.jewels.com.navkar.repository.PatientDetailsRepo;
import navkar.jewels.com.navkar.service.PatientDetailsService;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {

	@Autowired
	private PatientDetailsRepo patientDetailsRepo;
	@Override
	public String generateBillAndSavePatient(PatientDetailsRequestDto patientDetailsRequestDto) throws Exception {
		
		Integer discount=10;
		Double netBillAmount=0.0;
		Double billPerDay=patientDetailsRequestDto.getBillPerDay();
		Double totalBillAmount=billPerDay*Double.parseDouble(patientDetailsRequestDto.getNumberOfHospitalized());
		if(totalBillAmount>100000)
		{
			discount=10;
			netBillAmount=totalBillAmount-((totalBillAmount*discount)/100);
		}else if(totalBillAmount>100000)
		{
			discount=20;
			netBillAmount=totalBillAmount-((totalBillAmount*discount)/100);
		}else {
			discount=25;
			netBillAmount=totalBillAmount-((totalBillAmount*discount)/100);
		}
		//netBillAmount=netBillAmount*Double.parseDouble(patientDetailsRequestDto.getNumberOfHospitalized());
		PatientDetails patientDetails=new PatientDetails();
		patientDetails.setBillPerDay(billPerDay);
		patientDetails.setDiscount(discount);
		patientDetails.setMobileNumber(patientDetailsRequestDto.getMobileNumber());
		patientDetails.setNetBillAmount(netBillAmount);
		patientDetails.setNumberOfHospitalized(patientDetailsRequestDto.getNumberOfHospitalized());
		patientDetails.setPatientAddrs(patientDetailsRequestDto.getPatientAddrs());
		patientDetails.setTotalBillAmount(totalBillAmount);
		PatientDetails patient = patientDetailsRepo.save(patientDetails);
		return patient.getPatientId()+"";
	}

}
