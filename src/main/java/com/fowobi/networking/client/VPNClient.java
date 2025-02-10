//package com.fowobi.networking.client;
//
//import com.fowobi.networking.util.EncryptionUtil;
//import com.fowobi.networking.util.PropertyReader;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Base64;
//
//
//public class VPNClient {
//    private static final Logger log = LoggerFactory.getLogger(VPNClient.class);
//
//    public void connect() throws Exception {
//
//        String encodedKey = PropertyReader.getPropertyValue("secret.key");
//        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
//        SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
//
//        String listeningPort = PropertyReader.getPropertyValue("server.listening.port");
//        Socket socket = new Socket(PropertyReader.getPropertyValue("remote.server"), Integer.parseInt(listeningPort));
//        log.info("Connected to VPN Server.");
//        handleServerMessages(socket, secretKey);
//    }
//
//    private void handleServerMessages(Socket socket, SecretKey secretKey) {
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
//
//            String usermessage;
//            while((usermessage = userInput.readLine()) != null) {
//                byte[] encryptedMessage = EncryptionUtil.encrypt(usermessage, secretKey);
//                out.println(Base64.getEncoder().encodeToString(encryptedMessage));
//                String response = in.readLine();
//                log.info(EncryptionUtil.decrypt(Base64.getDecoder().decode(response), secretKey));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
