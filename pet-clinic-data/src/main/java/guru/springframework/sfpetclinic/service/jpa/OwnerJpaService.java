package guru.springframework.sfpetclinic.service.jpa;

import guru.springframework.sfpetclinic.model.Owner;
import guru.springframework.sfpetclinic.repositories.OwnerRepository;
import guru.springframework.sfpetclinic.repositories.PetRepository;
import guru.springframework.sfpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfpetclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService
{
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository)
    {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName)
    {
        return this.ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll()
    {
        Set<Owner> owners = new HashSet<>();
        this.ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong)
    {
        return this.ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object)
    {
        return this.ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object)
    {
        this.ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong)
    {
        this.ownerRepository.deleteById(aLong);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName)
    {
        return this.ownerRepository.findAllByLastNameLike(lastName);
    }
}
