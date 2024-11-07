package com.in28minutes.rest.webservices.restfulwebservices.jobalerts;


import java.util.List;


import org.springframework.stereotype.Service;


@Service
public class JobService {
	
	private JobRepository repository;
	
	public JobService(JobRepository repository) {
		this.repository = repository;
	}
	
//	private static List<Job> jobs = new ArrayList<>();
//	private static int jobCount = 0;
//	private static Map<String, String> map = new HashMap<String, String>();
//	
//	static {
//		map.put("Responsbilities", "Build and manage microservices architecture using Spring Boot for scalable applications.\r\n"
//				+ "Create RESTful APIs for communication between client and server applications.\r\n"
//				+ "Design schemas, integrate databases, and perform CRUD operations using Spring Data JPA.\r\n"
//				+ "Secure applications with authentication, authorization, and user management via Spring Security.\r\n"
//				+ "Write tests, debug issues, and optimize performance for reliable and efficient applications.");
//		jobs.add(new Job("IESTCS0824", "Java Developer", "TCS", "Indore, India",
//				"7 to 9 LPA", "Java, SpringBoot", new Date(2024, 11, 18), map));
//	}
	
	public Job saveJob(Job job) {
//		jobs.add(job);
//		jobCount++;
		repository.save(job);
		return job;
	}
	
	public List<Job> getAllJobs(){
		return repository.findAll();
	}
}
