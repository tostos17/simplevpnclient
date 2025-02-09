package com.fowobi.networking;

import com.fowobi.networking.client.VPNClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

//@PropertySource("C:/Users/Admin/Documents/code/properties/vpnClient.properties")
@SpringBootApplication
public class SimpleVpnClientApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SimpleVpnClientApplication.class, args);
		VPNClient vpnClient = new VPNClient();
		vpnClient.connect();
	}

}
