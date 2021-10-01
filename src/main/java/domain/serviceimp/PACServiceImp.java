package domain.serviceimp;

import domain.dto.PACRegistryDTO;
import domain.service.IPACService;
import org.modelmapper.ModelMapper;
import persistence.crud.IPACPersistence;
import persistence.model.PACRegistry;
import util.DataUtil;

import java.util.ArrayList;
import java.util.List;


public class PACServiceImp implements IPACService {

    private IPACPersistence pacPersistence;
    private ModelMapper mapper;

    @Override
    public String createFile() {
        String serviceResponse;
        DataUtil data = new DataUtil();

        boolean persistenceResponse = pacPersistence
                .createFile(data.getEnvironmentVariables().get(0), data.getEnvironmentVariables().get(1));

        if (persistenceResponse) {
            serviceResponse = data.messageBanner("Archivo creado satisfactoriamente");
        } else {
            serviceResponse = data.messageBanner("Se presentó un error durante la creación del archivo");
        }
        return serviceResponse;
    }

    @Override
    public String deleteFile() {
        String serviceResponse;
        DataUtil data = new DataUtil();

        boolean persistenceResponse = pacPersistence
                .deleteFile(data.getEnvironmentVariables().get(0), data.getEnvironmentVariables().get(1));

        if (persistenceResponse) {
            serviceResponse = data.messageBanner("Archivo eliminado satisfactoriamente");
        } else {
            serviceResponse = data.messageBanner("Se presentó un error durante la eliminación del archivo");
        }
        return serviceResponse;
    }

    @Override
    public String newRegistry(PACRegistry payload) {
        String serviceResponse;
        DataUtil data = new DataUtil();

        boolean persistenceResponse = pacPersistence
                .newRegistry(data.getEnvironmentVariables().get(0), data.getEnvironmentVariables().get(0), payload);

        if (persistenceResponse) {
            serviceResponse = data.messageBanner("Registro guardado satisfactoriamente");
        } else {
            serviceResponse = data.messageBanner("Se presentó un error durante la grabación del registro");
        }
        return serviceResponse;
    }

    @Override
    public List<PACRegistryDTO> readAllRegistries() {
        List<PACRegistryDTO> registriesDto = new ArrayList<>();
        DataUtil data = new DataUtil();

        pacPersistence.readAllRegistries(data.getEnvironmentVariables().get(0), data.getEnvironmentVariables().get(1))
                .forEach(registry -> registriesDto.add(mapper.map(registry, PACRegistryDTO.class)));

        return registriesDto;
    }

    @Override
    public PACRegistryDTO findRegistryByDate(String date) {
        DataUtil data = new DataUtil();

        PACRegistry registry = pacPersistence
                .findRegistryByDate(data.getEnvironmentVariables().get(0), data.getEnvironmentVariables().get(1), date);

        return mapper.map(registry, PACRegistryDTO.class);
    }

    @Override
    public String updateRegistry(PACRegistryDTO payload) {
        String serviceResponse;
        DataUtil data = new DataUtil();

        PACRegistry registry = mapper.map(payload, PACRegistry.class);
        boolean persistenceResponse = pacPersistence
                .updateRegistry(data.getEnvironmentVariables().get(0), data.getEnvironmentVariables().get(1), registry);

        if (persistenceResponse) {
            serviceResponse = data.messageBanner("Registro actualizado satisfactoriamente");
        } else {
            serviceResponse = data.messageBanner("Se presentó un error durante la actualización del registro");
        }
        return serviceResponse;
    }

    @Override
    public String deleteRegistry(PACRegistryDTO payload) {
        String serviceResponse;
        DataUtil data = new DataUtil();

        PACRegistry registry = mapper.map(payload, PACRegistry.class);
        boolean persistenceResponse = pacPersistence
                .deleteRegistry(data.getEnvironmentVariables().get(0), data.getEnvironmentVariables().get(1), registry);

        if (persistenceResponse) {
            serviceResponse = data.messageBanner("Registro eliminado satisfactoriamente");
        } else {
            serviceResponse = data.messageBanner("Se presentó un error durante la eliminación del registro");
        }
        return serviceResponse;
    }
}
