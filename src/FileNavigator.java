import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileNavigator {

    private Map<String, List<FileData>> listOfFiles;

    public FileNavigator() {
        listOfFiles = new HashMap<>();
    }

    public void add(FileData file) {
        String pathToFile = file.getPathToFile();
        List<FileData> files = listOfFiles.get(pathToFile);
        if (files == null) {
            files = new ArrayList<>();
            listOfFiles.put(file.getPathToFile(), files);
        } else {
            for (FileData fd : files) {
                if (!fd.getPathToFile().equals(pathToFile)) {
                    System.out.println("Path in file and path key do not match");
                }
            }
        }
        files.add(file);
    }

    public List<FileData> getFiles(FileData file) {
        return listOfFiles.get(file.getPathToFile());
    }

    public List<FileData> find(String path) {
        if (listOfFiles.containsKey(path)) {
            return listOfFiles.get(path);
        } else {
            return new ArrayList<FileData>();
        }
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> filteredFiles = new ArrayList<>();
        for (List<FileData> files : listOfFiles.values()) {
            for (FileData file : files) {
                if (file.getSize() <= maxSize) {
                    filteredFiles.add(file);
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String path) {
        listOfFiles.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> sortedFiles = new ArrayList<>();
        for (List<FileData> files : listOfFiles.values()) {
            sortedFiles.addAll(files);
        }
        sortedFiles.sort(Comparator.comparingLong(FileData::getSize));
        return sortedFiles;
    }

    @Override
    public String toString() {
        return "FileNavigator{" + "listOfFiles=" + listOfFiles + '}';
    }
}