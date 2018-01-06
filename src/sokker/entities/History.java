package sokker.entities;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import sokker.utils.Skill;

@Entity
@Table(name = "Historia")
public class History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Data")
	private LocalDate date;
	@Column(name = "Wiek")
	private int age;		
	@Column(name = "Wartoœæ")
	private int value;
	@Column(name = "Wynagrodzenie")
	private int wage;
	@Column(name = "Forma")
	private int form;
	@Column(name = "Wzrost")
	private int height;
	@Column(name = "Waga")
	private double weight;
	@Column(name = "BMI")
	private String bmi;	
	@Column(name = "Kondycja")
	private int stamina;
	@Column(name = "Szybkoœæ")
	private int pace;
	@Column(name = "Technika")
	private int technique;
	@Column(name = "Podania")
	private int passing;
	@Column(name = "Bramkarz")
	private int keeper;
	@Column(name = "Obroñca")
	private int defender;
	@Column(name = "Rozgrywaj¹cy")
	private int playmaker;
	@Column(name = "Strzelec")
	private int striker;

	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getPace() {
		return pace;
	}
	public void setPace(int pace) {
		this.pace = pace;
	}
	public int getTechnique() {
		return technique;
	}
	public void setTechnique(int technique) {
		this.technique = technique;
	}
	public int getPassing() {
		return passing;
	}
	public void setPassing(int passing) {
		this.passing = passing;
	}
	public int getKeeper() {
		return keeper;
	}
	public void setKeeper(int keeper) {
		this.keeper = keeper;
	}
	public int getDefender() {
		return defender;
	}
	public void setDefender(int defender) {
		this.defender = defender;
	}
	public int getPlaymaker() {
		return playmaker;
	}
	public void setPlaymaker(int playmaker) {
		this.playmaker = playmaker;
	}
	public int getStriker() {
		return striker;
	}
	public void setStriker(int striker) {
		this.striker = striker;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getForm() {
		return form;
	}
	public void setForm(int form) {
		this.form = form;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}	
	public int getSkillValue(Skill skill) {
		switch (skill) {
		case PACE: {
			return pace;
		}
		case PASSES: {
			return passing;
		}
		case PLAYMAKING: {
			return playmaker;
		}
		case DEFENDING: {
			return defender;
		}
		case STRIKER: {
			return striker;
		}
		case TECHNIQUE: {
			return technique;
		}
		case GOALKEEPING: {
			return keeper;
		}
		case STAMINA: {
			return stamina;
		}
		case FORM: {
			return form;
		}
		case VALUE: {
			return value;
		}
		case WAGE: {
			return wage;
		}
		default:
			return 0;
		}
	}
}
