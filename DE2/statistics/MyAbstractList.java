package hus.oop.statistics;

public abstract class MyAbstractList implements MyList {
    public MyAbstractList() {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyIterator it = iterator(0);
        while (it.hasNext()) {
            sb.append(it.next()).append(" ");
        }
        return sb.toString().trim();
    }
}
