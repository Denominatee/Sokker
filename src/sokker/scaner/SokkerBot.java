package sokker.scaner;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sokker.entities.History;
import sokker.entities.Player;
import sokker.entities.Statistic;
import sokker.scaner.utils.CSS;

public class SokkerBot {

	private Properties properties;
	private SokkerDriver driver;

	public void start() {
		properties = new Properties();
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("sokker.properties");
			if (in != null) {
				properties.load(in);
				in.close();
			} else {
				System.out.println("Brak pliku .properties");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = getDriver();			
		driver.get("http://sokker.org");
		login(driver);
		try {
			driver.waitDriver().until(ExpectedConditions.elementToBeClickable(driver.getElement(CSS.TEAM_BTN)));
		} catch (Exception e) {
			login(driver);
		}
		driver.getElement(CSS.STATS_BTN,10).click();
		scanStats();
		driver.getElement(CSS.TEAM_BTN).click();
		checkPlayers();
		addToHistory();
		//JOptionPane.showMessageDialog(null, "Git?");

		driver.close();
	}

	private void addToHistory() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sokker");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<WebElement> names = driver.getElements(CSS.PLAYER_NAME);
		List<WebElement> bmis = driver.getElements(CSS.PLAYER_BMI);
		List<WebElement> forms = driver.getElements(CSS.PLAYER_FORM);
		List<WebElement> heights = driver.getElements(CSS.PLAYER_HEIGHT);
		List<WebElement> weights = driver.getElements(CSS.PLAYER_WEIGHT);
		List<WebElement> ages = driver.getElements(CSS.PLAYER_AGE);
		List<WebElement> values = driver.getElements(CSS.PLAYER_VALUES);
		List<WebElement> wages = driver.getElements(CSS.PLAYER_WAGE);
		List<WebElement> staminas = driver.getElements(CSS.PLAYER_STAMINA);
		List<WebElement> paces = driver.getElements(CSS.PLAYER_PACE);
		List<WebElement> techniques = driver.getElements(CSS.PLAYER_TECHNIQUE);
		List<WebElement> passes = driver.getElements(CSS.PLAYER_PASSES);
		List<WebElement> keepers = driver.getElements(CSS.PLAYER_KEEPER);
		List<WebElement> defenders = driver.getElements(CSS.PLAYER_DEFENDER);
		List<WebElement> playmakers = driver.getElements(CSS.PLAYER_PLAYMAKER);
		List<WebElement> strikers = driver.getElements(CSS.PLAYER_STRIKER);
		
		
		for (int i = 0; i < names.size(); i++) {
			String nameString = names.get(i).getText();
			String ageString = ages.get(i).getText();
			int index = nameString.indexOf(" ");
			String name = nameString.substring(0, index);
			String surname = nameString.substring(index + 1, nameString.length());
			String queryString = "SELECT id FROM Player where name = :name and surname = :surname";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("name",name);
			query.setParameter("surname", surname);
			Player player = entityManager.find(Player.class, query.getSingleResult());
			List<History> list = player.getHistory();
			History history = new History();
			history.setDate(LocalDate.now());
			history.setAge(Integer.valueOf(ageString.substring(ageString.length()-2)));
			history.setBmi(bmis.get(i).getText());
			history.setForm(getSkillInteger(forms.get(i).getText()));
			history.setHeight(Integer.valueOf(heights.get(i).getText()));
			history.setWeight(Double.valueOf(weights.get(i).getText()));
			history.setValue(getValueAsInt(values.get(i).getText()));
			history.setWage(getValueAsInt(wages.get(i).getText()));	
			history.setStamina(getSkillInteger(staminas.get(i).getText()));
			history.setPace(getSkillInteger(paces.get(i).getText()));
			history.setTechnique(getSkillInteger(techniques.get(i).getText()));
			history.setPassing(getSkillInteger(passes.get(i).getText()));
			history.setKeeper(getSkillInteger(keepers.get(i).getText()));
			history.setDefender(getSkillInteger(defenders.get(i).getText()));
			history.setPlaymaker(getSkillInteger(playmakers.get(i).getText()));	
			history.setStriker(getSkillInteger(strikers.get(i).getText()));
			entityManager.getTransaction().begin();
			entityManager.persist(history);
			list.add(history);	
			entityManager.persist(player);
			entityManager.getTransaction().commit();
		}	
		entityManager.close();
		entityManagerFactory.close();		
	}

