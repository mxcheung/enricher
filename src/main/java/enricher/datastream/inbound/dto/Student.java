package enricher.datastream.inbound.dto;

public class Student extends Payload  {

    private String school;
    
    private String studentID;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}




}