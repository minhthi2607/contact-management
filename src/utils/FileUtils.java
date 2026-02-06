package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<String> readFile(String path){
        List<String> list = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null){
                list.add(line);
            }
            return list;
        } catch (Exception e) {
            System.out.println("Lỗi đọc file!");
        }
        return list;
    }

    public static void writeFile(String path, List<String> list){

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(path));
            for(String line : list){
                pw.println(line);
            }
            pw.close();
            System.out.println("Ghi file thành công");

        } catch (Exception e) {
            System.out.println("Lỗi ghi file!");
        }
    }
}
