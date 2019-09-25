package fileWork;

import entities.group.Group;

import java.io.File;
import java.io.IOException;

public interface IFileIO {
    void toFile(Group group, String pathName) throws IOException;
    Object fromFile(File file ) throws IOException;
}
