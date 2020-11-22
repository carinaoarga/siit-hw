package hw3objectcontainers;

import java.util.List;

public class Hobby {
    private String name;
    private int frequency;
    private List<Address> addresses;

    public Hobby(String name, int frequency, List<Address> addresses){
        this.name = name;
        this.frequency = frequency;
        this.addresses = addresses;
    }

    public Hobby(String name, int frequency){
        this.name = name;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void addAddress(Address address){
        this.addresses.add(address);
    }

    public String addressesToString(){
        String toString = "";
        for (Address address : addresses){
            toString = toString.concat(address.toString() + ";");
        }
        return toString;
    }

    @Override
    public String toString() {
        return "[hobby='" + name + '\'' +
                ", frequency=" + frequency +
                ", addresses=" + addressesToString() +
                ']';
    }
}
