package sokker.MVC.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sokker.MVC.model.SokkerModelObserver;
import sokker.utils.Skill;

public class SkillClickListener extends MouseAdapter{
	
	private SokkerModelObserver observer;
	private Skill skill;
	
	public SkillClickListener(Skill skill,SokkerModelObserver observer) {
		this.observer = observer;
		this.skill = skill;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		observer.updateSkill(skill);
	}
}
