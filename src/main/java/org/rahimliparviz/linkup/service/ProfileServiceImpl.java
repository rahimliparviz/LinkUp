package org.rahimliparviz.linkup.service;

import lombok.RequiredArgsConstructor;
import org.rahimliparviz.linkup.entity.Profile;
import org.rahimliparviz.linkup.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    final private ProfileRepository profileRepository;
    @Override
    public Iterable<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public void create(Profile profile) {
        profileRepository.save(profile);
    }
}
