package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Pasajero")
public class Pasajero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPasajero;

	@Digits(integer = 8, fraction = 0)
	@Size(min = 8, max = 8)
	@Column(name = "DNI", nullable = false, length = 50)
	private String DNI;

	@NotEmpty(message = "Ingrese Nombre")
	@Column(name = "namePasajero", nullable = false, length = 50)
	private String namePasajero;

	@NotEmpty(message = "Ingrese Email")
	@Email
	@Column(name = "emailPasajero", nullable = false, length = 50)
	private String emailPasajero;
	
	@NotEmpty(message = "Ingrese Direccion")
	@Column(name = "addressPasajero", nullable = false, length = 50)
	private String addressPasajero;

	@Size(min = 10, max = 10)
	@NotNull(message = "Ingrese TIU por favor")
	@Column(name = "TIU", nullable = false, length = 50)
	private String TIU;

	@Digits(integer = 13, fraction = 0)
	@Size(min = 13, max = 13)
	@Column(name = "accountNumber", nullable = false, length = 50)
	private String accountNumber;

	@NotNull(message = "Ingrese saldo a favor")
	@Column(name = "balanceFavor", nullable = false)
	private int balanceFavor;

	@NotNull(message = "Ingrese saldo adeudado")
	@Column(name = "balanceDebt", nullable = false)
	private int balanceDebt;

	public Pasajero(int idPasajero, String dNI, String namePasajero, String emailPasajero, String addressPasajero, String tIU,
			String accountNumber, int balanceFavor, int balanceDebt) {
		super();
		this.idPasajero = idPasajero;
		DNI = dNI;
		this.namePasajero = namePasajero;
		this.emailPasajero = emailPasajero;
		this.addressPasajero = addressPasajero;
		TIU = tIU;
		this.accountNumber = accountNumber;
		this.balanceFavor = balanceFavor;
		this.balanceDebt = balanceDebt;
	}

	public String getEmailPasajero() {
		return emailPasajero;
	}

	public void setEmailPasajero(String emailPasajero) {
		this.emailPasajero = emailPasajero;
	}

	public Pasajero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNamePasajero() {
		return namePasajero;
	}

	public void setNamePasajero(String namePasajero) {
		this.namePasajero = namePasajero;
	}

	public String getAddressPasajero() {
		return addressPasajero;
	}

	public void setAddressPasajero(String addressPasajero) {
		this.addressPasajero = addressPasajero;
	}

	public String getTIU() {
		return TIU;
	}

	public void setTIU(String tIU) {
		TIU = tIU;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalanceFavor() {
		return balanceFavor;
	}

	public void setBalanceFavor(int balanceFavor) {
		this.balanceFavor = balanceFavor;
	}

	public int getBalanceDebt() {
		return balanceDebt;
	}

	public void setBalanceDebt(int balanceDebt) {
		this.balanceDebt = balanceDebt;
	}

}
