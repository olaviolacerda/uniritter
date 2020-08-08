package parserMMML;

    public class NestedTest {
        public static void main(String[] args)
        {
            NestedSymbolTable<Integer> mt = new NestedSymbolTable<Integer>();
            mt.store("lala", 0);
            mt.store("lele", 1);
            NestedSymbolTable<Integer> nt1 = new NestedSymbolTable<Integer>(mt);
            nt1.store("lala", 10);
            NestedSymbolTable<Integer> nt2 = new NestedSymbolTable<Integer>(mt);
            nt2.store("lala", 11);

            System.out.println(nt2.lookup("lele"));
            for (SymbolEntry<Integer> entry : nt2.getEntries()) {
                System.out.println("nt2 Entry: " + entry);
            }

            for (SymbolEntry<Integer> entry : nt1.getEntries()) {
                System.out.println("nt1 Entry: " + entry);
            }

            for (SymbolEntry<Integer> entry : mt.getEntries()) {
                System.out.println("mt Entry: " + entry);
            }
        }
    }
