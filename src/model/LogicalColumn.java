package model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("LogicalColumn")
public class LogicalColumn {

	@XStreamAsAttribute
	private String name;
	
	@XStreamAlias("Mapping")
	private Mapping mapping;
	
	@XStreamAlias("Mappings")
	private List<Mapping> mappings = new ArrayList<>();
	
	@XStreamAlias("LevelAssociations")
	private List<LevelAssociation> levelAssociations = new ArrayList<>();
	
	@XStreamAlias("Aggregations")
	private List<Aggregation> aggregations = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mapping getMapping() {
		return mapping;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}

	public List<LevelAssociation> getLevelAssociations() {
		return levelAssociations;
	}

	public void setLevelAssociations(List<LevelAssociation> levelAssociations) {
		this.levelAssociations = levelAssociations;
	}

	public List<Aggregation> getAggregations() {
		return aggregations;
	}

	public void setAggregations(List<Aggregation> aggregations) {
		this.aggregations = aggregations;
	}
	
}
