package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.NameListConverter;

@XStreamAlias("PhysicalKey")
public class PhysicalKey {

	@XStreamConverter(NameListConverter.class)
	@XStreamAlias("PhysicalColumns")
	private String physicalColumns;
	
	@XStreamAsAttribute
	private String name;
	
	@XStreamAsAttribute
	private boolean primary;
	
	public String getPhysicalColumns() {
		return physicalColumns;
	}

	public void setPhysicalColumns(String physicalColumns) {
		this.physicalColumns = physicalColumns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
}
