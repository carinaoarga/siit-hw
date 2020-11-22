package hw3objectcontainers;

import java.util.Set;
import java.util.TreeSet;

public class MainPersoaneTreeSet {

    public static void main(String[] args) {

        Set<Persoana> nameSortedPersons = new TreeSet<>(new NameComparator());
        nameSortedPersons.add(new Persoana("Carina", 25));
        nameSortedPersons.add(new Persoana("Gabriela", 53));
        nameSortedPersons.add(new Persoana("David", 17));
        nameSortedPersons.add(new Persoana("Vlad", 54));
        nameSortedPersons.add(new Persoana("Luca", 29));

        System.out.println("----------> Displaying the persons with name sorting: ");
        for (Persoana person : nameSortedPersons){
            System.out.println(person);
        }

        Set<Persoana> ageSortedPersons = new TreeSet<>(new AgeComparator());
        ageSortedPersons.addAll(nameSortedPersons);

        System.out.println("----------> Displaying the persons with age sorting: ");
        for (Persoana person : ageSortedPersons){
            System.out.println(person);
        }

    }
}
