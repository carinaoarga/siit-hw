package hw3objectcontainers;

import java.util.Objects;

public class Persoana {
    private String name;
    private int age;

    public Persoana(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Persoana(String name){
        this.name = name;
        this.age = 18;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person: " +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                ';';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Persoana persoana = (Persoana)obj;
        return (this.age == persoana.age) && Objects.equals(this.name, persoana.name);
    }
}
