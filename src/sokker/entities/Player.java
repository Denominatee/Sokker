package sokker.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Zawodnik")
public class Player {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name = "Imiê")
		private String name;
		@Column(name = "Nazwisko")
		private String surname;
		@OneToMany
		@JoinColumn(name = "Zawodnik_ID")
		private List<History> history;
				
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public List<History> getHistory() {
			return history;
		}
		public void setHistory(List<History> history) {
			this.history = history;
		}
		@Override
		public String toString() {
			return surname.toString();
		}
		public Player() {
		}
		public Player(String surname) {
			this.surname =surname;
		}
		
}
