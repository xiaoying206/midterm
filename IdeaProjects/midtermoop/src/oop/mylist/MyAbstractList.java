package oop.mylist;

public abstract class MyAbstractList implements MyList {
    public MyAbstractList() {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        MyIterator it = iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}