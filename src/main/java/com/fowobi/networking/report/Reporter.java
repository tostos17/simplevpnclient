package com.fowobi.networking.report;

//import com.fowobi.networking.client.VPNClient;
import com.fowobi.networking.client.VPNClientModified;
import org.springframework.beans.factory.annotation.Autowired;

public class Reporter {


    public String sendReport(String message) throws Exception {
        VPNClientModified vpnClientModified = new VPNClientModified();
        return vpnClientModified.connect(message);
    }
}
