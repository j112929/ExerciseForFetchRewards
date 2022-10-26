package com.example.demo.controller;

import com.example.demo.controller.request.PointsRouteRequest;
import com.example.demo.controller.request.TransactionRoute;
import com.example.demo.controller.response.PointsRouteResponse;
import com.example.demo.store.LocalCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class IndexController {
    @Autowired
    private LocalCacheRepository localCacheRepository;
    @PostMapping("/api/add")
    public void add(@RequestBody TransactionRoute transactionRoute){
        localCacheRepository.add(transactionRoute);
    }

    @PostMapping("/api/spend")
    @ResponseBody
    public List<PointsRouteResponse> spend(@RequestBody PointsRouteRequest pointsRouteRequest){
        int spend = pointsRouteRequest.getPoints();
        if(spend ==0) return new ArrayList<>();
        List<TransactionRoute> list= localCacheRepository.getAll();
        Map<String, Integer> resMap = new HashMap<>();
        for (TransactionRoute route: list) {
            if(spend >= route.getPoints()){
                resMap.put(route.getPayer(), resMap.getOrDefault(route.getPayer(),0)-route.getPoints());
                spend -= route.getPoints();
                route.setPoints(0);
            }else {
                resMap.put(route.getPayer(), resMap.getOrDefault(route.getPayer(),0)-spend);
                route.setPoints(route.getPoints()-spend);
                spend = 0;
            }
            localCacheRepository.update(route);
            if(spend == 0){
                break;
            }
        }
        //for output order by add order
        LinkedHashSet<String> addSort = localCacheRepository.getAddSort();
        List<PointsRouteResponse> result = new ArrayList<>();
        for (String payer: addSort) {
            if(!resMap.containsKey(payer)){
                continue;
            }
            PointsRouteResponse response = new PointsRouteResponse();
            response.setPayer(payer);
            response.setPoints(resMap.get(payer));
            result.add(response);
        }
        return result;
    }

    @GetMapping("/api/balance")
    @ResponseBody
    public Map<String, Integer> balance(){
        List<TransactionRoute> list = localCacheRepository.getAll();
        Map<String, Integer> result = new HashMap<>();
        int cnt =0;
        for (TransactionRoute route:list) {
            System.out.println(cnt);
            cnt++;
            result.put(route.getPayer(), result.getOrDefault(route.getPayer(),0)+route.getPoints());
        }
        //for output order by add order
        LinkedHashSet<String> addSort = localCacheRepository.getAddSort();
        Map<String, Integer> res = new LinkedHashMap<>();
        for (String payer: addSort) {
            res.put(payer,result.get(payer));
        }
        return res;
    }




}
