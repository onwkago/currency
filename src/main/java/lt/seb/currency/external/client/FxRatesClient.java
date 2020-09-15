package lt.seb.currency.external.client;

import lombok.extern.slf4j.Slf4j;

import lt.seb.currency.external.lt.lb.webservices.fxrates.GetCurrencyList;
import lt.seb.currency.external.lt.lb.webservices.fxrates.GetCurrencyListResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class FxRatesClient extends WebServiceGatewaySupport {

  public GetCurrencyListResponse getCurrencyList() {

    GetCurrencyList currencyListRequest = new GetCurrencyList();
log.debug("here" + currencyListRequest.toString());
    GetCurrencyListResponse response = (GetCurrencyListResponse) getWebServiceTemplate()
            .marshalSendAndReceive(currencyListRequest);

    return response;

  }
}
