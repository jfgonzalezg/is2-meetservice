package business;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class Service{
	
	private String name;
	private String address;
	private int cod;
	private String Description;
	private String telephone;
	private String category;
	private String city;
	private String webpage;
	private String email;
	private String username;
	private int calpuntualidad;
	private int calcosto;
	private int calatencion;
	private int calculminacion;
	private int calcalidad;
	
	
	
	public int getCalpuntualidad() {
		return calpuntualidad;
	}


	public void setCalpuntualidad(int calpuntualidad) {
		this.calpuntualidad = calpuntualidad;
	}


	public int getCalcosto() {
		return calcosto;
	}


	public void setCalcosto(int calcosto) {
		this.calcosto = calcosto;
	}


	public int getCalatencion() {
		return calatencion;
	}


	public void setCalatencion(int calatencion) {
		this.calatencion = calatencion;
	}


	public int getCalculminacion() {
		return calculminacion;
	}


	public void setCalculminacion(int calculminacion) {
		this.calculminacion = calculminacion;
	}


	public int getCalcalidad() {
		return calcalidad;
	}


	public void setCalcalidad(int calcalidad) {
		this.calcalidad = calcalidad;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	private int availability;
	private int num_rating;
	private int rating_acum;
	private String admin_state;
	private Date date_start ;
	private Date date_end;
	
	
	public Service(){
		
		
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getWebpage() {
		return webpage;
	}


	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAvailability() {
		return availability;
	}


	public void setAvailability(int availability) {
		this.availability = availability;
	}


	public int getNum_rating() {
		return num_rating;
	}


	public void setNum_rating(int num_rating) {
		this.num_rating = num_rating;
	}


	public int getRating_acum() {
		return rating_acum;
	}


	public void setRating_acum(int rating_acum) {
		this.rating_acum = rating_acum;
	}


	public String getAdmin_state() {
		return admin_state;
	}


	public void setAdmin_state(String admin_state) {
		this.admin_state = admin_state;
	}


	public Date getDate_start() {
		return date_start;
	}


	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}


	public Date getDate_end() {
		return date_end;
	}


	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}


	




}
