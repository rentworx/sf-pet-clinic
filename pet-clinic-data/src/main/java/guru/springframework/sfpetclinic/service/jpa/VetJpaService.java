package guru.springframework.sfpetclinic.service.jpa;

import guru.springframework.sfpetclinic.model.Vet;
import guru.springframework.sfpetclinic.repositories.VetRepository;
import guru.springframework.sfpetclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService
{
    private VetRepository vetRepository;

    public VetJpaService(VetRepository vetRepository)
    {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll()
    {
        Set<Vet> vets = new HashSet<>();
        this.vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id)
    {
        return this.vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object)
    {
        return this.vetRepository.save(object);
    }

    @Override
    public void delete(Vet object)
    {
        this.vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        this.vetRepository.deleteById(id);
    }
}
