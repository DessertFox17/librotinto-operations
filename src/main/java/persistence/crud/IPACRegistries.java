package persistence.crud;

import persistence.model.PACRegistry;

import java.util.List;

public interface IPACRegistries {
    boolean createFile(String path, String fileName);
    boolean deleteFile(String path, String fileName);
    boolean newRegistry(String path, String fileName, PACRegistry payload);
    List<PACRegistry> readAllRegistries(String path, String fileName);
    boolean updateRegistry(String path, String fileName, PACRegistry toAdd, PACRegistry toRemove);
    boolean deleteRegistry(String path, String fileName, PACRegistry toRemove);
}
