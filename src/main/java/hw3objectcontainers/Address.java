package hw3objectcontainers;

public class Address {
    private String address;
    private Country country;

    public Address(String address, Country country){
        this.address = address;
        this.country = country;
    }

    @Override
    public String toString() {
        return "(address='" + address + '\'' +
                ", country=" + country.name() +
                ')';
    }
}
