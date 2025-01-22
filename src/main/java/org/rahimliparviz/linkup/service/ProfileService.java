package org.rahimliparviz.linkup.service;

import org.rahimliparviz.linkup.entity.Profile;

import java.util.List;

public interface ProfileService {
    Iterable<Profile> getAll();
    void create(Profile profile);
}
