package com.epsilonnet.restapi.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.epsilonnet.restapi.dao.entity.Realm;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "https://epsilon-net.com"}) // Allow requests from your frontend
@RepositoryRestResource(path = "realms") // Exposes endpoints at /realms
public interface RealmRepository extends JpaRepository<Realm, Long> {
    // Method to find Realm by name "default"
    Optional<Realm> findByName(String name);

    // Or if you want a more specific method name
    default Optional<Realm> findDefaultRealm() {
        return findByName("default");
    }
}
