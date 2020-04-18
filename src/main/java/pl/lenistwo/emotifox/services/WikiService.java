package pl.lenistwo.emotifox.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.lenistwo.emotifox.wiki.Article;

import java.util.stream.Collectors;

@Service
public class WikiService {

    private final RestTemplate template = new RestTemplate();

    public Article get(String query) {
        Article article = template.getForObject(preparePath(query), Article.class);
        return null;
    }

    private String preparePath(String query) {
        String BASE_PATH = "https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch={}";
        return BASE_PATH.replace("{}", query.replace(" ", "%20"));
    }
}
