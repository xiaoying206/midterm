package oop.statistics;

public abstract class AbstractMyVector implements MyVector {

    @Override
    public boolean equals(MyVector other) {
        if (other == null || this.size() != other.size()) return false;
        for (int i = 0; i < this.size(); i++) {
            if (Double.compare(this.coordinate(i), other.coordinate(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            sb.append(coordinate(i));
            if (i < size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}