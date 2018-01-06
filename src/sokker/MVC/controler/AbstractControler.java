package sokker.MVC.controler;

import sokker.MVC.model.SokkerModel;
import sokker.MVC.view.SokkerFrame;
import sokker.MVC.view.SokkerView;

public class AbstractControler implements SokkerControler {
	
	
	protected SokkerModel model;
	protected SokkerView view;
	
	
	public AbstractControler(SokkerModel model, SokkerView view) {
		this.model = model;
		view = new SokkerFrame(model, this);
		model.addObserver(view);
	}

}
