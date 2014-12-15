package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("LevelAssociation")
public class LevelAssociation {

	@XStreamAlias("RefLogicalLevel")
	private NameAttribute logicalLevel;
	
	@XStreamAlias("RefDimension")
	private NameAttribute dimension;

	public NameAttribute getLogicalLevel() {
		return logicalLevel;
	}

	public void setLogicalLevel(NameAttribute logicalLevel) {
		this.logicalLevel = logicalLevel;
	}

	public NameAttribute getDimension() {
		return dimension;
	}

	public void setDimension(NameAttribute dimension) {
		this.dimension = dimension;
	}
	
}
