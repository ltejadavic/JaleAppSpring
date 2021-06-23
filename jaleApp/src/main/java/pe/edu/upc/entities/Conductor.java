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
@Table(name = "Conductor")
public class Conductor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConductor;

	@Digits(integer = 8, fraction = 0)
	@Size(min = 8, max = 8)
	@Column(name = "DNI", nullable = false, length = 50)
	private String DNI;

	@NotEmpty(message = "Ingrese Nombre")
	@Column(name = "nameConductor", nullable = false, length = 50)
	private String nameConductor;

	@NotEmpty(message = "Ingrese Email")
	@Email
	@Column(name = "emailConductor", nullable = false, length = 50)
	private String emailConductor;

	@NotEmpty(message = "Ingrese Direccion")
	@Column(name = "addressConductor", nullable = false, length = 50)
	private String addressConductor;

	@Size(min = 10, max = 10)
	@NotNull(message = "Ingrese TIU por favor")
	@Column(name = "TIU", nullable = false, length = 50)
	private String TIU;

	@NotEmpty(message = "Ingrese Descripcion")
	@Column(name = "descriptionConductor", nullable = false, length = 200)
	private String descriptionConductor;

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

	public Conductor(int idConductor, @Digits(integer = 8, fraction = 0) @Size(min = 8, max = 8) String dNI,
			@NotEmpty(message = "Ingrese Nombre") String nameConductor,
			@NotEmpty(message = "Ingrese Email") @Email String emailConductor,
			@NotEmpty(message = "Ingrese Direccion") String addressConductor,
			@Size(min = 10, max = 10) @NotNull(message = "Ingrese TIU por favor") String tIU,
			@NotEmpty(message = "Ingrese Descripcion") String descriptionConductor,
			@Digits(integer = 13, fraction = 0) @Size(min = 13, max = 13) String accountNumber,
			@NotNull(message = "Ingrese saldo a favor") int balanceFavor,
			@NotNull(message = "Ingrese saldo adeudado") int balanceDebt) {
		super();
		this.idConductor = idConductor;
		DNI = dNI;
		this.nameConductor = nameConductor;
		this.emailConductor = emailConductor;
		this.addressConductor = addressConductor;
		TIU = tIU;
		this.descriptionConductor = descriptionConductor;
		this.accountNumber = accountNumber;
		this.balanceFavor = balanceFavor;
		this.balanceDebt = balanceDebt;
	}

	public Conductor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNameConductor() {
		return nameConductor;
	}

	public void setNameConductor(String nameConductor) {
		this.nameConductor = nameConductor;
	}

	public String getEmailConductor() {
		return emailConductor;
	}

	public void setEmailConductor(String emailConductor) {
		this.emailConductor = emailConductor;
	}

	public String getAddressConductor() {
		return addressConductor;
	}

	public void setAddressConductor(String addressConductor) {
		this.addressConductor = addressConductor;
	}

	public String getTIU() {
		return TIU;
	}

	public void setTIU(String tIU) {
		TIU = tIU;
	}

	public String getDescriptionConductor() {
		return descriptionConductor;
	}

	public void setDescriptionConductor(String descriptionConductor) {
		this.descriptionConductor = descriptionConductor;
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
