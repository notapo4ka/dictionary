import java.util.Objects;

public class FileData {

    private String nameOfFile;
    private long size;
    private String pathToFile;

    public FileData(String nameOfFile, long size, String pathToFile) {
        this.nameOfFile = nameOfFile;
        this.size = size;
        this.pathToFile = pathToFile;
    }

    public long getSize() {
        return size;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileData fileData = (FileData) o;

        if (size != fileData.size) return false;
        if (!Objects.equals(nameOfFile, fileData.nameOfFile)) return false;
        return Objects.equals(pathToFile, fileData.pathToFile);
    }

    @Override
    public int hashCode() {
        int result = nameOfFile != null ? nameOfFile.hashCode() : 0;
        result = 31 * result + (int) (size ^ (size >>> 32));
        result = 31 * result + (pathToFile != null ? pathToFile.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "nameOfFile='" + nameOfFile + '\'' +
                ", size=" + size +
                ", pathToFile='" + pathToFile + '\'' +
                '}';
    }
}