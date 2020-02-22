package Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.mfms.mfmsgate.pushdev.GetDevicesRequest;
import ru.mfms.mfmsgate.pushdev.GetDevicesResponse;

public class PushDeviceServiceClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(PushDeviceServiceClient.class);

    public GetDevicesResponse getDevices(String clientId){

        GetDevicesRequest request = new GetDevicesRequest();
        request.setCorrelationId("?");
        request.setSystemId("?");
        request.setClientId(clientId);

        log.info(clientId);

        GetDevicesResponse response = (GetDevicesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/services/PushDeviceService", request
                , new SoapActionCallback("http://mfms.ru/mfmsgate/pushdev/GetDevicesRequest"));

        return response;
    }

}
