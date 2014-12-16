package model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Join")
public class Join {

	@XStreamAsAttribute
	private String type;
	
	@XStreamImplicit
	@XStreamAlias("RefPhysicalTable")
	private List<NameAttribute> tables = new ArrayList<>();
	
	@XStreamAlias("RefPhysicalComplexJoin")
	private NameAttribute complexJoin;
	
	@XStreamAlias("RefPhysicalForeignKey")
	private NameAttribute foreignKey;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<NameAttribute> getTables() {
		return tables;
	}

	public void setTables(List<NameAttribute> tables) {
		this.tables = tables;
	}

	public NameAttribute getComplexJoin() {
		return complexJoin;
	}

	public void setComplexJoin(NameAttribute complexJoin) {
		this.complexJoin = complexJoin;
	}

	public NameAttribute getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(NameAttribute foreignKey) {
		this.foreignKey = foreignKey;
	}
	
}
