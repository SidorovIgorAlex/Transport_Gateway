//package Client;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//
//@Configuration
//public class PushDeviceServiceConfiguration {
//
//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        // this package must match the package in the <generatePackage> specified in
//        // pom.xml
//        marshaller.setContextPath("/Users/aplana/Documents/1. idea-workspace/spring_soap_stub/PushServiceStub/build/classes/jaxb/ru/mfms/mfmsgate/pushdev");
//        return marshaller;
//    }
//
//    @Bean
//    public PushDeviceServiceClient countryClient(Jaxb2Marshaller marshaller) {
//        PushDeviceServiceClient client = new PushDeviceServiceClient();
//        client.setDefaultUri("http://localhost:8080/services/PushDeviceService");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//        return client;
//    }
//
//}
