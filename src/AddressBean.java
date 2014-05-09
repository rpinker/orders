/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class AddressBean
{
	// instance variables that represent one address
	private int		addressid;
    private String	firstname;
    private String	lastname;
    private String	street;
    private String	city;
    private String	state;
    private String	zip;
	
	public int getAddressid()
	{
		return addressid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setAddressid(String addressid)
	{
		setAddressid(new Integer(addressid));
	}

	public void setAddressid(int addressid)
	{
		this.addressid = addressid;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public AddressBean()
	{
		
	}

	public String toString()
	{
		return	"addressid: " + getAddressid() +
				"\nfirstname: " + getFirstname() +
				"\nlastname: " + getLastname() +
				"\nstreet: " + getState() +
				"\ncity: " + getCity() +
				"\nstate: " + getState() +
				"\nzip: " + getZip();
	}
}
