package sokker.MVC.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.Range;
import org.jfree.data.xy.XYSeriesCollection;

import sokker.MVC.controler.DefaultControler;
import sokker.MVC.model.ChartModel;
import sokker.MVC.model.SokkerModel;
import sokker.MVC.model.SokkerModelObserver;
import sokker.entities.History;
import sokker.entities.Player;
import sokker.utils.Skill;
import sokker.utils.StringFormater;

public class SokkerFrame extends AbstractSokkerView{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7902339416426429327L;
	
	private SokkerModel model;
	private DefaultControler controler;
	private JFreeChart chart;
	private final XYSeriesCollection dataset = new XYSeriesCollection();
	private String title = null;
	
	private JButton scanButton = new JButton("Skanuj");
	private JComboBox<Player> currentPlayerCB = new JComboBox<Player>();
	private DefaultComboBoxModel<Player> cbModel = new DefaultComboBoxModel<Player>();
	
	private JPanel mainPanel = new JPanel(new GridBagLayout());
	private JPanel basePanel = new JPanel(new BorderLayout());
	private GridBagConstraints gbc = new GridBagConstraints();
	private JPanel menuPanel = new JPanel();
	private JPanel statsPanel = new JPanel();
	private JPanel menuParentPanel = new JPanel();
	private JPanel detailsPanel = new JPanel(new GridBagLayout());
	private JPanel graphPanel = new JPanel(new BorderLayout());

    private JLabel nameLabel = new JLabel("Imiê:");
    private JLabel valueLabel = new JLabel("Wartoœæ:");
    private JLabel surnameLabel = new JLabel("Nazwisko:");
    private JLabel ageLabel = new JLabel("Wiek:");
    private JLabel wageLabel = new JLabel("Wynagrodzenie:");
    private JLabel formLabel = new JLabel("Forma:");
    private JLabel heightLabel = new JLabel("Wzrost:");
    private JLabel weightLabel = new JLabel("Waga:");
    private JLabel BMI_Label = new JLabel("BMI:");
    private JLabel staminaLabel = new JLabel("Kondycja:");
    private JLabel paceLabel = new JLabel("Szybkoœæ:");
    private JLabel techniqueLabel = new JLabel("Technika:");
    private JLabel passLabel = new JLabel("Podania:");
    private JLabel keeperLabel = new JLabel("Bramkarz:");
    private JLabel defenderLabel = new JLabel("Obroñca:");
    private JLabel playmakerLabel = new JLabel("Rozgrywaj¹cy:");
    private JLabel strikerLabel = new JLabel("Strzelec:");
    private JLabel rankLabel = new JLabel("Punkty rankingowe:");
    private JLabel numOfPlayersLabel = new JLabel("Liczba zawodników:");
    private JLabel avgFormLabel = new JLabel("Œrednia forma:");
    private JLabel avgAgeLabel = new JLabel("Sredni wiek:");
    private JLabel avgValueLabel = new JLabel("Œrednia wartoœæ:");
    private JLabel sumValueLabel = new JLabel("Wartoœæ ³¹czna:");
	private JTextField nameField = new JTextField(10);
	private JTextField surnameField = new JTextField(10);
	private JTextField valueField = new JTextField(10);
	private JTextField ageField = new JTextField(10);
	private JTextField wageField = new JTextField(10);
	private JTextField formField = new JTextField();
	private JTextField heightField = new JTextField(10);
	private JTextField BMI_Field = new JTextField(10);
	private JTextField weightField = new JTextField(10);
	private JTextField staminaField = new JTextField();
	private JTextField paceField = new JTextField();
	private JTextField techniqueField = new JTextField();
	private JTextField passField = new JTextField();
	private JTextField keeperField = new JTextField();
	private JTextField defenderField = new JTextField();
	private JTextField playmakerField = new JTextField();
	private JTextField strikerField = new JTextField();
	private JLabel rankLabel2 = new JLabel();
	private JTextField numOfPlayersField = new JTextField(12);
	private JTextField avgFormField = new JTextField(12);
	private JTextField avgAgeField = new JTextField(12);
	private JTextField avgValueField = new JTextField(12);
	private JTextField sumValueField = new JTextField(12);

	
	public SokkerFrame(SokkerModel model, DefaultControler controler) {
		this.model = model;
		this.controler = controler;		
		setup();
		addListeners();		
	}
	
