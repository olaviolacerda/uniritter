package hash.table;

import java.io.Serializable;

public class GetMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 928919997165904632L;
	private String key;

	public GetMsg(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return this.key;
	}
}
