package guru.springframework.sfpetclinic.service.jpa;

import guru.springframework.sfpetclinic.model.Visit;
import guru.springframework.sfpetclinic.repositories.VisitRepository;
import guru.springframework.sfpetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitJpaService implements VisitService
{
    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository)
    {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll()
    {
        Set<Visit> visits = new HashSet<>();
        this.visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id)
    {
        return this.visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit)
    {
        return this.visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit)
    {
        this.visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id)
    {
        this.visitRepository.deleteById(id);
    }
}
