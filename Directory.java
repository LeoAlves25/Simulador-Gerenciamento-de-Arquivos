public class Directory extends FileEntry {

    public Directory(String path) {
        super(path);
    }

    @Override
    public String toString() {
        return "Directory: " + path;
    }
}
