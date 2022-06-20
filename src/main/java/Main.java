import java.util.List;

public class Main {
    public static final String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.get();
        String json = httpClient.getContentFromURL(URL);
        JsonToObjectParser jsonToObjectParser = JsonToObjectParser.get();
        List<Fact> facts = jsonToObjectParser.convert(json);
        facts.stream().
                filter(x -> x.getUpvotes() != null && !x.getUpvotes().equals("0"))
                .forEach(System.out::println);


    }
}
