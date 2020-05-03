package domain.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString

@Entity
@Table(name ="RecipeFav")  //RecipeFav
public class RecipeFav implements Serializable  {

	private static final long serialVersionUID = 4370273419623542742L;

	@Id
	@SequenceGenerator(name = "RECIPEFAV_SEQ", sequenceName = "RECIPEFAV_SEQ") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECIPEFAV_SEQ")
	private Long id;
	
	private Long recipeId;  //Recipe
}
