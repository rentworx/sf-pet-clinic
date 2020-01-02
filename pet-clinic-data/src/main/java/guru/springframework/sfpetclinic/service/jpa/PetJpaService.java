package guru.springframework.sfpetclinic.service.jpa;

import guru.springframework.sfpetclinic.model.Pet;
import guru.springframework.sfpetclinic.repositories.PetRepository;
import guru.springframework.sfpetclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService
{
    private final PetRepository petRepository;

    public PetJpaService(PetRepository petRepository)
    {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll()
    {
        Set<Pet> pets = new HashSet<>();
        this.petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id)
    {
        return this.petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object)
    {
        return this.petRepository.save(object);
    }

    @Override
    public void delete(Pet object)
    {
        this.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        this.deleteById(id);
    }
}
