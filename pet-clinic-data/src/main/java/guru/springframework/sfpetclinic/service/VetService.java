package guru.springframework.sfpetclinic.service;

import guru.springframework.sfpetclinic.model.Vet;

import java.util.Set;

public interface VetService
{
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
