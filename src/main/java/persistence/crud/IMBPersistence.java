package persistence.crud;

import persistence.model.MBRegistry;

import java.util.List;

public interface IMBPersistence {
    boolean createFile(String path, String fileName);
    boolean deleteFile(String path, String fileName);
    boolean newRegistry(String path, String fileName, MBRegistry payload);
    List<MBRegistry> readAllRegistries(String path, String fileName);
    MBRegistry findRegistryByDate(String path, String fileName, String date);
    boolean updateRegistry(String path, String fileName, MBRegistry payload);
    boolean deleteRegistry(String path, String fileName, MBRegistry payload);
}
