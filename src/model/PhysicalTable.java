package model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.RefsConverter;

@XStreamAlias("PhysicalTable")
public class PhysicalTable {

	@XStreamConverter(value=RefsConverter.class, types={PhysicalColumn.class})
	@XStreamAlias("PhysicalColumns")
	private List<PhysicalColumn> physicalColumns = new ArrayList<>();
	
	@XStreamAsAttribute
	private String name;
	
	@XStreamConverter(value=RefsConverter.class, types={PhysicalKey.class})
	@XStreamAlias("PhysicalKeys")
	private List<PhysicalKey> physicalKeys = new ArrayList<>();
	
	@XStreamConverter(value=RefsConverter.class, types={PhysicalForeignKey.class})
	@XStreamAlias("PhysicalForeignKeys")
	private List<PhysicalForeignKey> physicalForeignKeys = new ArrayList<>();

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

	public List<PhysicalForeignKey> getPhysicalForeignKeys() {
		return physicalForeignKeys;
	}

	public void setPhysicalForeignKeys(List<PhysicalForeignKey> physicalForeignKeys) {
		this.physicalForeignKeys = physicalForeignKeys;
	}

}
