package guru.springframework.sfpetclinic.service;

import guru.springframework.sfpetclinic.model.Pet;

import java.util.Set;

public interface PetService
{
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
