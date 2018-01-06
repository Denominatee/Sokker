package sokker.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Statystyki")
public class Statistic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Data")
	private LocalDate date;
	@Column(name = "Ranking")
	private double rank;		
	@Column(name = "Liczba_graczy")
	private int numberOfPlayers;
	@Column(name = "Œrednia_forma")
	private int avgForm;
	@Column(name = "Œredni_wieku")
	private double avgAge;
	@Column(name = "Œrednia_wartoœæ")
	private int avgValue;
	@Column(name = "Sumaryczna_wartoœæ")
	private int sumValue;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getRank() {
		return rank;
	}
	public void setRank(double rank) {
		this.rank = rank;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public int getAvgForm() {
		return avgForm;
	}
	public void setAvgForm(int avgForm) {
		this.avgForm = avgForm;
	}
	public double getAvgAge() {
		return avgAge;
	}
	public void setAvgAge(double avgAge) {
		this.avgAge = avgAge;
	}
	public int getAvgValue() {
		return avgValue;
	}
	public void setAvgValue(int avgValue) {
		this.avgValue = avgValue;
	}
	public int getSumValue() {
		return sumValue;
	}
	public void setSumValue(int sumValue) {
		this.sumValue = sumValue;
	}
	
}
