package model;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class NameAttribute {

	@XStreamAsAttribute
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
