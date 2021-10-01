package util;

import com.google.gson.Gson;
import domain.serviceimp.PACServiceImp;
import persistence.model.PACRegistry;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

    public List<String> getEnvironmentVariables(){
        List<String> environmentVariables = new ArrayList<>();
        String path;
        String fileName;
        try (InputStream input = PACServiceImp.class.getClassLoader().getResourceAsStream("maven.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            path = prop.getProperty("PATH");
            fileName = prop.getProperty("PAC_FILE_NAME");
            environmentVariables.add(path);
            environmentVariables.add(fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return environmentVariables;
    }

    public String messageBanner(String message){
        return "\n----------------------------------------------------\n"
                + message
                +"\n----------------------------------------------------";
    }

    public static String getDateString(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}
