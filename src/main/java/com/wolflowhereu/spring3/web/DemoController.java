package com.wolflowhereu.spring3.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jxdyf09 on 15-8-28.
 */
@Controller
@RequestMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);


    @RequestMapping(value = "what/{question}.*", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> get(@RequestParam(defaultValue = "0") int id, @PathVariable(value = "question") int question) {
        logger.info("I am working! input=" + id + "question=" + question);
        Map<String, String> result = new HashMap<>();
        result.put("i", "y");
        result.put("l", "v");
        result.put("v", "l");
        result.put("y", "i");
        result.put("中文", "乱码");
        return result;
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        file.transferTo(new File("/tmp/" + file.getOriginalFilename()));
        return "上传成功";
    }


    @RequestMapping(value = "upload.html")
    public String upload() {

        return "/upload";
    }
}
