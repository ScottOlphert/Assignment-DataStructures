package collections;

public class Student implements java.io.Serializable
{
	private String id, forename, surname, subject;
	private int result;
	
	public Student() 
	{
		this.id = "";
		this.forename = "";
		this.surname = "";
		this.subject = "";
		this.result = 0;
	}
	
	public Student(String id, String forename, String surname, String subject, int result) 
	{
		this.id = id;
		this.forename = forename;
		this.surname = surname;
		this.subject = subject;
		this.result = result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public String toString()
	{
		String str="";
		str = String.format("    %-15s           %-10s   %-10s   %-20s\n", 
				this.id, this.forename, this.subject, this.result);
		
		return str;
	}

}
