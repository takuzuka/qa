package requesters;

import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?q=";
    private final String POSTFIX = "&appid=439d4b804bc8187953eb36d2a8c26a02";

    public void requestWeather(String city, String country) {
        RestTemplate restTemplate = new RestTemplate();
        String url = PREFIX + city + "," + country.toLowerCase() + PREFIX;
        restTemplate.getForEntity(url, String.class).getBody();
    }
}
