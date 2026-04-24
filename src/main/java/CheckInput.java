import exсeptions.OptionNumberException;
import exсeptions.ValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckInput {
    int check;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public String checkString(String s, String s1) throws Exception {
        check = 0;
        String parameter = "";
        while(check == 0) {
            try {
                System.out.println(s);
                parameter = reader.readLine();
                if (parameter.equals(""))
                    throw new ValidationException(s1);
                else {
                    for (int i = 0; i < parameter.length(); i++) {
                        if (parameter.charAt(i) != ' ') {
                            check = 1;
                        }
                    }
                    if (check != 1) {
                        throw new ValidationException(s1);
                    }
                }
            }
            catch (ValidationException ve){
                System.out.println(s1);
            }
        }

        return parameter;

    }



    public Authorization.Email checkEmail(String s, String s1) throws Exception {

        while(true){
            check = 0;
            String parameter = "";
            while(check == 0) {
                System.out.println(s);
                parameter = reader.readLine();
                if (parameter.equals(""))
                    System.out.println(s1);
                else{
                    for (int i = 0; i < parameter.length(); i++) {
                        if (parameter.charAt(i) != ' ') {
                            check = 1;
                        }
                    }
                    if (check!=1) {
                        System.out.println(s1);
                    }
                }
            }

            try{
                Authorization.Email email = new Authorization.Email(parameter);
                return email;
            }
            catch (IllegalArgumentException ex){
                System.out.println("Пошта вказана не правильно (відсутність @): " + parameter);
            }
        }
    }


    public int  checkInt(String s, String s1) throws Exception {
        check = 0;
        int parameter = 0;
        while(check == 0) {
            try{
                System.out.println(s);
                parameter = Integer.parseInt(reader.readLine());
                check = 1;
            }
            catch(NumberFormatException e){
                System.out.println(s1);
                check = 0;
            }
        }
        return parameter;
    }

    public long checkLong(String s, String s1) throws Exception {
        check = 0;
        long parameter = 0;
        while(check == 0) {
            try{
                System.out.println(s);
                parameter = Long.parseLong(reader.readLine());
                check = 1;
            }
            catch(NumberFormatException e){
                System.out.println(s1);
                check = 0;
            }
        }
        return parameter;
    }

    public int checkOperations(int a, int b, String s, String s1, String s2) throws Exception {
        check = 0;
        int operation = -1;
        while (check == 0) {
            try {
                operation = checkInt(s, s1);
                check = 0;

                if (operation <= b && operation >= a)
                    check = 1;
                else
                    throw new OptionNumberException(s2);
            }
            catch (OptionNumberException e) {
                System.out.println(s2);
            }
        }

        return operation;
    }


}
