package hash.table;

import java.io.Serializable;

public class GetReply implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8095260827106001121L;
	private ValueHash item;

	public GetReply(ValueHash item) {
		this.item = item;
	}

	public ValueHash getItem() {
		return this.item;
	}
}
