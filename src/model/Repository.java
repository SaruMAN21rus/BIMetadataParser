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
	
	@XStreamAlias("PhysicalForeignKey")
	private PhysicalForeignKey physicalForeignKey;
	
	@XStreamAlias("PhysicalComplexJoin")
	private PhysicalComplexJoin physicalComplexJoin;
	
	@XStreamAlias("LogicalColumn")
	private LogicalColumn logicalColumn;
	
	@XStreamAlias("LogicalTable")
	private LogicalTable logicalTable;
	
	@XStreamAlias("LogicalTableSource")
	private LogicalTableSource logicalTableSource;

	public LogicalTableSource getLogicalTableSource() {
		return logicalTableSource;
	}

	public void setLogicalTableSource(LogicalTableSource logicalTableSource) {
		this.logicalTableSource = logicalTableSource;
	}

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

	public PhysicalForeignKey getPhysicalForeignKey() {
		return physicalForeignKey;
	}

	public void setPhysicalForeignKey(PhysicalForeignKey physicalForeignKey) {
		this.physicalForeignKey = physicalForeignKey;
	}

	public PhysicalComplexJoin getPhysicalComplexJoin() {
		return physicalComplexJoin;
	}

	public void setPhysicalComplexJoin(PhysicalComplexJoin physicalComplexJoin) {
		this.physicalComplexJoin = physicalComplexJoin;
	}

	public LogicalColumn getLogicalColumn() {
		return logicalColumn;
	}

	public void setLogicalColumn(LogicalColumn logicalColumn) {
		this.logicalColumn = logicalColumn;
	}

	public LogicalTable getLogicalTable() {
		return logicalTable;
	}

	public void setLogicalTable(LogicalTable logicalTable) {
		this.logicalTable = logicalTable;
	}
	
}
