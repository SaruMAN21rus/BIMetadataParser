import java.util.HashSet;
import java.util.Set;


public class PhysicalKey implements Metadata {

	private Set<PhysicalColumn> columns = new HashSet<>();
	private String href;
	private String name;
	
	public PhysicalKey() {
		super();
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
	
}
