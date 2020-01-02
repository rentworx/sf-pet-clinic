package guru.springframework.sfpetclinic.repositories;

import guru.springframework.sfpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long>
{
    Owner findByLastName(String lastName);
}
