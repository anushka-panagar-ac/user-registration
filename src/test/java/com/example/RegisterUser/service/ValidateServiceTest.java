package com.example.RegisterUser.service;

import com.example.RegisterUser.entity.IPAddressInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ValidateServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private IPAddressService ipAddressService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks

        // Create an instance of the service using the mocked RestTemplate
        ipAddressService = new IPAddressService(restTemplate);
    }

    @Test
    public void testGetIPAddressInfo() {

        IPAddressService ipAddressServiceMock = mock(IPAddressService.class);

        String ipAddress = "24.48.0.1";
        String apiUrl = "http://ip-api.com/json/24.48.0.1";

        IPAddressInfo expectedInfo = new IPAddressInfo();
        expectedInfo.setCountry("Canada");
        expectedInfo.setIpAddress("24.48.0.1");
        expectedInfo.setCity("Montreal");

        // Stub the behavior of the mocked RestTemplate
        when(restTemplate.getForObject(apiUrl, IPAddressInfo.class)).thenReturn(expectedInfo);

        // Call the service method
        IPAddressInfo result = ipAddressService.getIPAddressInfo(ipAddress);

        // Verify that the RestTemplate was called with the correct URL
        verify(restTemplate, times(1)).getForObject(apiUrl, IPAddressInfo.class);
        IPAddressInfo actualInfo = ipAddressServiceMock.getIPAddressInfo("24.48.0.1");
        IPAddressInfo actualInfo2 = ipAddressServiceMock.getIPAddressInfo("192.58.23.2");

        // Verify that the returned object matches the expected one
        // Add appropriate assertions based on the expectedInfo
        assertEquals(expectedInfo.getIpAddress(),actualInfo.getCountry());
        assertNotEquals(expectedInfo.getIpAddress(),actualInfo2.getCountry());
    }
}
