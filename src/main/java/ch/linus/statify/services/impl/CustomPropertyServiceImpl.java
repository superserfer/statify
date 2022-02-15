package ch.linus.statify.services.impl;

import ch.linus.statify.exceptions.NotFoundException;
import ch.linus.statify.models.CustomProperty;
import ch.linus.statify.repositories.CustomPropertyRepository;
import ch.linus.statify.services.CustomPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomPropertyServiceImpl implements CustomPropertyService {
    private final CustomPropertyRepository customPropertyRepository;

    @Autowired
    public CustomPropertyServiceImpl(CustomPropertyRepository customPropertyRepository) {
        this.customPropertyRepository = customPropertyRepository;
    }

    @Override
    public CustomProperty create(CustomProperty newEntity) {
        return this.customPropertyRepository.save(newEntity);
    }

    @Override
    public CustomProperty getById(UUID id) {
        return getExistingCustomProperty(id);
    }

    @Override
    public List<CustomProperty> getAll() {
        return (List<CustomProperty>) this.customPropertyRepository.findAll();
    }

    @Override
    public CustomProperty update(UUID id, CustomProperty entity) {
        entity.setCustomPropertyId(id);
        return this.customPropertyRepository.save(entity);
    }

    @Override
    public void deleteById(UUID id) {
        this.customPropertyRepository.deleteById(id);
    }

    private CustomProperty getExistingCustomProperty(UUID id) {
        // TODO: Fix Relations and remove line beneath
        this.customPropertyRepository.findAll();
        Optional<CustomProperty> optionalCustomProperty = this.customPropertyRepository.findById(id);
        if (optionalCustomProperty.isEmpty()) throw new NotFoundException();
        return optionalCustomProperty.get();
    }
}
