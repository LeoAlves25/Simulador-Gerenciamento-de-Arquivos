public class File extends FileEntry {

    public File(String path) {
        super(path);
    }

    @Override
    public String toString() {
        return "File: " + path;
    }
}
