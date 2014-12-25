package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.ExpressionConverter;
import converters.LogicalColumnConverter;
import converters.NameListConverter;
import converters.RefsConverter;

@XStreamAlias("Mapping")
public class Mapping {

	@XStreamAlias("Source")
	@XStreamConverter(NameListConverter.class)
	private List<String> source = new ArrayList<>();
	
	@XStreamAlias("Expression")
	@XStreamConverter(ExpressionConverter.class)
	private String expression;

	@XStreamAlias("RefLogicalColumn")
	@XStreamConverter(LogicalColumnConverter.class)
	private LogicalColumn logicalColumn;
	
	@XStreamAlias("RefPhysicalTable")
	private NameAttribute physicalTable;
	
	@XStreamAlias("RefPresentationColumn")
	private NameAttribute presentationColumn;
	
	public NameAttribute getPhysicalTable() {
		return physicalTable;
	}

	public void setPhysicalTable(NameAttribute physicalTable) {
		this.physicalTable = physicalTable;
	}

	public String getSource() {
		return StringUtils.join(source, ", ");
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public LogicalColumn getLogicalColumn() {
		return logicalColumn;
	}

	public void setLogicalColumn(LogicalColumn logicalColumn) {
		this.logicalColumn = logicalColumn;
	}

	public NameAttribute getPresentationColumn() {
		return presentationColumn;
	}

	public void setPresentationColumn(NameAttribute presentationColumn) {
		this.presentationColumn = presentationColumn;
	}
	
}
