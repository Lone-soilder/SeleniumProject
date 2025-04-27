import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws IOException {
        File file = createTheFile();
        writeTheFile("my name is Biswajit sahoo , I am the writter of the file.");
        getFileInformation(file);
        String content = readTheFile(file);
        if (!content.isEmpty()){
            System.out.println(content);
        }
    }

    private static void getFileInformation(File file) {
        if (file.exists()) {
            System.out.println("file name is " + file.getName());
            System.out.println("file path of the file is " + file.getPath());
            System.out.println("file is writable or not " + file.canWrite());
            System.out.println("file is readable or not " + file.canRead());
            System.out.println("file size is in byte is " + file.length());
        }else {
            System.out.println("file doesn't exist");
        }
    }

    private static void writeTheFile(String content) throws IOException {

        try {
            FileWriter writer = new FileWriter("myFile.txt");
            writer.write(content);
            writer.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private static String readTheFile(File file) {
        try {
            Scanner dataReader = new Scanner(file);

            while (dataReader.hasNextLine()){
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
                return fileData;
            }
            dataReader.close();
        }catch (FileNotFoundException exception){
            System.out.println(exception);
        }
        return null;
    }

    private static File createTheFile() {
        try {
            File file = new File("myfile.txt");
            if (file.createNewFile()){
                System.out.println("file is created");
                return file;
            }
            else {
                System.out.println("file is not created");
                return null;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
