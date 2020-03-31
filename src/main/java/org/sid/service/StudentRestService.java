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

import org.sid.entity.Student;
import org.sid.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * API REST : Pour gérer des étudiants. 
 * 
 * Ce WS est basé sur JAX-RS et déployé avec Jersey.
 * 
 */
@Component 
@Path("/schooling")
public class StudentRestService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GET
	@Path("/students")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	@GET
	@Path("/students/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Optional<Student> getStudent(@PathParam(value="id")Long id) {
		return studentRepository.findById(id);
	}
	
	@POST
	@Path("/students")
	@Produces(MediaType.APPLICATION_JSON)
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	@PUT
	@Path("/students/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student update(@PathParam(value="id")Long id, Student student) {
		student.setId(id);
		return studentRepository.save(student);
	}
	
	@DELETE
	@Path("/students/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam(value="id")Long id) {
		studentRepository.deleteById(id);
	}

}
