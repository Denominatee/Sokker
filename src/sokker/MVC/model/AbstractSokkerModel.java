package sokker.MVC.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSokkerModel implements SokkerModel{

	private List<SokkerModelObserver> observers = new ArrayList<SokkerModelObserver>();
	
	
	@Override
	public void addObserver(SokkerModelObserver observer) {
		observers.add(observer);
	}
	
	@Override
	public void removeObserver(SokkerModelObserver observer) {
		observers.remove(observer);	
	}

	@Override
	public void notify(Notifications notification) {
		for (SokkerModelObserver observer : observers) {
			switch (notification) {
			case PLAYERS: {
				observer.updatePlayers();
				break;
			}
			case PLAYER: {
				observer.updatePlayer();
				break;
			}
			case CHART: {
				observer.updateChart();
				break;
			}
			case SKILL: {
				// TODO inserted by Wojtek [12.12.2017, 13:03:12]
			}
			default:
				break;
			}
		}
	}

}
