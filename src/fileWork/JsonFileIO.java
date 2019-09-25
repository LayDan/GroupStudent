package fileWork;

import com.google.gson.Gson;
import entities.group.Group;

import java.io.*;

public class JsonFileIO implements IFileIO {
    Gson gson = new Gson();

    @Override
    public void toFile(Group group, String pathName) throws IOException {
        File file = new File(pathName);
        FileWriter writer = new FileWriter(file);
        BufferedWriter writer1 = new BufferedWriter(writer);
        writer1.write(gson.toJson(group));
        writer1.flush();
        writer1.close();
    }

    @Override
    public Group fromFile(File file) throws IOException {
        if (file.getName().endsWith(".json")) {
            FileReader fr = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fr);
            String json = "";
            while (bufferedReader.ready()) {
                json = json.concat(bufferedReader.readLine());
            }
            bufferedReader.close();
            return gson.fromJson(json, Group.class);
        }
        return null;
    }
}
