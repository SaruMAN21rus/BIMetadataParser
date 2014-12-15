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
