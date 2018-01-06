package sokker;

import javax.swing.UIManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sokker.MVC.controler.DefaultControler;
import sokker.MVC.model.DefaultSokkerModel;
import sokker.MVC.model.SokkerModel;



public class Run {
	
public static void main(String[] args) {	
	
		final Logger logger = LoggerFactory.getLogger(Run.class);	
		
		logger.info("Program start");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			logger.error("setLookAndFeel failure");
			e.printStackTrace();
		}
		SokkerModel sokkerModel = new DefaultSokkerModel();
		new DefaultControler(sokkerModel);	
	}

}
