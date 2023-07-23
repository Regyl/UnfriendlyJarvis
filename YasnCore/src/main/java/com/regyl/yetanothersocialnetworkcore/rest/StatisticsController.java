package com.regyl.yetanothersocialnetworkcore.rest;

import com.regyl.yetanothersocialnetworkcore.api.StatisticsService;
import com.regyl.yetanothersocialnetworkcore.dto.StatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/count")
    public StatisticDto count() {
        return statisticsService.count();
    }
}
