package sokker.MVC.model;

import java.util.List;

import sokker.entities.Player;
import sokker.utils.Skill;

public interface SokkerModel {
	
	public void addObserver(SokkerModelObserver observer);
	
	public void removeObserver(SokkerModelObserver observer);
	
	public void notify(Notifications notification);
	
	public void loadPlayers();
	
	public List<Player> getPlayers();
	
	public void setCurrentPlayer(Player player);
	
	public Player getCurrentPlayer();
	
	public ChartModel getChartModel();
	
	public Skill getSkill();
	
	public void setSkill(Skill skill);	
	
	public enum Notifications {
		PLAYER,
		PLAYERS,
		CHART,
		SKILL
	}
}
