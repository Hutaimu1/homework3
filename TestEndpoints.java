package com.example.demo7.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Vector;

/**
 * Created by xujingfeng on 2017/8/7.
 */
@RestController
public class TestEndpoints {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id : " + id;
    }

    @RequestMapping("/WordLadder")
    public Ladder greeting(@RequestParam(value = "begin", defaultValue = "hello") String begin,
                           @RequestParam(value = "end", defaultValue = "world") String end) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WordLadder wl = new WordLadder(begin, end);
        Ladder ladder = new Ladder();
        ladder.setBegin(begin);
        ladder.setEnd(end);
        ladder.setLadder(wl.findSolution());
        return ladder;
    }
}
