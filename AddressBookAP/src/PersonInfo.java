
public class PersonInfo
{
	private String name,address,Gender;
	private long id, phone;

      // default constructor
      public PersonInfo()
      {     
    	 
         name = "";
         address = "";
         Gender = "";

         id = 0;  
         phone = 0;
      }

	public PersonInfo(String name, String address, long phone, String Gender, long cnic)
	{
        this.id = cnic;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.Gender = Gender;
	}
 
	/*
	 * // param construcrtor with 4 values public PersonInfo(String name, String
	 * address, int phone,int cnic, String Gender) { this.name = name; this.address
	 * = address; this.phone = phone; this.Gender = Gender; this.id=cnic; }
	 */

      // setters
	public void setId(int i)
	{
		id = i;
	}

	public void setName(String n)
	{
		name=n;		
	}
	public void setAddress(String a)
	{
		address=a;
	}
	public void setPhone(int ph)
	{
		phone=ph;
	}
	public void setGender(String e)
	{
		Gender=e;
	}

      // getters
	public long getId( )
	{
		return id;
      }

	public String getName()
	{
		return name;
	}

	public String getAddress()
	{
		return address;
	}

	public long getPhone()
	{
		return phone;
	}

	public String getGender()
	{
		return Gender;
	}

}