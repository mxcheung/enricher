package enricher.datastream.inbound.dto;

public class Employee extends Payload  {

    private String organisation;
    
    private String employeeID;


	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}



}