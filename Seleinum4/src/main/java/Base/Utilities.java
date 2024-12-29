package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Properties;

public class Utilities {
    public String readProperty(String name) {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(name);
    }

    public void cleanDirecotry() {
        File folder = new File("reports");

        if (folder.exists() && folder.isDirectory()) {
            // Get all files and subdirectories inside the folder
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // If it's a directory, call the method recursively
                        deleteFolder(file);
                    } else {
                        // If it's a file, delete it
                        file.delete();
                    }
                }
            }
            System.out.println("Folder cleaned successfully.");
        }
    }

    private static void deleteFolder(File folder) {
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If it's a directory, call the method recursively
                    deleteFolder(file);
                } else {
                    // If it's a file, delete it
                    file.delete();
                }
            }
        }
        // Delete the empty directory
        folder.delete();
    }
}
