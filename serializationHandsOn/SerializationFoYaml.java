package serializationHandsOn;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class SerializationFoYaml {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private static Map<String, SerializationFoYaml> populateUserMap() {
        SerializationFoYaml user1 = new SerializationFoYaml();
        user1.setId(1);
        user1.setName("Mark Jonson");
        //.. more user objects

        Map<String, SerializationFoYaml> users = new LinkedHashMap<>();
        users.put("User1", user1);
        // add more user objects to map

        return users;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "yamlbeans_users.yaml";
        YamlWriter writer = new YamlWriter(new FileWriter(filePath));
        writer.write(populateUserMap());
        writer.close();

    }
}
