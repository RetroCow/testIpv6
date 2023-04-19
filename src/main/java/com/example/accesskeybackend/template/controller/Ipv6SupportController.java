package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.Ipv6SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.*;

@RestController
@RequestMapping("/api/web/")
@RequiredArgsConstructor
public class Ipv6SupportController {
    private final Ipv6SupportService ipv6SupportService;
    @GetMapping("/checkIpv6Support")
    public Boolean checkIpv6Support(@RequestParam String url) throws UnknownHostException, URISyntaxException {
        return ipv6SupportService.checkIpv6Support(url);
    }
}
