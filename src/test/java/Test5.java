import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import objects.bankGov.Exchange;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.ApiRequest;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)

public class Test5 {

    static final String URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json";
    static Exchange[] exchange;
    static ObjectMapper om;
    private String currencyCode;

    public Test5(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @BeforeClass
    public static void bb() throws JsonProcessingException {
        om = new ObjectMapper();
        exchange = om.readValue(ApiRequest.getRest(URL), Exchange[].class);
    }

    @Parameterized.Parameters
    public static Collection<String> options() {
        return Arrays.asList("USD", "AUD", "CAD", "HUF");

    }
    @Test
    public void tets2() {
        for (Exchange l : exchange) {
            if (l.cc.equals(currencyCode)) {
                System.out.println(l.r030 + " = " + l.txt + "; " + l.rate + "; " + l.cc + "; " + l.exchangedate);
            }
        }
    }
}
