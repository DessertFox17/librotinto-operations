package util;

import com.google.gson.Gson;
import persistence.model.PACRegistry;

import java.util.ArrayList;
import java.util.List;

public class DataUtil{
    public String fromPACtoString(PACRegistry pacRegistry) {
        return getGsonInstance().toJson(pacRegistry);
    }

    public PACRegistry fromStringToPAC(String json) {
        return getGsonInstance().fromJson(json, PACRegistry.class);
    }

    public List<String> fromPACsToStrings(List<PACRegistry> payload){
        List<String> pacList = new ArrayList<>();
        payload.forEach(registry -> {
            String value = fromPACtoString(registry);
            pacList.add(value);
        });
        return pacList;
    }

    public Gson getGsonInstance() {
        return new Gson();
    }
}
