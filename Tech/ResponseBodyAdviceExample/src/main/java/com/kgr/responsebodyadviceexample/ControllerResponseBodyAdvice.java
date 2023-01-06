package com.kgr.responsebodyadviceexample;

import com.google.gson.Gson;
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

@RestControllerAdvice
public class ControllerResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private final Logger logger = Logger.getLogger(String.valueOf(ControllerResponseBodyAdvice.class));

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getParameterType().equals(ResponseWrapper.class);
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Gson gson = new Gson();
        JSONObject jsonObject = new JSONObject(gson.toJson(body));
        extractObject("data", jsonObject);
        return gson.fromJson(jsonObject.toString(), ResponseWrapper.class);
    }

    @SneakyThrows
    private void extractObject(String headKey, JSONObject jsonObject) {
        JSONObject obj = (JSONObject) jsonObject.get(headKey);

        Iterator iter = obj.keys();
        while (iter.hasNext()) {
            String key = String.valueOf(iter.next());
            if (key.toLowerCase().contains("id") || key.toLowerCase().contains("seq")) {
                obj.put(key, String.valueOf(obj.get(key)));
            } else if(obj.get(key).getClass() == JSONObject.class){
                extractObject(key, obj);
            }
        }
    }

//    @SneakyThrows
//    private Field[] getFieldsFromClass(Class cls) {
//        Class<?> extractClass = Class.forName(cls.getName());
//        return extractClass.getDeclaredFields();
//    }
//
//    @SneakyThrows
//    private void changeLongToString(Field field) {
//        logger.info("change Type : " + field.getName());
//        field.setAccessible(true);
//        field.set("id", 'a');
//    }
//
//    private void recursiveFunc(Class response) {
//        Field[] fields = getFieldsFromClass(response);
//
//        // 필드를 검사해서 Long 타입의 id 또는 sequence라면 형변환 후 값 대입
//        Arrays.stream(fields).forEach(field -> {
//            if (field.getType() == Long.class &&
//                    (field.getName().toLowerCase().contains("id") || field.getName().toLowerCase().contains("seq"))) {
//                changeLongToString(field);
//            } else if (field.getType() != String.class && field.getType() != Boolean.class && field.getType() != Integer.class) {
//                recursiveFunc(field.getType());
//            }
//        });
//    }


}

//    Foo foo = new Foo();
//    Class<Foo> clazz = foo.getClass();
//    Field field = clazz.getDeclaredField("hidden");
//    Field type = Field.class.getDeclaredField("type");
//AccessibleObject.setAccessible(
//        new AccessibleObject[]{field, type}, true);
//        type.set(field, String.class);
//        field.set(foo, "This should print 5!");
//        Object hidden = field.get(foo);
//        System.out.println(hidden);
