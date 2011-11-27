
public class Employee {
	private long id;
	private String password = null;
        private boolean admin;
	
	
	public Employee(){
		id = 00000;
		password = "nul";
                admin = false;
	}
	
	public Employee(long id, String pword)
	{
		this.id = id;
		password = pword;
	}
	public void setPassword(String newPass)
	{
		password = newPass;
	}
	public void setID(long id)
	{
		this.id = id;
	}
	public String getPassword()
	{
		return password;
	}
	public long getID()
	{
		return id;
	}
}
