package com.fowobi.networking;

//import com.fowobi.networking.client.VPNClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SimpleVpnClientApplication {

    public static void main(String[] args) throws Exception {
		SpringApplication.run(SimpleVpnClientApplication.class, args);
//		VPNClient vpnClient = new VPNClient();
//		vpnClient.connect();

//		Reporter reporter = new Reporter();
//		System.out.println(reporter.sendReport("active"));
	}

}
