package hw3objectcontainers;

import java.util.Comparator;

public class NameComparator implements Comparator<Persoana> {

    @Override
    public int compare(Persoana o1, Persoana o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
