package model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.ExpressionConverter;
import converters.NameListConverter;

@XStreamAlias("LogicalComplexJoin")
public class LogicalComplexJoin {

	@XStreamAsAttribute
	private String name;
	
	@XStreamAsAttribute
	private String type;
	
	@XStreamConverter(NameListConverter.class)
	@XStreamAlias("LogicalTables")
	private List<String> logicalTables = new ArrayList<>();
	
	@XStreamAlias("Expression")
	@XStreamConverter(ExpressionConverter.class)
	private String expression;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getLogicalTables() {
		return logicalTables;
	}

	public void setLogicalTables(List<String> logicalTables) {
		this.logicalTables = logicalTables;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	
}
