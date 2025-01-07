package simple_api.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;
import simple_api.common.dto.Search;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;

@Service
public interface SimpleService {
    List<String> getMusics(List<String> idList, Integer choice) throws ScriptException, UnirestException, IOException, NoSuchMethodException;

    List<String> getLyrics(String id) throws ScriptException, UnirestException, IOException, NoSuchMethodException;

    String getImage(String id) throws UnirestException, IOException;

    JSONArray getSearchInfo(Search search) throws ScriptException, UnirestException, IOException, NoSuchMethodException;

    JSONArray getMusicList(String id) throws UnirestException, IOException, InterruptedException;

    JSONObject getMusicListInfo(String id) throws UnirestException, IOException;

    JSONObject getMusicInfo(String id) throws UnirestException, IOException;
}
