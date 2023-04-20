package com.monitoring.monitoringsampleapplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONStringer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@RestController
public class MainController {

    static String key = "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";

    @GetMapping("/end-point-1")
    public String endPoint1() {
        return "API EndPoint 1";
    }

    @GetMapping("/end-point-2")
    public String endPoint2() {
        return "API EndPoint 2";
    }

//    @GetMapping("/chat-gpt")
//    public String result(@RequestParam String text) throws IOException {
//        URL url = new URL("https://api.openai.com/v1/completions");
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("POST");
//        con.setRequestProperty("Content-Type", "application/json; utf-8");
//        con.setRequestProperty("Authorization", "Bearer " + key);
//        con.setDoOutput(true);
//        String input = new ObjectMapper().writeValueAsString( new Model("text-davinci-003", text, 1024));
//        try (OutputStream os = con.getOutputStream()) {
//            byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
//            os.write(inputBytes, 0, inputBytes.length);
//        }
//
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            return response.toString();
//        }
//    }
}
