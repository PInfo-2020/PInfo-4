package domain.service;


import java.lang.reflect.Array;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.javatuples.Triplet; 
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import domain.model.CategoryEnum;
import domain.model.Recipe;
import lombok.Data;

@ApplicationScoped
public class RecipeServiceImpl implements RecipeService {
	
	@PersistenceContext(unitName = "RecipePU")
	private EntityManager em;
	
	
	public RecipeServiceImpl() {
	}

	public RecipeServiceImpl(EntityManager em) {
		this();
		this.em = em;
	}
	
	
	//TODO: Implement that shit
	
	public void addRecipe(Recipe r) {
		if (r.getId() != null) {
			throw new IllegalArgumentException("Recipe already exists : " + r.getId());
		}
		em.persist(r);
	}
	
	public void addRating(long id,int rate) {
		Recipe r = em.find(Recipe.class, id);
		r.updateRating(rate);
		em.merge(r);
	}

	public ArrayList<Triplet> getRecipesForProfil(long id){
		String sID = String.valueOf(id);
		String q = "select * from Recipe where authorID = "+sID;
		Query query = em.createNativeQuery(q,Recipe.class);
		List<Recipe> tmp =query.getResultList();
		ArrayList<Triplet> listToReturn = new ArrayList();
        Iterator it = tmp.iterator();
        while (it.hasNext()) {
        	Recipe r = (Recipe) it.next();
        	listToReturn.add(new Triplet(r.getId(),r.getName(),r.getIngredients()));
        }
        return listToReturn;
	}
	
	public List getRecipiesIdForProfiles(long id){
		List ids = em.createQuery("SELECT id from Recipe where authorID = id").getResultList();
		return ids;
	}
	
	public void addComment(String comment, long id) {
		Recipe r = em.find(Recipe.class, id);
		r.addComent(comment);
		em.merge(r);
	}
	
	public void removeRecipe(long id) {
		Recipe r = em.find(Recipe.class, id);
		em.remove(r);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getRecipe(long id) {
		//Return an ArrayList as follow:
		//<id,Name,authorId,Date,IngredientsID,Steps,Category,Difficulty,Time,Ratings,Comments>
		
		Recipe r = em.find(Recipe.class, id);
		ArrayList l = new ArrayList();
		l.add(r.getId());
		l.add(r.getName());
		l.add(r.getAuthorID());
		l.add(r.getDate());
		l.add(r.getIngredients());
		l.add(r.getSteps());
		l.add(r.getCategory());
		l.add(r.getDifficulty());
		l.add(r.getTime());
		l.add(r.getRatings());
		l.add(r.getComments());
	
		return l;
	}
	
	
}
