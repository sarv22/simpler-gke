package simpgke.simp.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//@Getter
//@Setter

public class Emp {
	@Id
	@GeneratedValue
	@Column(updatable=false, nullable=false)
	Long empid;
	
	@Column
	String name;
	
	@Column
	Integer age;
	
	
	

	

}
