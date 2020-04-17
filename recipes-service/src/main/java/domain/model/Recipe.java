package domain.model;

import javax.inject;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;


// Lombok: Getter/Setter/ToString/Hashcode
@Data
@EqualsAndHashCode(callSuper=true)

// DataBase
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;
	
	@NotNull
	private int authorID; // ProfileID
	
	@NotNull
	private Date date;
	
	@NotNull
	private ArrayList<Int> ingredients; // IngredientID
	
	@NotNull
	private ArrayList<String> steps;
	
	@NotNull
	private ArrayList<CategoryEnum> category; // TODO: Test the enum
	
	@NotNull
	private int difficulty;
	
	@NotNull
	private int time;
	
	@NotNull
	private ArrayList<int> ratings;
	
	@NotNull
	private ArrayList<String> comments;

}
