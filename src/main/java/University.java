public class University {
    String fullUniversityName;
    String shortUniversityName;
    String city;
    String address;

    University(String fullUniversityName, String shortUniversityName, String city, String address) {
        this.fullUniversityName = fullUniversityName;
        this.shortUniversityName = shortUniversityName;
        this.city = city;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Повна назва університету: " +  fullUniversityName + ", Скорочена назва університету: " + shortUniversityName + ", місто перебування: " + city + ", адреса: " + address;
    }
}
