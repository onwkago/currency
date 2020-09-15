package lt.seb.currency;

import lt.seb.currency.external.client.FxRatesClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class FxRatesConfiguration  {
  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("lt.seb.currency.external.lt.lb.webservices.fxrates");
    return marshaller;
  }


  @Bean
  public FxRatesClient fxRatesClient(Jaxb2Marshaller marshaller) {
    FxRatesClient client = new FxRatesClient();
    client.setDefaultUri("https://www.lb.lt/webservices/FxRates/FxRates.asmx");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }


}