	private void setup() {
		UIManager.put("JFrame.activeTitleBackground", Color.BLACK);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("Sokker Stats");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(basePanel);	
		this.setMinimumSize(new Dimension(600, 350));
		basePanel.setBackground(Color.BLACK);
		basePanel.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setBackground(new Color(89, 139, 52));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,10,10,10);
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH; 
		//gbc.weightx = 0.4;
		mainPanel.add(menuParentPanel,gbc);		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10,0,0,10);	
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		//gbc.weightx = 0;
		mainPanel.add(detailsPanel,gbc);	
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10,0,10,10);	
		graphPanel.setBackground(Color.green);
		mainPanel.add(graphPanel,gbc);
		
		menuParentPanel.setBackground(new Color(30, 87, 47));
		menuParentPanel.setLayout(new BorderLayout());
		menuParentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		menuParentPanel.add(menuPanel, BorderLayout.PAGE_START);
		
		scanButton.setPreferredSize(new Dimension(10, 0));
		menuParentPanel.add(statsPanel);
		menuPanel.setLayout(new GridLayout(0, 2, 5, 5));
		menuPanel.setBackground(new Color(30, 87, 47));
		menuPanel.getInsets().set(20, 20, 20, 20);	
		menuPanel.add(formLabel);
		formLabel.setForeground(Color.white);
		formLabel.setBackground(Color.BLUE);
		formLabel.setPreferredSize(new Dimension(10, 0));
		menuPanel.add(formField);
		menuPanel.add(staminaLabel);
		staminaLabel.setForeground(Color.white);
		menuPanel.add(staminaField);
		menuPanel.add(passLabel);
		passLabel.setForeground(Color.white);
		menuPanel.add(passField);
		menuPanel.add(keeperLabel);
		keeperLabel.setForeground(Color.white);
		menuPanel.add(keeperField);
		menuPanel.add(defenderLabel);
		defenderLabel.setForeground(Color.white);
		menuPanel.add(defenderField);
		menuPanel.add(playmakerLabel);
		playmakerLabel.setForeground(Color.white);
		menuPanel.add(playmakerField);
		menuPanel.add(strikerLabel);
		strikerLabel.setForeground(Color.white);
		menuPanel.add(strikerField);
		menuPanel.add(paceLabel);
		paceLabel.setForeground(Color.white);
		menuPanel.add(paceField);
		menuPanel.add(techniqueLabel);
		techniqueLabel.setForeground(Color.white);
		menuPanel.add(techniqueField);
		menuPanel.add(scanButton);		
		cbModel.addElement(new Player("-------"));
		for (Player player :model.getPlayers()) {	
			cbModel.addElement(player);
		}
		currentPlayerCB.setModel(cbModel);
		menuPanel.add(currentPlayerCB,BorderLayout.NORTH);
		
		statsPanel.setLayout(new GridLayout(0, 2, 5, 5));
		statsPanel.setAlignmentX(TOP_ALIGNMENT);
		statsPanel.setBackground(new Color(30, 87, 47));
		statsPanel.getInsets().set(20, 20, 20, 20);	
		statsPanel.add(rankLabel);
		rankLabel.setForeground(Color.white);
		statsPanel.add(rankLabel2);
		rankLabel2.setForeground(Color.white);
		
		
		detailsPanel.setBackground(new Color(30, 87, 47));
		gbc.insets = new Insets(5,5,5,5);
		gbc.weightx = gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;
		//col 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		detailsPanel.add(nameLabel, gbc);
		nameLabel.setForeground(Color.white);
		gbc.gridy = 1;
		detailsPanel.add(surnameLabel, gbc);
		surnameLabel.setForeground(Color.white);
		gbc.gridy = 2;
		detailsPanel.add(valueLabel, gbc);
		valueLabel.setForeground(Color.white);
		gbc.gridy = 3;
		detailsPanel.add(wageLabel, gbc);
		wageLabel.setForeground(Color.white);
		//col 2
		gbc.gridx = 1;	
		gbc.gridy = 0;
		detailsPanel.add(nameField, gbc);
		gbc.gridy = 1;
		detailsPanel.add(surnameField, gbc);
		gbc.gridy = 2;
		detailsPanel.add(valueField, gbc);
		gbc.gridy = 3;
		detailsPanel.add(wageField, gbc);	
		//col 3
		gbc.gridx = 2;
		gbc.gridy = 0;
		detailsPanel.add(ageLabel, gbc);
		ageLabel.setForeground(Color.white);
		gbc.gridy = 1;
		detailsPanel.add(weightLabel, gbc);
		weightLabel.setForeground(Color.white);
		gbc.gridy = 2;
		detailsPanel.add(heightLabel, gbc);
		heightLabel.setForeground(Color.white);
		gbc.gridy = 3;
		detailsPanel.add(BMI_Label, gbc);
		BMI_Label.setForeground(Color.white);
		//col 4	
		gbc.gridx = 3;	
		gbc.gridy = 0;
		detailsPanel.add(ageField, gbc);
		gbc.gridy = 1;
		detailsPanel.add(weightField, gbc);
		gbc.gridy = 2;
		detailsPanel.add(heightField, gbc);
		gbc.gridy = 3;
		detailsPanel.add(BMI_Field, gbc);
		
		chart = ChartFactory.createXYStepChart(title, null, null, dataset, PlotOrientation.VERTICAL, false, false, false);
		chart.setBackgroundPaint(new Color(255, 167, 108));
		chart.getXYPlot().setBackgroundPaint(new Color(108,	108, 0));
		chart.getXYPlot().getRenderer().setSeriesPaint(0, new Color(255, 167, 108));
		chart.getXYPlot().getRenderer().setSeriesStroke(0, new BasicStroke(5));
		NumberAxis axis = (NumberAxis) chart.getXYPlot().getRangeAxis();
		axis.setRange(new Range(0, 19));
		ChartPanel cPanel = new ChartPanel(chart);
		cPanel.setBackground(new Color(193, 126, 2));
		graphPanel.add(cPanel);
		this.setFocusable(true);
		this.setAutoRequestFocus(true);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				requestFocus();
				super.mouseClicked(e);
			}
		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				controler.onKeyPressed(e);
				cbModel.setSelectedItem(model.getCurrentPlayer());
			}
		});
		this.revalidate();
		this.repaint();	
		this.setVisible(true);	
	}
	
	private void addListeners() {
		currentPlayerCB.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {	
				if (e.getStateChange() == 1) {
					Player player = (Player) e.getItem();
					controler.playerChanged(player);
				}			
			}
		});
		scanButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				controler.scan();
				updatePlayers();
			}
		});
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent ev) {
				revalidate();
				repaint();
			}
		});	
		formField.addMouseListener(new SkillClickListener(Skill.FORM, this));
		staminaField.addMouseListener(new SkillClickListener(Skill.STAMINA, this));
		passField.addMouseListener(new SkillClickListener(Skill.PASSES, this));
		defenderField.addMouseListener(new SkillClickListener(Skill.DEFENDING, this));
		keeperField.addMouseListener(new SkillClickListener(Skill.GOALKEEPING, this));
		playmakerField.addMouseListener(new SkillClickListener(Skill.PLAYMAKING, this));
		strikerField.addMouseListener(new SkillClickListener(Skill.STRIKER, this));
		paceField.addMouseListener(new SkillClickListener(Skill.PACE, this));
		techniqueField.addMouseListener(new SkillClickListener(Skill.TECHNIQUE, this));
		valueField.addMouseListener(new SkillClickListener(Skill.VALUE, this));
		wageField.addMouseListener(new SkillClickListener(Skill.WAGE, this));
	}	
	@Override
	public void updatePlayer() {
		try {
			Player player = model.getCurrentPlayer();
			if (player.getName() == null) {
				clear();
				this.revalidate();
				this.repaint();	
				return;
			}
			int index = player.getHistory().size() - 1;
			History history = player.getHistory().get(index);		
			nameField.setText(player.getName());
			surnameField.setText(player.getSurname());
			valueField.setText(StringFormater.parseMoney(history.getValue()));
			wageField.setText(StringFormater.parseMoney(history.getWage()));			
			heightField.setText(StringFormater.parseCmDistance(history.getHeight()));
			weightField.setText(StringFormater.parseWeight(history.getWeight()));
			BMI_Field.setText(String.valueOf(history.getBmi()));	
			ageField.setText(String.valueOf(history.getAge()));				
			int form = history.getForm();
			formField.setText(StringFormater.parseSkill(form));
			formField.setBackground(getSkillColor(form));
			int stamina = history.getStamina();
			staminaField.setText(StringFormater.parseSkill(stamina));
			staminaField.setBackground(getSkillColor(stamina));
			int pace = history.getPace();
			paceField.setText(StringFormater.parseSkill(pace));
			paceField.setBackground(getSkillColor(pace));
			int technique = history.getTechnique();			
			techniqueField.setText(StringFormater.parseSkill(technique));
			techniqueField.setBackground(getSkillColor(technique));
			int pass = history.getPassing();
			passField.setText(StringFormater.parseSkill(pass));
			passField.setBackground(getSkillColor(pass));
			int keeper = history.getKeeper();			
			keeperField.setText(StringFormater.parseSkill(keeper));
			keeperField.setBackground(getSkillColor(keeper));
			int deffender = history.getDefender();
			defenderField.setText(StringFormater.parseSkill(deffender));
			defenderField.setBackground(getSkillColor(deffender));
			int playmaker = history.getPlaymaker();	
			playmakerField.setText(StringFormater.parseSkill(playmaker));
			playmakerField.setBackground(getSkillColor(playmaker));
			int striker = history.getStriker();
			strikerField.setText(StringFormater.parseSkill(striker));
			strikerField.setBackground(getSkillColor(striker));
			this.revalidate();
			this.repaint();	
		} catch (NullPointerException e) {		
		}	
	}
	private void clear() {
		dataset.removeAllSeries();
		ageField.setText("");
		BMI_Field.setText("");
		heightField.setText("");
		weightField.setText("");
		nameField.setText("");
		surnameField.setText("");
		keeperField.setText("");
		keeperField.setBackground(Color.white);
		playmakerField.setText("");
		playmakerField.setBackground(Color.white);
		strikerField.setText("");
		strikerField.setBackground(Color.white);
		passField.setText("");
		passField.setBackground(Color.white);
		paceField.setText("");
		paceField.setBackground(Color.white);
		staminaField.setText("");
		staminaField.setBackground(Color.white);
		formField.setText("");
		formField.setBackground(Color.white);
		techniqueField.setText("");
		techniqueField.setBackground(Color.white);
		defenderField.setText("");
		defenderField.setBackground(Color.white);
		valueField.setText("");
		valueField.setBackground(Color.white);
		wageField.setText("");
		wageField.setBackground(Color.white);
	}
	
	private Color getSkillColor(int skill) {	
		int step = 28;
		int sum = skill*step;
		if (sum <= 255){
			int green = sum;
			return new Color(255, green, 0);
		} else {
			sum -= 255;
			int red = sum;
			return new Color(255-red, 255, 0);
		}	
	}

	@Override
	public void updateChart() {
		ChartModel metaChart = model.getChartModel();
		chart.setTitle(metaChart.getTitle());	
		dataset.removeAllSeries();
		dataset.addSeries(metaChart.getDataseries());	
		NumberAxis axis = (NumberAxis) chart.getXYPlot().getRangeAxis();
		if (model.getSkill().equals(Skill.VALUE) || model.getSkill().equals(Skill.WAGE)) {		
			axis.setAutoRange(true);
			axis.setAutoRangeIncludesZero(false);
		} else {
			axis.setRange(new Range(0, 19));
		}
	}

	@Override
	public void updatePlayers() {
		cbModel.removeAllElements();
		for (Player player :model.getPlayers()) {	
			cbModel.addElement(player);
		}
	}

	@Override
	public void updateSkill(Skill skill) {
		model.setSkill(skill);
	}
}
