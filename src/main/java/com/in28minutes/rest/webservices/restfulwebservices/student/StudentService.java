package com.in28minutes.rest.webservices.restfulwebservices.student;


import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restfulwebservices.jobalerts.JobRepository;

@Service
public class StudentService {
	private StudentRepository studentRepository;
	private JobRepository jobRepository;
	public StudentService(StudentRepository studentRepository,
			JobRepository jobRepository) {
		this.jobRepository = jobRepository;
		this.studentRepository = studentRepository;
	}
	public void save(Student student) {
		studentRepository.save(student);
	}
	public Student get(String enrollmentNumString) throws NullPointerException {
		return studentRepository.findById(enrollmentNumString).orElseThrow();
	}
	public void apply(String enrollmentNumber, String jobId) {
		Student student = get(enrollmentNumber);
		student
		.getAppliedJobs()
		.add(jobRepository.findById(jobId).get());
		save(student);
	}
}
