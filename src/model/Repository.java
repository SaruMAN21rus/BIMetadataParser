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
	
	@XStreamAlias("LogicalKey")
	private LogicalKey logicalKey;
	
	@XStreamAlias("LogicalForeignKey")
	private LogicalForeignKey logicalForeignKey;

	@XStreamAlias("Dimension")
	private Dimension dimension;
	
	@XStreamAlias("LogicalLevel")
	private LogicalLevel logicalLevel;

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

	public LogicalKey getLogicalKey() {
		return logicalKey;
	}

	public void setLogicalKey(LogicalKey logicalKey) {
		this.logicalKey = logicalKey;
	}

	public LogicalForeignKey getLogicalForeignKey() {
		return logicalForeignKey;
	}

	public void setLogicalForeignKey(LogicalForeignKey logicalForeignKey) {
		this.logicalForeignKey = logicalForeignKey;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public LogicalLevel getLogicalLevel() {
		return logicalLevel;
	}

	public void setLogicalLevel(LogicalLevel logicalLevel) {
		this.logicalLevel = logicalLevel;
	}
	
}
