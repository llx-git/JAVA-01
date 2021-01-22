
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-01-19
 */
public class HttpClientTest {

    public static void main(String[] args) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:8801").build();
        Response response = httpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }
    }
}
