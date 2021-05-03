package com.fb.vision;

public class NameUrlLabel {
	private String name;
	private String url;
	private String label;
	
	public NameUrlLabel(String name, String url, String label) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.url = url;
		this.label = label;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
