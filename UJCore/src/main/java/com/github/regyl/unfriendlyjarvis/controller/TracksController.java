package com.github.regyl.unfriendlyjarvis.controller;

import com.github.regyl.unfriendlyjarvis.entity.TrackEntity;
import com.github.regyl.unfriendlyjarvis.service.yandexmusic.YandexMusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/tracks")
@RequiredArgsConstructor
public class TracksController {

    private final YandexMusicService service;

    @PostMapping
    public void uploadTracks() {
        service.uploadTracks();
    }

    @GetMapping
    public Collection<TrackEntity> findAll() {
        return service.findAll().stream().limit(10).toList();
    }
}
