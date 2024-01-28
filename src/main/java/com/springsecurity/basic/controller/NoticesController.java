package com.springsecurity.basic.controller;

import com.springsecurity.basic.model.Notice;
import com.springsecurity.basic.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("notices")
    public ResponseEntity<List<Notice>> getNotiecs() {
        List<Notice> noties = noticeRepository.findAllActiveNotices();
        if(noties != null) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(noties);
        } else {
            return null;
        }
    }
}
