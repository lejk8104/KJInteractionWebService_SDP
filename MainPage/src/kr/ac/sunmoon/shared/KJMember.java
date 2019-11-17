package kr.ac.sunmoon.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class KJMember implements IsSerializable {

	private String ID;
	private String Password;
	private String CheckPassword;
	private String Name;
	private String Gender;
	private String Year;
	private String Date;
	private String Country;
	private String Local;
	 
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getCheckPassword() {
		return CheckPassword;
	}
	public void setCheckPassword(String CheckPassword) {
		this.CheckPassword = CheckPassword;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String Gender) {
		this.Gender = Gender;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String Year) {
		this.Year = Year;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String Date) {
		this.Date = Date;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String Country) {
		this.Country = Country;
	}
	public String getLocal() {
		return Local;
	}
	public void setLocal(String Local) {
		this.Local = Local;
	}
}
