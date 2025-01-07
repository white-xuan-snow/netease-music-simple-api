package simple_api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.zankeu.netease.spider.spider.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import simple_api.common.dto.Search;
import simple_api.common.entity.Result;
import simple_api.service.SimpleService;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class SimpleServiceImpl implements SimpleService {

    @Autowired
    GetMusics getMusics;
    @Autowired
    GetImage getImage;
    @Autowired
    GetLyrics getLyrics;
    @Autowired
    GetSearchInfo getSearchInfo;
    @Autowired
    GetMusicList getMusicList;
    @Autowired
    GetMusicInfo getMusicInfo;
    @Autowired
    GetListInfo getListInfo;


    @Override
    public List<String> getMusics(List<String> idList, Integer choice) throws ScriptException, UnirestException, IOException, NoSuchMethodException {

        List<String> result = getMusics.run(idList, choice);
        return result;
    }



    @Override
    public List<String> getLyrics(String id) throws ScriptException, UnirestException, IOException, NoSuchMethodException {
        List<String> result = getLyrics.run(id);
        return result;
    }

    @Override
    public String getImage(String id) throws UnirestException, IOException {
        String result = getImage.run(id);
        return result;
    }

    @Override
    public JSONArray getSearchInfo(Search search) throws ScriptException, UnirestException, IOException, NoSuchMethodException {
        JSONArray result = getSearchInfo.run(search.getContent(), search.getPage(), search.getSize());
        return result;
    }

    @Override
    public JSONArray getMusicList(String id) throws UnirestException, IOException, InterruptedException {
        JSONArray result = getMusicList.run(id);
        return result;
    }

    @Override
    public JSONObject getMusicListInfo(String id) throws UnirestException, IOException {
        JSONObject result = getListInfo.run(id);
        return result;
    }

    @Override
    public JSONObject getMusicInfo(String id) throws UnirestException, IOException {
        JSONObject result = getMusicInfo.run(id);
        return result;
    }
}
