import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static final String REMOTE_SERVICE_URI = "https://api.nasa.gov/planetary/apod?api_key=qmBMLUFjyenlECvu3lNnNa4fPivJt98k3epD6nIT";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient HTTPClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(3000)
                        .setRedirectsEnabled(false)
                        .setSocketTimeout(30000)
                        .build())
                .build();
        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);
        CloseableHttpResponse response = HTTPClient.execute(request);
//        System.out.println(response);
//        Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
        String body = EntityUtils.toString(response.getEntity());
//        System.out.println(body);
        Image image = mapper.readValue(body, new TypeReference<Image>() {
        });
//        System.out.println(image);
        HttpGet request2 = new HttpGet(image.getUrl());
        response = HTTPClient.execute(request2);
//        System.out.println(response);
//        Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
        String body2 = EntityUtils.toString(response.getEntity());
//        System.out.println(body2);

        if (!Files.exists(Paths.get("SaharaAndromeda_Coy_1080.jpg"))) {
            Files.createFile(Paths.get("SaharaAndromeda_Coy_1080.jpg"));
        }
        try (OutputStream fos = new FileOutputStream("SaharaAndromeda_Coy_1080.jpg")) {
            byte[] bytes = body2.getBytes(StandardCharsets.UTF_8);
            fos.write(bytes, 0, bytes.length);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
