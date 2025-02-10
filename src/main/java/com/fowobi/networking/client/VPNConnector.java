package com.fowobi.networking.client;

import com.fowobi.networking.util.EncryptionUtil;
import com.fowobi.networking.util.PropertyReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class VPNConnector {

    private static final Logger log = LoggerFactory.getLogger(VPNConnector.class);

    public String connect(String status) throws Exception {

        String encodedKey = PropertyReader.getPropertyValue("secret.key");
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

        String listeningPort = PropertyReader.getPropertyValue("server.listening.port");
        Socket socket = new Socket(PropertyReader.getPropertyValue("remote.server"), Integer.parseInt(listeningPort));
        log.info("Connected to VPN Server.");
        return handleServerMessages(socket, secretKey, status);
    }

    private String handleServerMessages(Socket socket, SecretKey secretKey, String status) {

        String output = "-1";

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             InputStream input = new ByteArrayInputStream(status.getBytes(StandardCharsets.UTF_8));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(input));
             ) {

            String usermessage;
            while((usermessage = userInput.readLine()) != null) {
                byte[] encryptedMessage = EncryptionUtil.encrypt(usermessage, secretKey);
                out.println(Base64.getEncoder().encodeToString(encryptedMessage));
                String response = in.readLine();
                output = EncryptionUtil.decrypt(Base64.getDecoder().decode(response), secretKey);
                log.info("Server says: {}", output);
            }

            log.info("Out of while loop");
        } catch (Exception e) {
            try {
                socket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

        return output;
    }
}
