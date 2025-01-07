package simple_api.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.exceptions.UnirestException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import simple_api.common.dto.Search;
import simple_api.common.entity.Result;
import simple_api.service.SimpleService;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class SimpleController {

    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    SimpleService simpleService;


    @PostMapping("/musics/{choice}")
    public Result getMusics(@RequestBody List<String> idList, @PathVariable Integer choice) throws ScriptException, UnirestException, IOException, NoSuchMethodException {
//        log.info("访问URL: {}", httpServletRequest.getRequestURI());
        List<String> result = simpleService.getMusics(idList, choice);
        if (result != null) { return Result.success(result); }
        return Result.serverError("");
    }

    @GetMapping("/image/{id}")
    public Result getImage(@PathVariable String id) throws UnirestException, IOException, NoSuchMethodException {
        String result =simpleService.getImage(id);
        if (result != null) { return Result.success(result); }
        return Result.serverError("");
    }

    @GetMapping("/lyrics/{id}")
    public Result getLyrics(@PathVariable String id) throws ScriptException, UnirestException, IOException, NoSuchMethodException {
        List<String> result =simpleService.getLyrics(id);
        if (!result.isEmpty()) { return Result.success(result); }
        return Result.serverError("");
    }

    @PostMapping("/search")
    public Result search(@RequestBody Search search) throws ScriptException, UnirestException, IOException, NoSuchMethodException {
        JSONArray result = simpleService.getSearchInfo(search);
        if (result != null) { return Result.success(result); }
        return Result.serverError("");
    }

    @GetMapping("/list/{id}")
    public Result getList(@PathVariable String id) throws ScriptException, UnirestException, IOException, NoSuchMethodException, InterruptedException {
        JSONArray result = simpleService.getMusicList(id);
        if (result != null) { return Result.success(result); }
        return Result.serverError("");
    }

    @GetMapping("/listInfo/{id}")
    public Result getListInfo(@PathVariable String id) throws ScriptException, UnirestException, IOException, NoSuchMethodException {
        JSONObject result = simpleService.getMusicListInfo(id);
        if (result != null) { return Result.success(result); }
        return Result.serverError("");
    }

    @GetMapping("/musicInfo/{id}")
    public Result getMusicInfo(@PathVariable String id) throws ScriptException, UnirestException, IOException, NoSuchMethodException {
        JSONObject result = simpleService.getMusicInfo(id);
        if (result != null) { return Result.success(result); }
        return Result.serverError("");
    }
}
