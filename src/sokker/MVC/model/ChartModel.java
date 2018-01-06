
package sokker.MVC.model;

import org.jfree.data.xy.XYSeries;

import sokker.utils.Skill;

public class ChartModel {
	
	private Skill skill;
	private String title = "";
	private String xlab = null;
	private String ylab = null;
	private XYSeries dataseries;
	private boolean legend = false;
	private boolean tooltips = false;
	private boolean urls = false;
	
	
	public ChartModel(Skill skill) {
		this.setSkill(skill);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getXlab() {
		return xlab;
	}
	public void setXlab(String xlab) {
		this.xlab = xlab;
	}
	public String getYlab() {
		return ylab;
	}
	public void setYlab(String ylab) {
		this.ylab = ylab;
	}
	public XYSeries getDataseries() {
		return dataseries;
	}
	public void setDataseries(XYSeries dataseries) {
		this.dataseries = dataseries;
	}
	public boolean isLegend() {
		return legend;
	}
	public void setLegend(boolean legend) {
		this.legend = legend;
	}
	public boolean isTooltips() {
		return tooltips;
	}
	public void setTooltips(boolean tooltips) {
		this.tooltips = tooltips;
	}
	public boolean isUrls() {
		return urls;
	}
	public void setUrls(boolean urls) {
		this.urls = urls;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
