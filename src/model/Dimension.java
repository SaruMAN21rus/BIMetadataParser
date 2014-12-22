package model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.NameListConverter;
import converters.RefsConverter;

@XStreamAlias("Dimension")
public class Dimension {

	@XStreamAsAttribute
	private String name;
	
	@XStreamAsAttribute
	private boolean timeDimension;
	
	@XStreamAlias("LogicalTables")
	@XStreamConverter(NameListConverter.class)
	private List<String> logicalTables = new ArrayList<>();
	
	@XStreamAlias("LogicalLevels")
	@XStreamConverter(value=RefsConverter.class, types={LogicalLevel.class})
	private List<LogicalLevel> logicalLevels = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getLogicalTables() {
		return logicalTables;
	}

	public void setLogicalTables(List<String> logicalTables) {
		this.logicalTables = logicalTables;
	}

	public List<LogicalLevel> getLogicalLevels() {
		return logicalLevels;
	}

	public void setLogicalLevels(List<LogicalLevel> logicalLevels) {
		this.logicalLevels = logicalLevels;
	}

	public boolean isTimeDimension() {
		return timeDimension;
	}

	public void setTimeDimension(boolean timeDimension) {
		this.timeDimension = timeDimension;
	}
	
	
}
