package org.rahimliparviz.linkup.service;

import org.rahimliparviz.linkup.entity.Profile;
import org.rahimliparviz.linkup.model.dto.profile.GetProfileDto;

import java.util.List;

public interface ProfileService {
    List<GetProfileDto> getAll();
    void create(Profile profile);
}
