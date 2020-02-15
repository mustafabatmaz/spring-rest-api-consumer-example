package com.mustafa.examplewebservice.Service;

import com.mustafa.examplewebservice.Enum.RequestType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class RequestInfoHolder {

    private Map<RequestType, Integer> requestCountMap;

    RequestInfoHolder() {
        requestCountMap = new HashMap<>();
        Arrays.stream(RequestType.values()).forEach(type -> requestCountMap.put(type, 0));
    }

    public void incrementRequestCount(RequestType type) {
        int newValue = requestCountMap.getOrDefault(type, 0) + 1;
        requestCountMap.put(type, newValue);
    }

    @Scheduled(fixedRate = 10000)
    private void servicesCount() {
        requestCountMap.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey().toString() + " Count : " + entry.getValue());
                    requestCountMap.put(entry.getKey(), 0);
                });
    }
}
