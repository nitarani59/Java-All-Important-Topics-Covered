package serializationHandsOn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializationUsingGson {
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

    public static void main(String[] args) throws IOException {
        SerializationUsingGson  gson = new SerializationUsingGson();
        gson.setId(1);
        gson.setName("abc");
        String filePath = "gson_user.json";
        Writer writer = new FileWriter(filePath);
        Gson serialize = new GsonBuilder().setPrettyPrinting().create();
        serialize.toJson(gson, writer);
        writer.close();

        Gson deserialize = new GsonBuilder().setPrettyPrinting().create();
        SerializationUsingGson deserializedUser = deserialize.fromJson(new FileReader(filePath), SerializationUsingGson.class);
        assertEquals(1, deserializedUser.getId());
        assertEquals("abc", deserializedUser.getName());

    }
}
