package guru.springframework.sfpetclinic.repositories;

import guru.springframework.sfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long>
{
}
