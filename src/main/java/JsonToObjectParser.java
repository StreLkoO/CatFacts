import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonToObjectParser {
    private static JsonToObjectParser instance;
    private final ObjectMapper mapper;

    private JsonToObjectParser() {
        mapper = new ObjectMapper();
    }

    public static JsonToObjectParser get() {
        if (instance == null) {
            instance = new JsonToObjectParser();
        }
        return instance;
    }

    public List<Fact> convert(String json) {
        List<Fact> facts = null;
        try {
            facts = mapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return facts;
    }

}
