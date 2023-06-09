import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        //чтение в буфер введенного значения
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        //регулярка на проверку, число или нет
        String reg = "^[0-9]+$";
//        String regArray = "^[-+]?[0-9]*[.]?[0-9]+$";

        String size;
        do {
            System.out.print("Введите количество желаемых строк (не меньше 2): ");
            size = buffer.readLine();
        } while (!(size.matches(reg)) || size.equals("0") || size.equals("1"));
        int mySize = Integer.parseInt(size);

        String[] myArray = new String[mySize];
        Integer[] myArrayIndex = new Integer[mySize];

        String element;
        for(int i = 0; i < mySize; i++){

            System.out.printf("Введите %s строку: ", i+1);

            element = buffer.readLine();
            myArray[i] = element;

            String element2="";

            for(int j = 0; j < element.length(); j++){
                if(!(element2.contains(element.substring(j,j+1)))){
                    element2 = element2 + element.charAt(j);
                }
            }
            myArrayIndex[i] = element2.length();
        }

        int max = myArrayIndex[0];
        for(int i : myArrayIndex){
            max = Math.max(max, i);
        }

        int index = Arrays.binarySearch(myArrayIndex, max);

//        System.out.println(Arrays.toString(myArray));
//        System.out.println(Arrays.toString(myArrayIndex));
        System.out.println("Ответ: " + myArray[index]);

    }
}