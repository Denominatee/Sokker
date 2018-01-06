package sokker.MVC.model;

import sokker.utils.Skill;

public interface SokkerModelObserver {
	
	public void updatePlayer();
	
	public void updatePlayers();
	
	public void updateChart();
	
	public void updateSkill(Skill skill);
}
