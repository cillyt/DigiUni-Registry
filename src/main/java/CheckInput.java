import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckInput {
    int check;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public String checkString(String s, String s1) throws IOException {
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

        return parameter;

    }

    public int  checkInt(String s, String s1) throws IOException {
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

    public long checkLong(String s, String s1) throws IOException {
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


}
