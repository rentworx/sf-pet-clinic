package guru.springframework.sfpetclinic.service.map;

import guru.springframework.sfpetclinic.model.Specialty;
import guru.springframework.sfpetclinic.model.Vet;
import guru.springframework.sfpetclinic.service.SpecialtyService;
import guru.springframework.sfpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService
{
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService)
    {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll()
    {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet)
    {
        if (vet != null)
        {
            if (vet.getSpecialties() != null)
            {
                vet.getSpecialties().forEach( spec -> {
                    if (spec.getId() == null)
                    {
                        Specialty savedSpec = specialtyService.save(spec);
                        spec.setId(savedSpec.getId());
                    }
                });
            }
            return super.save(vet);
        }
        return null;
    }

    @Override
    public void delete(Vet object)
    {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}
