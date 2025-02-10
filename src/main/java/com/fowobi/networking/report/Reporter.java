package com.fowobi.networking.report;

//import com.fowobi.networking.client.VPNClient;
import com.fowobi.networking.client.VPNConnector;
import com.fowobi.networking.dto.KeepAlive;
import com.fowobi.networking.util.PropertyReader;
import com.google.gson.Gson;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class Reporter {

    @Scheduled(cron = "10 * * * * *")
    public String sendReport() throws Exception {
        InetAddress inet4Address = InetAddress.getLocalHost();
        String hostName = inet4Address.getHostName();
        KeepAlive message = new KeepAlive();
        message.setHost(hostName);
        message.setDepartment(PropertyReader.getPropertyValue("host.dept"));

        Gson gson = new Gson();

        VPNConnector vpnClientModified = new VPNConnector();
        return vpnClientModified.connect(gson.toJson(message));
    }

}
