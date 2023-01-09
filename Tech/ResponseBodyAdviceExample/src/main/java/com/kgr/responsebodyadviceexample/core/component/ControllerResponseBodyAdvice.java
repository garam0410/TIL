package com.kgr.responsebodyadviceexample.core.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kgr.responsebodyadviceexample.core.model.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Iterator;
import java.util.logging.Logger;

@RequiredArgsConstructor
@RestControllerAdvice
public class ControllerResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private final Logger logger = Logger.getLogger(String.valueOf(ControllerResponseBodyAdvice.class));
    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getParameterType().equals(ResponseWrapper.class);
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(body));
        extractObject("data", jsonObject);
        return objectMapper.readValue(jsonObject.toString(), ResponseWrapper.class);
    }

    @SneakyThrows
    private void extractObject(String headKey, JSONObject jsonObject) {
        JSONObject obj = (JSONObject) jsonObject.get(headKey);

        Iterator iter = obj.keys();
        while (iter.hasNext()) {
            String key = String.valueOf(iter.next());
            if (key.toLowerCase().contains("id") || key.toLowerCase().contains("seq")) {
                obj.put(key, String.valueOf(obj.get(key)));
            } else if (obj.get(key).getClass() == JSONObject.class) {
                extractObject(key, obj);
            }
        }
    }
}