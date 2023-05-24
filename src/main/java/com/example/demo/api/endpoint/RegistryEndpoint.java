package com.example.demo.api.endpoint;

import com.example.demo.logic.RegistryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registry")
public class RegistryEndpoint {

    private final RegistryService registryService;

    public RegistryEndpoint(RegistryService registryService) {
        this.registryService = registryService;
    }

    @PutMapping("join/{personId}/{addressId}")
    void join(@PathVariable Long personId, @PathVariable Long addressId) {
        registryService.join(personId, addressId);
    }

    @PutMapping("decouple/{personId}/{addressId}")
    void decouple(@PathVariable Long personId, @PathVariable Long addressId) {
        registryService.decouple(personId, addressId);
    }
}
