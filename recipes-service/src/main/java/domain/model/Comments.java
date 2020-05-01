package domain.model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


// Lombok: Getter/Setter/ToString/Hashcode
@Data
@EqualsAndHashCode


// DataBase

@Entity
public class Comments implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 8612291428356986734L;

	@Id
	@SequenceGenerator(name = "COMMENTS_SEQ", sequenceName = "COMMENTS_SEQ")  
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENTS_SEQ")			
	private Long id;
	
	private long recipeID;
	
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="Recipe_id",nullable = true)
	private Recipe recipeComments;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (!(o instanceof Comments))
            return false;
 
        Comments other = (Comments) o;
 
        return id != null &&
               id.equals(other.getId());
    }
 
    @Override
    public int hashCode() {
        return 31;
    }
	
	
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "-" + getId();
    }
	

}