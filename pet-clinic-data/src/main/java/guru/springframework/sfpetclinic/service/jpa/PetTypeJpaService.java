package guru.springframework.sfpetclinic.service.jpa;

import guru.springframework.sfpetclinic.model.PetType;
import guru.springframework.sfpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService
{
    private final PetTypeRepository petTypeRepository;

    public PetTypeJpaService(PetTypeRepository petTypeRepository)
    {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll()
    {
        Set<PetType> types = new HashSet<>();
        this.petTypeRepository.findAll().forEach(types::add);
        return types;
    }

    @Override
    public PetType findById(Long id)
    {
        return this.petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object)
    {
        return this.petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object)
    {
        this.petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        this.petTypeRepository.deleteById(id);
    }
}
