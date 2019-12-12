package com.hisense.testapp.utils;
/*
* hxh
* today
*/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RestTemplateUtils {

    @Autowired
    RestTemplate restTemplate;

    /**
     * get请求
     *
     * @param url
     * @param param
     * @param headerParam
     * @return
     */
    public JSONObject httpHeaderGet(String url, Map<String, Object> param, Map<String, String> headerParam) {
        try {
            HttpHeaders headers = new HttpHeaders();
            for (Map.Entry<String, String> entry : headerParam.entrySet()) {
                headers.add(entry.getKey(), entry.getValue());
            }
            if (!param.isEmpty()) {
                url = url + "?";
                for (Map.Entry<String, Object> entry : param.entrySet()) {
                    url = url + entry.getKey() + "={" + entry.getKey() + "}&";
                }
                url = url.substring(0, url.length() - 1);
            }
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(headers), String.class, param);
            String result = response.getBody();
            return JSONObject.parseObject(result);
        } catch (RestClientResponseException ex) {
            throw new RuntimeException("请求异常，statuCode：" + ex.getRawStatusCode() + ",msg：" + ex.getMessage());
        }
    }

    /**
     * post json
     *
     * @param url
     * @param param
     * @param headerParam
     * @return
     */
    public JSONObject httpPostJson(String url, Map<String, Object> param, Map<String, String> headerParam) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            for (Map.Entry<String, String> entry : headerParam.entrySet()) {
                headers.add(entry.getKey(), entry.getValue());
            }
            String jsonstr = JSON.toJSONString(param);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(jsonstr, headers), String.class);
            String result = response.getBody();
            return JSONObject.parseObject(result);
        } catch (RestClientResponseException ex) {
            throw new RuntimeException("请求异常，statuCode：" + ex.getRawStatusCode() + ",msg：" + ex.getMessage());
        }
    }

    /**
     * post form
     *
     * @param url
     * @param param
     * @param headerParam
     * @return
     */
    public JSONObject httpPostForm(String url, Map<String, Object> param, Map<String, String> headerParam) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            for (Map.Entry<String, String> entry : headerParam.entrySet()) {
                headers.add(entry.getKey(), entry.getValue());
            }
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                map.add(entry.getKey(), entry.getValue());
            }
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(map, headers), String.class);
            String result = response.getBody();
            return JSONObject.parseObject(result);
        } catch (RestClientResponseException ex) {
            throw new RuntimeException("请求异常，statuCode：" + ex.getRawStatusCode() + ",msg：" + ex.getMessage());
        }
    }
}
