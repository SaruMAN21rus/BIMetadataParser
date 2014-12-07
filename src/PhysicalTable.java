import java.util.HashSet;
import java.util.Set;


public class PhysicalTable implements Metadata {

	private Set<PhysicalColumn> columns = new HashSet<>();
	private String href;
	private String name;
	private Set<PhysicalForeignKey> fkeys = new HashSet<>();
	private Set<PhysicalKey> keys = new HashSet<>();

	public PhysicalTable() {
	}

	public Set<PhysicalColumn> getColumns() {
		return columns;
	}

	public void setColumns(Set<PhysicalColumn> columns) {
		this.columns = columns;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PhysicalForeignKey> getFkeys() {
		return fkeys;
	}

	public void setFkeys(Set<PhysicalForeignKey> fkeys) {
		this.fkeys = fkeys;
	}

	public Set<PhysicalKey> getKeys() {
		return keys;
	}

	public void setKeys(Set<PhysicalKey> keys) {
		this.keys = keys;
	}

}
