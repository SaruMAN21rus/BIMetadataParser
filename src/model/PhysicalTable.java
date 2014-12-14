package model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.RefPhysicalColumnConverter;
import converters.RefPhysicalKeyConverter;

@XStreamAlias("PhysicalTable")
public class PhysicalTable {

	@XStreamConverter(RefPhysicalColumnConverter.class)
	@XStreamAlias("PhysicalColumns")
	private List<PhysicalColumn> physicalColumns = new ArrayList<>();
	
	@XStreamAsAttribute
	private String name;
	
	@XStreamConverter(RefPhysicalKeyConverter.class)
	@XStreamAlias("PhysicalKeys")
	private List<PhysicalKey> physicalKeys = new ArrayList<>();

	public List<PhysicalColumn> getPhysicalColumns() {
		return physicalColumns;
	}

	public void setPhysicalColumns(List<PhysicalColumn> physicalColumns) {
		this.physicalColumns = physicalColumns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PhysicalKey> getPhysicalKeys() {
		return physicalKeys;
	}

	public void setPhysicalKeys(List<PhysicalKey> physicalKeys) {
		this.physicalKeys = physicalKeys;
	}

}
