package org.rahimliparviz.linkup.service.concrete;

import lombok.RequiredArgsConstructor;
import org.rahimliparviz.linkup.entity.Profile;
import org.rahimliparviz.linkup.mapper.ProfileMapper;
import org.rahimliparviz.linkup.model.dto.profile.GetProfileDto;
import org.rahimliparviz.linkup.repository.ProfileRepository;
import org.rahimliparviz.linkup.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    final private ProfileRepository profileRepository;
    @Override
    public List<GetProfileDto> getAll() {
     try {
         List<GetProfileDto> list =
                 StreamSupport.stream(profileRepository.findAll().spliterator(), false)
                         .map(ProfileMapper.INSTANCE::toDto)
                         .collect(Collectors.toList());

         return list;

     } catch (Exception e) {
         throw new RuntimeException(e);
     }
    }

    @Override
    public void create(Profile profile) {
        profileRepository.save(profile);
    }
}
