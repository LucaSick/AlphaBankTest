package com.example.alphabanktest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
// 967502df1562443fa1b861e5786832fe
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedHashMap;

@RestController
@EnableFeignClients(basePackageClasses = {gifServiceProxy.class, apiServiceProxy.class})
public class ApiController {

    @Autowired
    @MockBean
    private apiServiceProxy proxy;

    @Autowired
    @MockBean
    private gifServiceProxy gproxy;


    @GetMapping(value = "/pls/{currency}")
    public RedirectView getCountries(@PathVariable("currency") String currency) throws IOException {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        String curDate = today.toString();
        String prevDate = yesterday.toString();
        LinkedHashMap<String, LinkedHashMap<String, Double>> pr1 = (LinkedHashMap<String, LinkedHashMap<String, Double>>) proxy.getCountries(curDate, "967502df1562443fa1b861e5786832fe");
        LinkedHashMap<String, Double> newpr1 = pr1.get("rates");
        double res1 = newpr1.get(currency) / newpr1.get("RUB");
        LinkedHashMap<String, LinkedHashMap<String, Double>> pr2 = (LinkedHashMap<String, LinkedHashMap<String, Double>>) proxy.getCountries(prevDate, "967502df1562443fa1b861e5786832fe");
        LinkedHashMap<String, Double> newpr2 = pr2.get("rates");
        double res2 = newpr2.get(currency) / newpr2.get("RUB");
        return getGif(res1 - res2 > 0);
    }

    public RedirectView getGif(boolean rich) throws IOException {
        String word = "";
        if (rich)
            word = "rich";
        else
            word = "broke";
        //return gproxy.getGif("274aO2atwB51v7uRz7CwoHT3cqAnTvBr", word);
        Object gif =  gproxy.getID("274aO2atwB51v7uRz7CwoHT3cqAnTvBr", word, 10);
        LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>>> hgif = (LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>>>) gif;
        String url = hgif.get("data").get("images").get("downsized_large").get("url");
        return localRedirect(url);
    }

    public RedirectView localRedirect(String url) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        return redirectView;
    }
}
