package Main;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.mfms.mfmsgate.pushdev.*;

@Endpoint
public class PushServiceEndpoint {

    MeterRegistry registry = new SimpleMeterRegistry();
    Counter counter = registry.counter("requestCount");

    private static final String NAMESPACE_URI = "http://mfms.ru/mfmsgate/pushdev";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDeviceSubscriptionsRequest")
    @ResponsePayload
    public GetDeviceSubscriptionsResponse getDeviceSubscriptionsResponse(@RequestPayload GetDeviceSubscriptionsRequest getDeviceSubscriptionsRequest) {
        GetDeviceSubscriptionsResponse getDeviceSubscriptionsResponse = new GetDeviceSubscriptionsResponse();
        Metrics.timer("response.timer.GetDeviceSubscriptionsRequest").record(()-> {
            getDeviceSubscriptionsResponse.getMessageTypeCodes().add("otp-code");
            getDeviceSubscriptionsResponse.getMessageTypeCodes().add("otp-code-united");
            getDeviceSubscriptionsResponse.getMessageTypeCodes().add("transaction");
            Metrics.counter("GetDeviceSubscriptionsRequest").increment(1.0);
        });

        return getDeviceSubscriptionsResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDevicesRequest")
    @ResponsePayload
    public GetDevicesResponse getDevicesRequest(@RequestPayload GetDevicesRequest getDevicesRequest) {
        GetDevicesResponse getDevicesResponse = new GetDevicesResponse();

        Metrics.timer("response.timer.GetDevicesRequest").record(() -> {
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.setDeviceName("iPhone");
            deviceInfo.setDeviceUID("6C561B37-DF91-42E6-8DE4-969B602CD960");
            deviceInfo.setDeviceToken("ewogICJkZXZpY2VVaWQiIDogIjZDNTYxQjM3LURGOTEtNDJFNi04REU0LTk2OUI2MDJDRDk2MCIsCiAgIm9zTmFtZSIgOiAiaU9TIiwKICAidmVyc2lvbiIgOiAiMTItMDQtMjAxNiIsCiAgIm9zVmVyc2lvbiIgOiAiMTEuMC4zIiwKICAibG9jYWxlIiA6ICJydV9SVSIsCiAgInByb3ZpZGVyVWlkIiA6ICJQSDVGWTJvaFdFWkRTU0ZlTDI4K1RqbENiQ1VcL2FVQTdYV3B3UkVvb1V6bEZLMm93TFVGSk9INCtDZyIsCiAgImRldmljZU1vZGVsIiA6ICJpUGhvbmUiLAogICJkZXZpY2VOYW1lIiA6ICJhVkJvYjI1jEwODAwMDAwbXMiLAogICJhcHBWZXJzaW9uIiA6ICI4LjMzLjEyIiwKICAidXNlclNlY3VyaXR5SGFzaCIgOiAiNkM1NjFCMzctREY5MS00MkU2LThERTQtOTY5QjYwMkNEOTYwIgp9");
            deviceInfo.setIsPushActive(false);

            getDevicesResponse.getDevices().add(deviceInfo);

            Metrics.counter("GetDevicesRequest").increment(1.0);
        });


        return getDevicesResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateSecurityTokenRequest")
    @ResponsePayload
    public UpdateSecurityTokenResponse getUpdateSecurityTokenResponse (@RequestPayload UpdateSecurityTokenRequest updateSecurityTokenRequest)
    {

        UpdateSecurityTokenResponse updateSecurityTokenResponse = new UpdateSecurityTokenResponse();

        Metrics.timer("response.timer.UpdateSecurityTokenRequest").record(() -> {
            Metrics.counter("UpdateSecurityTokenRequest").increment(1.0);
                });

        return updateSecurityTokenResponse;
    }
}