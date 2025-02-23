package org.rahimliparviz.linkup.controller;

import lombok.RequiredArgsConstructor;
import org.rahimliparviz.linkup.entity.Profile;
import org.rahimliparviz.linkup.model.dto.profile.GetProfileDto;
import org.rahimliparviz.linkup.service.concrete.ProfileServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    final private ProfileServiceImpl profileService;
    @PostMapping
    public ResponseEntity createOrUpdateProfile(@RequestBody Profile profile) {
        profileService.create(profile);
        return ResponseEntity.ok().build();
    }


    // Get All Persons
    @GetMapping
    public ResponseEntity<Iterable<GetProfileDto>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAll());
    }

//    // Delete Person
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePerson(@PathVariable String id) {
//        personService.deletePerson(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // Get Person by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Person>> getPerson(@PathVariable String id) {
//        return ResponseEntity.ok(personService.getPersonById(id));
//    }

}
