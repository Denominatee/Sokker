package sokker.MVC.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jfree.data.xy.XYSeries;
import org.jfree.date.DateUtilities;

import sokker.entities.History;
import sokker.entities.Player;
import sokker.utils.Skill;


public class DefaultSokkerModel extends AbstractSokkerModel {
	
	private Player currentPlayer;
	private Skill skill = Skill.VALUE;
	private List<Player> players;
	private ChartModel chartModel;
		
	public DefaultSokkerModel() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sokker");
		this.entityManager = entityManagerFactory.createEntityManager();
		loadPlayers();
	}
	
	private EntityManager entityManager;

	@Override
	public void loadPlayers() {
		String queryString = "FROM Player";
		Query query = entityManager.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<Player> result =  query.getResultList();
		if (players != null && players.containsAll(result)) {
		} else {
			players = result;
			notify(Notifications.PLAYERS);
		}		
	}	
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
		notify(Notifications.PLAYER);
		updateChartModel();
	}
	
	@Override
	public ChartModel getChartModel() {
		return chartModel;
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public Skill getSkill() {
		return skill;
	}

	@Override
	public void setSkill(Skill skill) {
		this.skill = skill;
		updateChartModel();
	}

	@SuppressWarnings("unchecked")
	private void updateChartModel() {
		if (currentPlayer == null || currentPlayer.getName() == null)
			return;
		chartModel = new ChartModel(skill);
		chartModel.setTitle(skill.toString());
		XYSeries series = new XYSeries(skill.toString(), false, true);	
		String queryString = "FROM History where Zawodnik_ID = (SELECT id FROM Player where surname = :surname) order by date";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("surname", currentPlayer.getSurname());
		List<History> historyList = query.getResultList();
		for (History history: historyList) {
			LocalDate date = history.getDate();
			series.add(DateUtilities.createDate(date.getYear(),date.getMonthValue(), date.getDayOfMonth()).getTime(),history.getSkillValue(skill));
		}
		chartModel.setDataseries(series);	
		notify(Notifications.CHART);
	}	
}
