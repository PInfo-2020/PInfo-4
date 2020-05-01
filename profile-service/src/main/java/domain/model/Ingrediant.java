package domain.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
// Yo
@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name ="Ingrediant")
public class Ingrediant implements Serializable  {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4618373781528392556L;


	@Id
	@SequenceGenerator(name = "INGREDIANT_SEQ", sequenceName = "INGREDIANT_SEQ") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INGREDIANT_SEQ")
	private Long id;
	
	private Long Ingrediantid;
	
	
	private int quantite;

}
