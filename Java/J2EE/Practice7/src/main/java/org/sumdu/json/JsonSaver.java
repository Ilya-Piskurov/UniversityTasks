package org.sumdu.json;

import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JsonSaver {
    public void write(String path, HashMap<String, String>... objects) {
        try (FileWriter os = new FileWriter(path)) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(List.of(objects));
            os.write(jsonArray.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
