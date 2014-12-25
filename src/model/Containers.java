package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Containers")
public class Containers {
	
	@XStreamAlias("RefLogicalTable")
	private NameAttribute logicalTable;

	public NameAttribute getLogicalTable() {
		return logicalTable;
	}

	public void setLogicalTable(NameAttribute logicalTable) {
		this.logicalTable = logicalTable;
	}

}
