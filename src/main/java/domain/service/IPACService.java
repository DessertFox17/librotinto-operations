package domain.service;

import domain.dto.PACRegistryDTO;
import persistence.model.PACRegistry;

import java.util.List;

public interface IPACService {
    String createFile();
    String deleteFile();
    String newRegistry(PACRegistry payload);
    List<PACRegistryDTO> readAllRegistries();
    PACRegistryDTO findRegistryByDate(String date);
    String updateRegistry(PACRegistryDTO payload);
    String deleteRegistry(PACRegistryDTO payload);
}
