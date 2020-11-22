package hw3objectcontainers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainHobbiesHashMap {

    private HashMap<Persoana, List<Hobby>> hobbiesMap;

    public void addHobby(String name, int age, String hobbyName, int frequency){
        Persoana p = new Persoana(name,age);
        Hobby hobby = new Hobby(hobbyName, frequency);
        if (this.hobbiesMap.containsKey(p)){
            hobbiesMap.get(p).add(hobby);
        } else {
            List<Hobby> hobbies = new ArrayList<>();
            hobbies.add(hobby);
            hobbiesMap.put(p,hobbies);
        }
    }

    public void addAddress(String hobbyName, String address, Country country){
        hobbiesMap.forEach((k,v) -> {
            for (Hobby h : v){
                if (h.getName().equals(hobbyName)){
                    h.addAddress(new Address(address, country));
                }
            }
        });

    }

    @Override
    public String toString() {
        final String[] toReturn = {""};
        hobbiesMap.forEach((k,v)->{
            String hobbiesToString = "";
            for (Hobby h : v){
                hobbiesToString.concat(h.toString() + ";");
            }
            String temp = "{Persoana = " + k.getName() + "; "+ hobbiesToString+"}";
            toReturn[0] += temp;
            toReturn[0] += System.lineSeparator();
        });

        return toReturn[0];
    }

    public static void main(String[] args) {
        MainHobbiesHashMap test = new MainHobbiesHashMap();

        test.addHobby("Carina", 25, "swimming", 2);
        test.addHobby("David", 17, "jogging", 1);
        test.addHobby("Carina", 25, "reading", 4);
        test.addHobby("David", 17, "swimming", 1);

        test.addAddress("swimming", "Adresa inot Romania", Country.Romania);
        test.addAddress("swimming", "adresa inot Grecia", Country.Greece);
        test.addAddress("reading", "Adresa citit Luxemburg", Country.Luxembourg);
        test.addAddress("jogging", "Adresa alergat Germania", Country.Germany);

        System.out.println(test);

    }
}
