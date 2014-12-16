package model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.RefsConverter;

@XStreamAlias("LogicalTable")
public class LogicalTable {

	@XStreamConverter(value=RefsConverter.class, types={LogicalColumn.class})
	@XStreamAlias("LogicalColumns")
	private List<LogicalColumn> logicalColumns = new ArrayList<>();
	
	@XStreamAsAttribute
	private String name;
	
	@XStreamConverter(value=RefsConverter.class, types={LogicalTableSource.class})
	@XStreamAlias("LogicalTableSources")
	private List<LogicalTableSource> sources = new ArrayList<>();

	public List<LogicalColumn> getLogicalColumns() {
		return logicalColumns;
	}

	public void setLogicalColumns(List<LogicalColumn> logicalColumns) {
		this.logicalColumns = logicalColumns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LogicalTableSource> getSources() {
		return sources;
	}

	public void setSources(List<LogicalTableSource> sources) {
		this.sources = sources;
	}
	
}
