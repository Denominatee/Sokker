package sokker.MVC.controler;

import java.awt.event.KeyEvent;
import java.util.List;

import sokker.MVC.model.SokkerModel;
import sokker.MVC.model.SokkerModel.Notifications;
import sokker.MVC.view.SokkerFrame;
import sokker.MVC.view.SokkerView;
import sokker.entities.Player;
import sokker.scaner.SokkerBot;
import sokker.utils.Skill;

public class DefaultControler extends AbstractControler{
	
	public DefaultControler(SokkerModel model, SokkerView view) {
		super(model, view);
	}
	
	private SokkerModel model;
	private SokkerFrame view;
	

	public void playerChanged(Player player) {
		model.setCurrentPlayer(player);
	}
	public void scan() {
		new SokkerBot().start();
		model.notify(Notifications.CHART);
	}
	public void onKeyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case 40: {
			//key up ---> case 38
		}
		case 38: {
			List<Player> players = model.getPlayers();
			int index = players.indexOf(model.getCurrentPlayer());
			if (code == 40) {
				index++;
				if (index >= players.size())
					index = 0;
			} else {
				index--;
				if (index < 0)
					index = players.size() - 1;
			}
			model.setCurrentPlayer(players.get(index));
			break;
		}
		case 37: {
			// key left ---> case 39
		}
		case 39: {
			Skill skill = model.getSkill();
			if (code == 37) {
				model.setSkill(skill.getPreviousSkill(skill));
			} else {
				model.setSkill(skill.getNextSkill(skill));
			}
			break;
		}	
		}
	}
	
}
