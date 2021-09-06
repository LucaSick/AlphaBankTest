package com.example.alphabanktest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface GifInterface {
    @GetMapping("/translate")
    public Object getID(@RequestParam("api_key") String api_key,
                        @RequestParam("s") String s,
                        @RequestParam("weirdness") int weirdness);

    @GetMapping("/search")
    public Object getGif(@RequestParam("api_key") String api_key,//,
                         @RequestParam("q") String q);
                         //@RequestParam("limit") String limit,
                         //@RequestParam("random_id") String random_id);

}