	private void checkPlayers() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sokker");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		driver.waitDriver().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CSS.PLAYER_NAME.toString())));
		List<WebElement> names = driver.getElements(CSS.PLAYER_NAME);
		
		for (int i = 0; i < names.size(); i++) {
			Player player = new Player();
			String nameString = names.get(i).getText();
			int index = nameString.indexOf(" ");
			player.setName(nameString.substring(0, index));
			player.setSurname(nameString.substring(index + 1, nameString.length()));

			if (!playerExists(entityManager, player.getName(), player.getSurname())) {
				entityManager.getTransaction().begin();
				entityManager.persist(player);
				entityManager.getTransaction().commit();
			}
		}
		entityManager.close();
		entityManagerFactory.close();
	}
	
	
	private void scanStats() {		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sokker");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Statistic statistic = new Statistic();
		statistic.setRank(Double.valueOf(driver.getElement(CSS.STATS_RANK).getText()));
		statistic.setNumberOfPlayers(Integer.valueOf(driver.getElement(CSS.STATS_NUM_OF_PLAYERS).getText()));
		statistic.setAvgForm(getSkillInteger(driver.getElement(CSS.STATS_AVG_FORM).getText()));
		statistic.setAvgAge(Double.valueOf(driver.getElement(CSS.STATS_AVG_AGE).getText()));
		statistic.setAvgValue(getValueAsInt(driver.getElement(CSS.STATS_AVG_VALUE).getText()));
		statistic.setSumValue(getValueAsInt(driver.getElement(CSS.STATS_SUM_VALUE).getText()));
		statistic.setDate(LocalDate.now());
		entityManager.getTransaction().begin();
		entityManager.persist(statistic);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();	
	}
	
	private boolean playerExists(EntityManager entityManager, String name, String surname){		
		String queryString = "SELECT count(name) FROM Player where name = :name and surname = :surname";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("name",name);
		query.setParameter("surname", surname);
		int count = Integer.valueOf(query.getSingleResult().toString());
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	private int getValueAsInt(String valueString) {
		valueString = valueString.replaceAll(" ", "");
		valueString = valueString.replaceAll("z³", "");
		return Integer.valueOf(valueString);
	}

	private void login (SokkerDriver driver) {
		driver.getElement(CSS.LOGIN).sendKeys("Denominatee");
		driver.getElement(CSS.PASSWORD).sendKeys("1615kazik1516");
		driver.waitDriver().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CSS.LOGIN_BTN.toString())));
		driver.getElement(CSS.LOGIN_BTN).submit();
	}
	
	
	private SokkerDriver getDriver() {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile(properties.getProperty("profileName"));
		// myprofile.setPreference("media.volume_scale", "0.0");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		new FirefoxOptions().setProfile(myprofile).addTo(capabilities);
		SokkerDriver driver = new SokkerDriver(capabilities);
		return driver;
	}
	
	private int getSkillInteger(String skill) {
		if (skill.contains("tragicz"))
			return 0;
		if (skill.contains("beznadziej"))
			return 1;
		if (skill.contains("niedostatecz"))
			return 2;
		if (skill.contains("miern"))
			return 3;
		if (skill.contains("s³ab"))
			return 4;
		if (skill.contains("przeciêtn"))
			return 5;
		if (skill.contains("dostatecz"))
			return 6;
		if (skill.contains("dobr") && !skill.contains("bardzo"))
			return 7;
		if (skill.contains("solidn"))
			return 8;
		if (skill.contains("bardzo dobr"))
			return 9;
		if (skill.contains("celuj¹c"))
			return 10;
		if (skill.contains("œwietn"))
			return 11;
		if (skill.contains("znakomit"))
			return 12;
		if (skill.contains("niesamowit"))
			return 13;
		if (skill.contains("olœniewaj¹c"))
			return 14;
		if (skill.contains("magiczn"))
			return 15;
		if (skill.contains("nieziemsk"))
			return 16;
		if (skill.contains("nadbosk"))
			return 18;
		if (skill.contains("bosk"))
			return 17;
		return 100;
	}
	

}
