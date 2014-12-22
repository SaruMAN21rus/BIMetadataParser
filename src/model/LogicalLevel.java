package model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.RefsConverter;

@XStreamAlias("LogicalLevel")
public class LogicalLevel {

	@XStreamAsAttribute
	private String name;
	
	@XStreamAsAttribute
	private boolean grandTotal;
	
	@XStreamConverter(value=RefsConverter.class, types={LogicalKey.class})
	@XStreamAlias("LevelKeys")
	private List<LogicalKey> levelKeys = new ArrayList<>();
	
	@XStreamConverter(value=RefsConverter.class, types={LogicalColumn.class})
	@XStreamAlias("LogicalColumns")
	private List<LogicalColumn> logicalColumns = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(boolean grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<LogicalKey> getLevelKeys() {
		return levelKeys;
	}

	public void setLevelKeys(List<LogicalKey> levelKeys) {
		this.levelKeys = levelKeys;
	}

	public List<LogicalColumn> getLogicalColumns() {
		return logicalColumns;
	}

	public void setLogicalColumns(List<LogicalColumn> logicalColumns) {
		this.logicalColumns = logicalColumns;
	}
	
	
}
