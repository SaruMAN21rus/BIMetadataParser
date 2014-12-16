package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.ExpressionConverter;

@XStreamAlias("Mapping")
public class ColumnMapping {

	@XStreamAlias("RefLogicalColumn")
	private NameAttribute logicalColumn;
	
	@XStreamAlias("Expression")
	@XStreamConverter(ExpressionConverter.class)
	private String expression;
	
	@XStreamAlias("RefPhysicalTable")
	private NameAttribute phusicalTable;

	public NameAttribute getLogicalColumn() {
		return logicalColumn;
	}

	public void setLogicalColumn(NameAttribute logicalColumn) {
		this.logicalColumn = logicalColumn;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public NameAttribute getPhusicalTable() {
		return phusicalTable;
	}

	public void setPhusicalTable(NameAttribute phusicalTable) {
		this.phusicalTable = phusicalTable;
	}
	
}
