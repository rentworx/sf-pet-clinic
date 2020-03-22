package guru.springframework.sfpetclinic.service;

import guru.springframework.sfpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>
{
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
