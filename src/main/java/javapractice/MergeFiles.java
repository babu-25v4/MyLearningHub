package javapractice;

import java.io.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class MergeFiles {

public static void main(String[] args) throws IOException {

    try {
        String outFileName = System.getProperty("user.home") + "\\Desktop\\HTMLfiles\\name.html>";
        File outputFile = new File(outFileName);
        String desktopDir = System.getProperty("user.home") + "\\Desktop\\HTMLfiles";
        File dir = new File(desktopDir);
        File[] paths;
        //create a file filter that will only worry about .html files if your folder contains other extensions
        FilenameFilter fileNameFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if (name.lastIndexOf('.') > 0) {
                    int lastIndex = name.lastIndexOf('.');
                    String extension = name.substring(lastIndex);
                    if (extension.equals(".html")) {
                        return true;
                    }
                }
                return false;
            }
        };
        paths = dir.listFiles(fileNameFilter);
        //use BufferedWriterd to create the initial .html file with a header
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));
        bw.write("<h1>REPORT DATA</h1>");
        bw.close();
        /*Use file writer to append the .html file with additional .html files
        In this case, the .html files all contain One 'table', so this
        will append the tables to 'outputFile'.*/
        try {
            String file = outputFile.getAbsolutePath();
            FileWriter fw = new FileWriter(file, true);
            for (File x : paths) {
                Document doc = Jsoup.parse(x, "UTF-8");
                Elements links = doc.select("table");
                //adds the filename of the .html as a Level 2 heading
                fw.write("<h2>" + x.toString() + "</h2>");
                fw.write(links.toString());
            }
            fw.close();
        }catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } finally {
            bw.close();
        }
    } catch (IOException ioe) {
        System.out.println(ioe.getMessage());
    }
    System.out.println("\nMerge Completed Successfully");
  }
}
