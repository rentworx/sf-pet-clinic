package guru.springframework.sfpetclinic.service.map;

import guru.springframework.sfpetclinic.model.Specialty;
import guru.springframework.sfpetclinic.service.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService
{
    @Override
    public Set<Specialty> findAll()
    {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty specialty)
    {
        return super.save(specialty);
    }

    @Override
    public void delete(Specialty object)
    {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}
