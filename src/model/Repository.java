package model;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Repository")
public class Repository {

	@XStreamAlias("PhysicalColumn")
	private PhysicalColumn physicalColumn;
	
	@XStreamAlias("PhysicalTable")
	private PhysicalTable physicalTable;
	
	@XStreamAlias("PhysicalKey")
	private PhysicalKey physicalKey;

	public PhysicalColumn getPhysicalColumn() {
		return physicalColumn;
	}

	public void setPhysicalColumn(PhysicalColumn physicalColumn) {
		this.physicalColumn = physicalColumn;
	}

	public PhysicalTable getPhysicalTable() {
		return physicalTable;
	}

	public void setPhysicalTable(PhysicalTable physicalTable) {
		this.physicalTable = physicalTable;
	}

	public PhysicalKey getPhysicalKey() {
		return physicalKey;
	}

	public void setPhysicalKey(PhysicalKey physicalKey) {
		this.physicalKey = physicalKey;
	}
	
}
