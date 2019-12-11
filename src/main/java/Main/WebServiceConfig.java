package Main;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();

        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/*");
    }

    @Bean(name="PushDeviceService")
    public Wsdl11Definition wsdl11Definition(XsdSchema PushDeviceServiceSchema)
    {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PushDeviceServicePort");
        wsdl11Definition.setLocationUri("/services/PushDeviceService");
        wsdl11Definition.setTargetNamespace("http://mfms.ru/mfmsgate/pushdev");
        wsdl11Definition.setSchema(PushDeviceServiceSchema);

        return wsdl11Definition;
    }

    @Bean
    public XsdSchema PushDeviceServiceSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("PushDeviceService.xsd"));
    }

}
