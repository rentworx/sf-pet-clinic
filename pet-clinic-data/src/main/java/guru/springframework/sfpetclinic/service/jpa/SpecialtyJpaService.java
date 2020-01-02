package guru.springframework.sfpetclinic.service.jpa;

import guru.springframework.sfpetclinic.model.Specialty;
import guru.springframework.sfpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfpetclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtyJpaService implements SpecialtyService
{
    private final SpecialtyRepository specialtyRepository;

    public SpecialtyJpaService(SpecialtyRepository specialtyRepository)
    {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll()
    {
        Set<Specialty> specialties = new HashSet<>();
        this.specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong)
    {
        return this.specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object)
    {
        return this.specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object)
    {
        this.specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong)
    {
        this.specialtyRepository.deleteById(aLong);
    }
}
