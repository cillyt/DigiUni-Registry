import java.util.ArrayList;
import java.util.List;

public class University {
    String fullUniversityName;
    String shortUniversityName;
    String city;
    String address;
    static List<Faculty> faculties = new ArrayList<>();

    University(String fullUniversityName, String shortUniversityName, String city, String address) {
        this.fullUniversityName = fullUniversityName;
        this.shortUniversityName = shortUniversityName;
        this.city = city;
        this.address = address;
    }

    public String getFullUniversityName() {
        return fullUniversityName;
    }

    public void setFullUniversityName(String fullUniversityName) {
        this.fullUniversityName = fullUniversityName;
    }

    public String getShortUniversityName() {
        return shortUniversityName;
    }
    public void setShortUniversityName(String shortUniversityName) {
        this.shortUniversityName = shortUniversityName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Повна назва університету: " +  fullUniversityName + ", Скорочена назва університету: " + shortUniversityName + ", місто перебування: " + city + ", адреса: " + address;
    }
}
