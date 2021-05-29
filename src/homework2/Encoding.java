package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Encoding {

    /**
     *  Создать программу, котора¤ принимает на вход строку в кодировке отличной от UTF8 и
     *  преобразует ее в UTF8
     */
    public static void main(String[] args) throws IOException {
        Charset cp1251 = Charset.forName("cp1251");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, cp1251));
        String strIn = br.readLine();
        byte [] strBytes = strIn.getBytes("cp1251");
        System.out.println(Arrays.toString(strBytes));
        String strOut = new String(strBytes);
        System.out.println(strOut);
        br.close();
    }

}

/**
 *         Charset cp1251 = Charset.forName("cp1251");
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in, cp1251));
 *         String strIn = br.readLine();
 *         System.out.println(Arrays.toString(strIn.getBytes("UTF-8")));
 * //        String strOut = new String(strIn.getBytes());
 * //        System.out.println(strOut);
 *         br.close();
 */

