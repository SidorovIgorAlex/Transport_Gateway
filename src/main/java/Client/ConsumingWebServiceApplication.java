//package Client;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import ru.mfms.mfmsgate.pushdev.GetDevicesResponse;
//
//@SpringBootApplication
//public class ConsumingWebServiceApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(ConsumingWebServiceApplication.class, args);
//    }
//
//    @Bean
//    CommandLineRunner lookup(PushDeviceServiceClient quoteClient){
//
//        return args -> {
//            String clientId = "?";
//
//            if (args.length > 0){
//                clientId = args[0];
//            }
//            GetDevicesResponse response = quoteClient.getDevices(clientId);
//        };
//
//
//    }
//
//}
