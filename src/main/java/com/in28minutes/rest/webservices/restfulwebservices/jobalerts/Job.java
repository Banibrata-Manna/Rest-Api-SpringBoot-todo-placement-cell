package com.in28minutes.rest.webservices.restfulwebservices.jobalerts;

import java.util.Date;
import java.util.Map;

public class Job {
	private String jobId;
	private String jobRole;
	private String companyName;
	private String location;
	private String packageOffered;
	private String skillsRequired;
	private Date dateOfPost;
	private Map<String, String> otherDetails;
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(String jobId, String jobRole, String companyName, String location, String packageOffered,
			String skillsRequired, Date dateOfPost, Map<String, String> otherDetails) {
		super();
		this.jobId = jobId;
		this.jobRole = jobRole;
		this.companyName = companyName;
		this.location = location;
		this.packageOffered = packageOffered;
		this.skillsRequired = skillsRequired;
		this.dateOfPost = dateOfPost;
		this.otherDetails = otherDetails;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPackageOffered() {
		return packageOffered;
	}
	public void setPackageOffered(String packageOffered) {
		this.packageOffered = packageOffered;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public Date getDateOfPost() {
		return dateOfPost;
	}
	public void setDateOfPost(Date dateOfPost) {
		this.dateOfPost = dateOfPost;
	}
	public Map<String, String> getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(Map<String, String> otherDetails) {
		this.otherDetails = otherDetails;
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobRole=" + jobRole + ", companyName=" + companyName + ", location="
				+ location + ", packageOffered=" + packageOffered + ", skillsRequired=" + skillsRequired
				+ ", dateOfPost=" + dateOfPost + ", otherDetails=" + otherDetails + "]";
	}
}
