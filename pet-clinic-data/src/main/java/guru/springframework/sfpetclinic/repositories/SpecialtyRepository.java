package guru.springframework.sfpetclinic.repositories;

import guru.springframework.sfpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long>
{
}
