package fileWork;

import entities.group.Group;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFileIO {
    void toFile(Group group) throws IOException;
    Object fromFile() throws IOException;
}
