package guru.springframework.sfpetclinic.repositories;

import guru.springframework.sfpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long>
{
}
