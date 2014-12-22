package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.NameListConverter;

@XStreamAlias("LogicalKey")
public class LogicalKey {

	@XStreamConverter(NameListConverter.class)
	@XStreamAlias("LogicalColumns")
	private List<String> logicalColumns = new ArrayList<>();
	
	@XStreamAsAttribute
	private String name;
	
	@XStreamAsAttribute
	private boolean primary;

	public String getLogicalColumns() {
		return StringUtils.join(logicalColumns, ", ");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
}
