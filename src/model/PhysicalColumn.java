package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("PhysicalColumn")
public class PhysicalColumn {
	
   	@XStreamAsAttribute
	private String dataType;
	
   	@XStreamAsAttribute
	private Boolean nullable;
	
   	@XStreamAsAttribute
	private Integer length;
	
   	@XStreamAsAttribute
	private String name;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Boolean getNullable() {
		return nullable;
	}

	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   	
}
