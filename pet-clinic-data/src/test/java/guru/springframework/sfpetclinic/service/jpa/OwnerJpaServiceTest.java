package guru.springframework.sfpetclinic.service.jpa;

import guru.springframework.sfpetclinic.model.Owner;
import guru.springframework.sfpetclinic.repositories.OwnerRepository;
import guru.springframework.sfpetclinic.repositories.PetRepository;
import guru.springframework.sfpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest
{
    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerJpaService ownerJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp()
    {
        returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName()
    {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = ownerJpaService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll()
    {
        Set<Owner> returnOwners = new HashSet<>();
        Owner o1 = new Owner();
        Owner o2 = new Owner();
        o1.setId(1L);
        o2.setId(2L);
        returnOwners.add(o1);
        returnOwners.add(o2);
        when(ownerRepository.findAll()).thenReturn(returnOwners);
        Set<Owner> owners = ownerJpaService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById()
    {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerJpaService.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound()
    {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerJpaService.findById(1L);
        assertNull(owner);
    }

    @Test
    void save()
    {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = ownerJpaService.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete()
    {
        ownerJpaService.delete(returnOwner);

        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById()
    {
        ownerJpaService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}
