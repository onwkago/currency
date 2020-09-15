package lt.seb.currency.webapp.controller;

import lt.seb.currency.external.client.FxRatesClient;
import lt.seb.currency.external.lt.lb.webservices.fxrates.GetCurrencyListResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping(produces = "application/json")
public class testController {

  @Autowired
  public FxRatesClient client;


  @GetMapping(path = "/getCurrency")
  public String getCurrency(){

   // GetCurrencyListResponse abc = client.getCurrencyList();
    try(CloseableHttpClient client = HttpClientBuilder.create().build()) {
      HttpGet request = new HttpGet("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrencyList?");
      HttpResponse response = client.execute(request);

      BufferedReader bufReader = new BufferedReader(new InputStreamReader(
              response.getEntity().getContent()));

      StringBuilder builder = new StringBuilder();

      String line;

      while ((line = bufReader.readLine()) != null) {

        builder.append(line);
        builder.append(System.lineSeparator());
      }

      return builder.toString();

    } catch (Exception e ) {
      return e.getMessage();
    }

  }

  @GetMapping(path="/hello")
  public String hello() {
    return "HelloWorld";
  }


}
