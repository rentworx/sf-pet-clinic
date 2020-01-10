package guru.springframework.sfpetclinic.controller;

import guru.springframework.sfpetclinic.model.Owner;
import guru.springframework.sfpetclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest
{
    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp()
    {
        this.owners = new HashSet<>();
        Owner o1 = new Owner();
        o1.setId(1L);
        Owner o2 = new Owner();
        o2.setId(2L);
        this.owners.add(o1);
        this.owners.add(o2);
        this.mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwners() throws Exception
    {
        when(ownerService.findAll()).thenReturn(owners);
        this.mockMvc.perform(get("/owners"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/index"))
            .andExpect(model().attributeExists("owners"));

        verifyZeroInteractions(ownerService);
    }

    @Test
    void listOwnersIndex() throws Exception
    {
        when(ownerService.findAll()).thenReturn(owners);
        this.mockMvc.perform(get("/owners/index"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/index"))
            .andExpect(model().attributeExists("owners"));

        verifyZeroInteractions(ownerService);
    }

    @Test
    void findOwners() throws Exception
    {
        this.mockMvc.perform(get("/owners/find"))
            .andExpect(status().isOk())
            .andExpect(view().name("notimplemented"));
        verifyZeroInteractions(ownerService);
    }
}
