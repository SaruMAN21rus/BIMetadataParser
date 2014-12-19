package model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("LogicalTableSource")
public class LogicalTableSource {

	@XStreamAsAttribute
	private String name;
	
	@XStreamAlias("ColumnMappings")
	private List<Mapping> mappings = new ArrayList<>();
	
	@XStreamAlias("Joins")
	private List<Join> joins = new ArrayList<>();
	
	@XStreamAlias("WhereClause")
	private WhereClause whereClause;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}

	public List<Join> getJoins() {
		return joins;
	}

	public void setJoins(List<Join> joins) {
		this.joins = joins;
	}

	public WhereClause getWhereClause() {
		return whereClause;
	}

	public void setWhereClause(WhereClause whereClause) {
		this.whereClause = whereClause;
	}
	
}
