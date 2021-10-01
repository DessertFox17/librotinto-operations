package persistence.data;

import persistence.crud.IPACPersistence;
import persistence.model.PACRegistry;
import util.DataUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PACPersistenceDAO implements IPACPersistence {
    private File file;
    private PrintWriter writer;
    private BufferedReader reader;

    @Override
    public boolean createFile(String path, String fileName) {
        boolean response = false;
        file = new File(path + fileName);
        try {
            PrintWriter output = new PrintWriter(file);
            output.close();
            response = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public boolean deleteFile(String path, String fileName) {
        File file = new File(path + fileName);
        boolean response = false;
        if (file.exists()) {
            response = file.delete();
        }
        return response;
    }

    @Override
    public boolean newRegistry(String path, String fileName, PACRegistry payload) {
        boolean response = false;
        file = new File(path + fileName);
        DataUtil data = new DataUtil();
        String content = data.fromPACtoString(payload);
        try {
            writer = new PrintWriter(new FileWriter(file, true));
            writer.println(content);
            response = true;
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public List<PACRegistry> readAllRegistries(String path, String fileName) {
        List<PACRegistry> registries = new ArrayList<>();
        DataUtil data = new DataUtil();
        try {
            reader = new BufferedReader(new FileReader(path + fileName));
            String read = reader.readLine();
            while (read != null) {
                PACRegistry pac = data.fromStringToPAC(read);
                registries.add(pac);
                read = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registries;
    }

    @Override
    public PACRegistry findRegistryByDate(String path, String fileName, String date){
        List<PACRegistry> registries = readAllRegistries(path, fileName);
        return registries.stream().filter(registry -> Objects.equals(registry.getDate(), date))
                .findFirst().orElse(null);
    }

    @Override
    public boolean updateRegistry(String path, String fileName, PACRegistry payload) {
        boolean response = false;
        DataUtil data = new DataUtil();
        file = new File(path + fileName);
        List<PACRegistry> registries = readAllRegistries(path, fileName);
        registries.remove(findRegistryByDate(path,fileName,payload.getDate()));
        registries.add(payload);
        List<String> content = data.fromPACsToStrings(registries);
        try {
            writer = new PrintWriter(new FileWriter(file));
            writer.println();
            writer.close();
            content.forEach(element -> {
                try {
                    writer = new PrintWriter(new FileWriter(file,true));
                    writer.println(element);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            response = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public boolean deleteRegistry(String path, String fileName, PACRegistry toRemove) {
        boolean response = false;
        DataUtil data = new DataUtil();
        file = new File(path + fileName);
        List<PACRegistry> registries = readAllRegistries(path, fileName);
        registries.remove(toRemove);
        List<String> content = data.fromPACsToStrings(registries);
        try {
            writer = new PrintWriter(new FileWriter(file));
            writer.println();
            writer.close();
            content.forEach(element -> {
                try {
                    writer = new PrintWriter(new FileWriter(file,true));
                    writer.println(element);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            response = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
