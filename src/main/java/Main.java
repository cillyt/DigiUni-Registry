import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<University> universities = new ArrayList<>();
    static AllObjects allObjects = new AllObjects();
    static CheckInput checkInput = new CheckInput();

    static Menu menu = new Menu();
    static Authorization auth = new Authorization();


    public static void main(String[] args) throws IOException {
        startedPack();
        while(true){  //якщо користувач захоче вернутись в режим авторизації, додати тут брейк коли буде виходити з програми
            auth.authorization();
            menu.mainMenu();
        }
    }

    private static void startedPack(){
        universities.add(new University("Києвомогилянська академія", "КМА", "Київ", "Контрактова площа"));
        universities.add(new University("Шевченка", "КНУ", "Київ", "ПУГ"));
        universities.add(new University("Український католицький університет", "УКУ", "Львів", "десь у львові"));

        universities.get(0).faculties.add(new Faculty("123", "Факультет інформатики", "ФІ", 999999999, "fi@kvjervb.com"));
        universities.get(1).faculties.add(new Faculty("1234", "Факультет інформатики-кну", "ФІкну", 888888888, "fi@oerhoeh.com"));
        universities.get(2).faculties.add(new Faculty("12345", "Факультет інформатики-уку", "ФІуку", 777777777, "fi@wurgheu.com"));

        universities.get(0).faculties.get(0).departments.add(new Department("ghhg", "іпз самі круті", 666));
        universities.get(0).faculties.get(0).departments.add(new Department("blabla", "кафедра Макарця", 600));
        universities.get(1).faculties.get(0).departments.add(new Department("roer", "папапау", 67));
        universities.get(1).faculties.get(0).departments.add(new Department("zvsv", "blablabla", 69));
        universities.get(2).faculties.get(0).departments.add(new Department("oyuk", "blebleble", 13));

        universities.get(0).faculties.get(0).departments.get(0).teachers.add(new Teacher(111, "AAA", "aAaAa", "aaaa", 2001, 3, 12 ,"aaa@gmail.com",111111,"A@A@A","@@","@@",1999, 10, 21, "110000", false, false));
        universities.get(0).faculties.get(0).departments.get(0).teachers.add(new Teacher(222, "BBB", "bBbBb", "bbbb", 1930, 12, 2 ,"bbb@gmail.com",222222,"B3B3B","##","##",1989, 1, 29, "220000", true, true));
        universities.get(0).faculties.get(0).departments.get(0).teachers.add(new Teacher(333, "CCC", "cCcCc", "cccc", 1990, 10, 31 ,"ccc@gmail.com",333333,"C$C$C","$$","$$",1980, 3, 26, "330000", true, false));

        universities.get(0).faculties.get(0).departments.get(0).students.add(new Student(1111, "AAAaa", "aAaAaaa", "aaaaaa", 2003, 6, 1 ,"Aaaa@gmail.com",9111111,1,6,2021,"Бюджет", "Відрахований"));
        universities.get(0).faculties.get(0).departments.get(0).students.add(new Student(2222, "BBBbb", "bBbBbbb", "bbbbbb", 2000, 11, 3 ,"Bbbb@gmail.com",8222222,2,2,2022,"Контракт", "Академвідпустка"));
        universities.get(0).faculties.get(0).departments.get(0).students.add(new Student(3333, "CCCcc", "cCcCccc", "cccccc", 1230, 4, 4 ,"Cccc@gmail.com",7333333,3,1,2023,"Бюджет", "Навчається"));

    }

}