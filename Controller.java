package kursovaya;
import java.io.*;
import java.util.*;

public class Controller {
    public static Sport[] makeSportsArray(ArrayList<File> files) {
        ArrayList<Sport> sports = new ArrayList();
        for(File temp : files) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(temp));
                String tempStr = "";
                while((tempStr = br.readLine())!= null) {
                    sports.add(Sport.makeSport(tempStr));
                }
                br.close();
            }catch(FileNotFoundException fe) {
                System.out.println("File not found!");
            }catch(IOException ioe) {
            }
        }
        Sport[] studs = new Sport[sports.size()];
        sports.toArray(studs);
        return studs;
    }

    static void writeInFile(File f, Sport[] arr) {
        try {
            PrintWriter pw = new PrintWriter(f);
            for (Sport temp : arr) {
                pw.println(temp);
            }
            pw.flush();    // закрыть мосток
            pw.close();    //
        } catch (IOException ioe) {
        }
    }
}
