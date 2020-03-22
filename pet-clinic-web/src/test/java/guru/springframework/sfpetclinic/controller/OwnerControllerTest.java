package guru.springframework.sfpetclinic.controller;

import guru.springframework.sfpetclinic.model.Owner;
import guru.springframework.sfpetclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest
{
    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;
    Owner o1;
    Owner o2;

    MockMvc mockMvc;

    @BeforeEach
    void setUp()
    {
        this.owners = new HashSet<>();
        o1 = new Owner();
        o1.setId(1L);
        o2 = new Owner();
        o2.setId(2L);
        this.owners.add(o1);
        this.owners.add(o2);
        this.mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }


    @Test
    void findOwners() throws Exception
    {
        this.mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));
        verifyZeroInteractions(ownerService);
    }

    @Test
    void processFindFormReturnMany() throws Exception
    {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(o1, o2));

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void processFindFormReturnOne() throws Exception
    {
        Owner owner1 = new Owner();
        owner1.setId(1l);
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(owner1));

        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }

    @Test
    void processFindFormEmptyReturnMany() throws Exception
    {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(o1, o2));

        mockMvc.perform(get("/owners")
                .param("lastName", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void displayOwner() throws Exception
    {
        Owner o1 = new Owner();
        o1.setId(1L);
        when(ownerService.findById(anyLong())).thenReturn(o1);
        this.mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1l))));
    }

    @Test
    void initCreationForm() throws Exception
    {
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(ownerService);
    }


    @Test
    void processCreationForm() throws Exception
    {
        when(ownerService.save(ArgumentMatchers.any())).thenReturn(o1);

        mockMvc.perform(post("/owners/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));

        verify(ownerService).save(ArgumentMatchers.any());
    }


    @Test
    void initUpdateOwnerForm() throws Exception
    {
        when(ownerService.findById(anyLong())).thenReturn(o1);

        mockMvc.perform(get("/owners/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(ownerService);
    }


    @Test
    void processUpdateOwnerForm() throws Exception
    {
        when(ownerService.save(ArgumentMatchers.any())).thenReturn(o1);

        mockMvc.perform(post("/owners/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));

        verify(ownerService).save(ArgumentMatchers.any());
    }
}
