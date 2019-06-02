package guru.springframework.sfpetclinic.service;

import guru.springframework.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
    Owner findByLastName(String lastName);
}
