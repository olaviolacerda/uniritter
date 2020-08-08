package parserMMML;

import java.util.*;

class SymbolEntry<T> {
	public T symbol;
	public int offset;
	public int size;
	public String nome;

	public SymbolEntry(String nome, T symbol, int offset, int size) {
		this.symbol = symbol;
		this.offset = offset;
		this.size = size;
		this.nome = nome;
	}

	public String toString() {
		return " nome:" + nome + " tipo:" + symbol + " pos:" + offset + "\n";
	}
}

public class NestedSymbolTable<T> {
	/*-----------------------------------------------------------------------------
	 * Function: NestedSymbolTable (ctor)
	 * Description: Creates a new symbol table, child of parent, starting in the
	 *              specified offset
	 *---------------------------------------------------------------------------*/
	public NestedSymbolTable(NestedSymbolTable<T> parent, int offset) {
		this.size = 0;
		this.parent = parent;
		this.baseOffset = offset;
		this.nextOffset = offset;
		this.storage = new HashMap<String, SymbolEntry<T>>();
		this.nested = new ArrayList<NestedSymbolTable<T>>();
		if (parent != null) {
			this.entriesCount = parent.entriesCount;
			parent.nested.add(this);
		} else
			this.entriesCount = 0;
	}

	/*-----------------------------------------------------------------------------
	 * Function: NestedSymbolTable (ctor)
	 * Description: Created a new fist-level symbol table
	 *---------------------------------------------------------------------------*/
	public NestedSymbolTable() {
		this(null, 0);
	}

	/*-----------------------------------------------------------------------------
	 * Function: NestedSymbolTable (ctor)
	 * Description: Creates a new symbol table nested within parent
	 *---------------------------------------------------------------------------*/
	public NestedSymbolTable(NestedSymbolTable<T> parent) {
		this(parent, (parent == null ? 0 : parent.nextOffset));
	}

	/*-----------------------------------------------------------------------------
	 * Function: Discard
	 * Description: This table won't be used, remove it from parent list along with
	 *              all it's children
	 *---------------------------------------------------------------------------*/
	public void discard() {
		if (parent != null) {
			parent.nested.remove(this);
		}

	}

	// Private Members
	private int baseOffset, nextOffset, size, entriesCount;

	private List<NestedSymbolTable<T>> nested;

	private Map<String, SymbolEntry<T>> storage;

	private NestedSymbolTable<T> parent;

	// Public Properties

	public NestedSymbolTable<T> getParent() {
		return this.parent;
	}

	public List<NestedSymbolTable<T>> getNested() {
		return this.nested;
	}

	public int getBaseOffset() {
		return this.baseOffset;
	}

	public int getSize() {
		return this.size;
	}

	public int getCount() {
		return this.entriesCount;
	}

	/*-----------------------------------------------------------------------------
	 * Function: NestedCount (property), get
	 * Description: How many entries are there (total) in the whole symbol-table tree
	 *              beginning at this one?
	 *---------------------------------------------------------------------------*/
	public int getNestedCount() {
		if (nested.size() == 0)
			return getCount();
		else {
			int max = -1;
			for (NestedSymbolTable<T> t : this.nested) {
				int tc = t.getNestedCount();
				if (tc > max)
					max = tc;
			}
			return max;
		}
	}

	/*-----------------------------------------------------------------------------
	 * Function: NestedSize (property), get
	 * Description: What is the size needed to store the symbols in the symbol-table
	 *              tree beginning at this one?
	 *---------------------------------------------------------------------------*/
	public int getNestedSize() {
		if (nested.size() == 0)
			return getSize();
		else {
			int max = -1;
			for (NestedSymbolTable<T> t : this.nested) {
				int tc = t.getNestedSize();
				if (tc > max)
					max = tc;
			}
			return max;
		}
	}

	/*-----------------------------------------------------------------------------
	 * Function: NestedSymbolTable<T>::store
	 * Description: Stores a symbol on the symbol table. Default size of the
	 *              symbol on memory is 1. If there is a name clash, discards
	 *              the old symbol. This may leave holes in the memory, could be
	 *              optimized
	 *---------------------------------------------------------------------------*/
	public int store(String name, T symbol, int size) {
		int symbolOffset = this.nextOffset;
		if (!storage.containsKey(name))
			this.entriesCount++;
		this.size += size;
		this.nextOffset += size;

		storage.put(name, new SymbolEntry<T>(name, symbol, symbolOffset, size));

		return symbolOffset;
	}

	public int store(String name, T symbol) {
		return this.store(name, symbol, 1);
	}

	/*-----------------------------------------------------------------------------
	 * Function: lookup
	 * Description: Looks up the simbol and gives the entry. Offset is absolute,
	 *              from the root of the tree.
	 *
	 *              For relative offsets, do
	 *                 var se = table.lookup(text);
	 *                 int relOffset = se.offset - table.BaseOffset
	 *---------------------------------------------------------------------------*/
	public SymbolEntry<T> lookup(String symbol, int maxLevel) {
		NestedSymbolTable<T> cur_table = this;

		while (cur_table != null && maxLevel > 0) {
			if (cur_table.storage.containsKey(symbol)) {
				return cur_table.storage.get(symbol);
			}

			cur_table = cur_table.getParent();

			maxLevel--;
		}

		return null;
	}

	public SymbolEntry<T> lookup(String symbol) {
		return this.lookup(symbol, Integer.MAX_VALUE);
	}

	/*-----------------------------------------------------------------------------
	 * Function: getEntries
	 * Description: Returns an enumerator over the sorted array of entries
	 *              We fill entries with recursiveFillEntries, which will store
	 *              in the array the entries of the parents and the current
	 *---------------------------------------------------------------------------*/
	public ArrayList<SymbolEntry<T>> getEntries() {
		ArrayList<SymbolEntry<T>> values = new ArrayList<SymbolEntry<T>>(
				this.entriesCount);

		recursiveFillEntries(this, values);

		Collections.sort(values, (a, b) -> b.offset - a.offset);

		return values;
	}

	/*-----------------------------------------------------------------------------
	 * Function: RecurseFillEntries
	 * Description: Stores in values all the entries in the current table and
	 *              its parents as well
	 *---------------------------------------------------------------------------*/
	private static <T> int recursiveFillEntries(NestedSymbolTable<T> current,
			ArrayList<SymbolEntry<T>> values) {
		if (current == null)
			return 0;
		else {
			int offset = recursiveFillEntries(current.parent, values);

			for (SymbolEntry<T> e : current.storage.values()) {
				values.add(e);
			}
			return offset;
		}
	}
}
