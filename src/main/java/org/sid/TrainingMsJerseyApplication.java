package org.sid;

import java.util.stream.Stream;

import org.sid.entity.Student;
import org.sid.entity.Training;
import org.sid.repository.StudentRepository;
import org.sid.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingMsJerseyApplication implements CommandLineRunner {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TrainingRepository trainingRepository;

	public static void main(String[] args) {
		SpringApplication.run(TrainingMsJerseyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Java", "JEE", "Oracle").forEach(nT -> {
			Training training = new Training();
			training.setName(nT);
			training.setDuration(30);
			trainingRepository.save(training);
		});
		
		studentRepository.save(new Student(null, "Lecompte", "Romain", new Training(1L, null, 0, null)));
		studentRepository.save(new Student(null, "Youri", "Jorkaeff", new Training(1L, null, 0, null)));
		studentRepository.save(new Student(null, "Alami", "Karim", new Training(2L, null, 0, null)));
		studentRepository.save(new Student(null, "Inaoui", "Youness", new Training(2L, null, 0, null)));
		studentRepository.save(new Student(null, "Joefrey", "Jamel", new Training(3L, null, 0, null)));
		studentRepository.save(new Student(null, "Vox", "Katy", new Training(3L, null, 0, null)));

		trainingRepository.findAll().forEach(t -> {
			System.out.println(t.getName());
		});
	}
	

}
