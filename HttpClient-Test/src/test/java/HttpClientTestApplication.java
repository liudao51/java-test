import org.apache.http.client.HttpClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 69522 on 2020/12/10.
 */
public class HttpClientTestApplication {

    @Test
    public void testSlf4j() {
        Logger logger = LoggerFactory.getLogger(Object.class);
        logger.error("123");
    }

    @Test
    public void testHttpClient(){
        this.doGet();
    }


    public void doGet(){
        System.out.println("----doGet-----");

    }

}
