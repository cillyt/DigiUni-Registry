import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class University {
    String fullUniversityName;
    String shortUniversityName;
    String city;
    String address;
    List<Faculty> faculties = new ArrayList<>();

    University(String fullUniversityName, String shortUniversityName, String city, String address) {
        this.fullUniversityName = fullUniversityName;
        this.shortUniversityName = shortUniversityName;
        this.city = city;
        this.address = address;
    }

    University(){

    }

    @Override
    public String toString() {
        return "Повна назва університету: " +  fullUniversityName  +"\nСкорочена назва університету: " + shortUniversityName + "\nМісто перебування: " + city + "\nАдреса: " + address;
    }
}
