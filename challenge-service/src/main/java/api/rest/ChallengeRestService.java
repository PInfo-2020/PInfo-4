package api.rest;



import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import api.msg.ChallengeProducer;
import domain.model.Challenge;
import domain.model.Ingredient;
import domain.model.Recipe;
import domain.service.ChallengeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.Random;

@ApplicationScoped
@Path("/challenge")
@Api(value = "challenge", authorizations = {
	      @Authorization(value="sampleoauth", scopes = {})
	    })
public class ChallengeRestService {

	@Inject
	private ChallengeService challengeService;
	@Inject
	private ChallengeProducer challengeProducer;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get all the challenges")
   
	public List<Challenge> getAll() {
		return challengeService.getAll();
	}

	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get a the count of challenge")
    public Long count() {
		System.out.println("-----------------LONG COUNT:"+challengeService.count()+"-----------------");
		
		return challengeService.count();
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create a new Challenge",  notes = "Create a new Challenge.")
	public void createRecipe(Challenge c) {
		challengeService.create(c);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get a specifc challenge")
	public Challenge get(@PathParam("id") Long challengeId) {
		
		return challengeService.get(challengeId);
	}
	
	@GET
	@Path("/ingredients/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get a set of Ingredient of a challenge")
	public Set<Ingredient> getSetIngredient(@PathParam("id") Long challengeId) {
		System.out.println("----------asdasd"+challengeService.get(challengeId).getIngredients()); // Retourne un set vide?		
		return challengeService.get(challengeId).getIngredients();
	}
	
	@GET
	@Path("/solutions/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get a set of Ingredient of a challenge")
	public Set<Recipe> getSetSolutions(@PathParam("id") Long challengeId) {

		return challengeService.get(challengeId).getSolutions();
	}

	

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update a given challenge")
	public void update(Challenge challenge) {
		challengeService.update(challenge);
		challengeProducer.send(challenge);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create a new challenge")
	public void create(Challenge challenge) {
		challengeService.create(challenge);
		challengeProducer.send(challenge);
	}

	
	@POST
	@Path("propagateAllChallenges")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Propagate all challenges to the bus to sync up downstream services")
	public void propagateAllChallenges() {
		challengeProducer.sendAllChallenges();
	}
}