package com.example.accesskeybackend.template.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

@Service
@AllArgsConstructor
@Log4j2
public class Ipv6SupportService {
    public boolean checkIpv6Support(String url) throws URISyntaxException, UnknownHostException {
        if (!url.toLowerCase().matches("^\\w+://.*")) {
            url = "http://" + url;
        }
        URI siteUrl = new URI(url);
        InetAddressValidator validator = InetAddressValidator.getInstance();
        for (InetAddress fullUrl : InetAddress.getAllByName(siteUrl.getHost())) {
            String urlAndIp = fullUrl.toString();
            if (validator.isValidInet6Address(urlAndIp.substring(urlAndIp.indexOf("/")+1))) {
                return true;
            }
        }
        return false;
    }
}
