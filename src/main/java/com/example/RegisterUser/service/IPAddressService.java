package com.example.RegisterUser.service;

import com.example.RegisterUser.entity.IPAddressInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IPAddressService {
    @Value("${ip.api.base.url}")
    private String ipApiBaseUrl;

    private final RestTemplate restTemplate;

    public IPAddressService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public IPAddressInfo getIPAddressInfo(String ipAddress) {
        String apiUrl = ipApiBaseUrl + ipAddress;
        IPAddressInfo ipInfo = restTemplate.getForObject(apiUrl, IPAddressInfo.class);
        return ipInfo;
    }

}
