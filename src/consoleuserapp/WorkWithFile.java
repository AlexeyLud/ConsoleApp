package consoleuserapp;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WorkWithFile {
    
    public static void saveToFile(File file, String text_for_file) throws IOException{      
        String text = text_for_file;        
        // write
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(text + '\n');
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing");
        }
    }
    
    public static void updateToFile(File file, String text_for_file) throws IOException{
        String newText = text_for_file;
        // update
        StringBuilder sb = new StringBuilder();
        Path path = file.toPath();
        Files.newBufferedWriter(path , StandardOpenOption.TRUNCATE_EXISTING);
        sb.append(newText);
        saveToFile(file, newText);
    }
    
}
