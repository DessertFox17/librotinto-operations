package persistence.crud;

import persistence.model.PACRegistry;

import java.util.List;

public interface IPACPersistence {
    boolean createFile(String path, String fileName);
    boolean deleteFile(String path, String fileName);
    boolean newRegistry(String path, String fileName, PACRegistry payload);
    List<PACRegistry> readAllRegistries(String path, String fileName);
    PACRegistry findRegistryByDate(String path, String fileName, String date);
    boolean updateRegistry(String path, String fileName, PACRegistry payload);
    boolean deleteRegistry(String path, String fileName, PACRegistry payload);
}
