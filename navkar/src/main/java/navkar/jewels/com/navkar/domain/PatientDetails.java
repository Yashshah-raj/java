package navkar.jewels.com.navkar.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

//@Entity
//@Table(name="patient_details")
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetails implements Serializable{

	@Id
	@Column(name="patients_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer patientId;
private String patientName;
private String patientAddrs;
private String mobileNumber;
private String numberOfHospitalized;
private Double billPerDay;
private Double totalBillAmount;
private Integer discount;
private Double netBillAmount;

}
