package org.sid.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sid.entity.Training;
import org.sid.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * API REST : Pour gérer des formations.
 * 
 * Ce WS est basé sur JAX-RS et déployé avec Jersey.
 * 
 */
@Component
@Path("/schooling")
public class TrainingRestService {

	@Autowired
	private TrainingRepository trainingRepository;

	@GET
	@Path("/trainings")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Training> getTrainings() {
		return trainingRepository.findAll();
	}

	@GET
	@Path("/trainings/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Optional<Training> getTraining(@PathParam(value = "id") Long id) {
		return trainingRepository.findById(id);
	}

	@POST
	@Path("/trainings")
	@Produces(MediaType.APPLICATION_JSON)
	public Training save(Training training) {
		return trainingRepository.save(training);
	}

	@PUT
	@Path("/trainings/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Training update(@PathParam(value = "id") Long id, Training training) {
		training.setId(id);
		return trainingRepository.save(training);
	}

	@DELETE
	@Path("/trainings/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam(value = "id") Long id) {
		trainingRepository.deleteById(id);
	}

}
