import java.util.*;

public class FileSystemSimulator {
    private Map<String, FileEntry> fileSystem;
    private Journal journal;

    public FileSystemSimulator() {
        this.fileSystem = new HashMap<>();
        this.journal = new Journal();
        fileSystem.put("/", new Directory("/"));
    }

    public void createFile(String path) {
        if (fileSystem.containsKey(path)) {
            System.out.println("File already exists!");
            return;
        }
        journal.logOperation("CREATE FILE", path);
        fileSystem.put(path, new File(path));
    }

    public void createDirectory(String path) {
        if (fileSystem.containsKey(path)) {
            System.out.println("Directory already exists!");
            return;
        }
        journal.logOperation("CREATE DIRECTORY", path);
        fileSystem.put(path, new Directory(path));
    }

    public void deleteFile(String path) {
        if (!fileSystem.containsKey(path) || fileSystem.get(path) instanceof Directory) {
            System.out.println("File does not exist or is a directory!");
            return;
        }
        journal.logOperation("DELETE FILE", path);
        fileSystem.remove(path);
    }

    public void deleteDirectory(String path) {
        if (!fileSystem.containsKey(path) || !(fileSystem.get(path) instanceof Directory)) {
            System.out.println("Directory does not exist or is a file!");
            return;
        }
        journal.logOperation("DELETE DIRECTORY", path);
        fileSystem.remove(path);
    }

    public void renameFileOrDirectory(String oldPath, String newPath) {
        if (!fileSystem.containsKey(oldPath)) {
            System.out.println("File or directory does not exist!");
            return;
        }
        journal.logOperation("RENAME", oldPath + " to " + newPath);
        FileEntry entry = fileSystem.remove(oldPath);
        entry.setPath(newPath);
        fileSystem.put(newPath, entry);
    }

    public void copyFile(String sourcePath, String destPath) {
        if (!fileSystem.containsKey(sourcePath) || fileSystem.get(sourcePath) instanceof Directory) {
            System.out.println("Source file does not exist or is a directory!");
            return;
        }
        if (fileSystem.containsKey(destPath)) {
            System.out.println("Destination file already exists!");
            return;
        }
        journal.logOperation("COPY FILE", sourcePath + " to " + destPath);
        fileSystem.put(destPath, new File(destPath));
    }

    public void listDirectory(String path) {
        if (!fileSystem.containsKey(path) || !(fileSystem.get(path) instanceof Directory)) {
            System.out.println("Directory does not exist or is a file!");
            return;
        }
        System.out.println("Listing directory: " + path);
        for (String key : fileSystem.keySet()) {
            if (key.startsWith(path) && !key.equals(path)) {
                System.out.println(key);
            }
        }
    }

    public void showJournal() {
        journal.printJournal();
    }
}
