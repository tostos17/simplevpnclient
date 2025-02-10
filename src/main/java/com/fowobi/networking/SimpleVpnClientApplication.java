package com.fowobi.networking;

//import com.fowobi.networking.client.VPNClient;
import com.fowobi.networking.client.VPNClientModified;
import com.fowobi.networking.report.Reporter;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class SimpleVpnClientApplication {

    public static void main(String[] args) throws Exception {
		SpringApplication.run(SimpleVpnClientApplication.class, args);
//		VPNClient vpnClient = new VPNClient();
//		vpnClient.connect();

		Reporter reporter = new Reporter();
		System.out.println(reporter.sendReport("active"));
	}

}
