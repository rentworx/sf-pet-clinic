package guru.springframework.sfpetclinic.service.map;

import guru.springframework.sfpetclinic.model.Vet;
import guru.springframework.sfpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService
{
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
    public Vet save(Vet object)
    {
        return super.save(object.getId(), object);
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
