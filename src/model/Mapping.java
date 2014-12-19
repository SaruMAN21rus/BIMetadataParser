package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.ExpressionConverter;
import converters.NameListConverter;

@XStreamAlias("Mapping")
public class Mapping {

	@XStreamAlias("Source")
	@XStreamConverter(NameListConverter.class)
	private String source;
	
	@XStreamAlias("Expression")
	@XStreamConverter(ExpressionConverter.class)
	private String expression;

	@XStreamAlias("RefLogicalColumn")
	private NameAttribute logicalColumn;
	
	@XStreamAlias("RefPhysicalTable")
	private NameAttribute physicalTable;

	public NameAttribute getLogicalColumn() {
		return logicalColumn;
	}

	public void setLogicalColumn(NameAttribute logicalColumn) {
		this.logicalColumn = logicalColumn;
	}
	
	public NameAttribute getPhysicalTable() {
		return physicalTable;
	}

	public void setPhysicalTable(NameAttribute physicalTable) {
		this.physicalTable = physicalTable;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
}
