package hash.table;

import java.io.Serializable;

public class PutMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1824207598351640071L;
	private String key;
	private ValueHash item;

	public PutMsg(String key, ValueHash item) {
		this.key = key;
		this.item = item;
	}

	public String getKey() {
		return this.key;
	}
	
	public ValueHash getItem() {
		return this.item;
	}
}
