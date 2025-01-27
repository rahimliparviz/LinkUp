package org.rahimliparviz.linkup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.rahimliparviz.linkup.entity.Profile;
import org.rahimliparviz.linkup.model.dto.profile.GetProfileDto;

@Mapper(componentModel = "spring")
public interface ProfileMapper extends GenericMapper<Profile, GetProfileDto> {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);
}

//@Mapper(componentModel = "spring")
//public interface ProfileMapper {
//    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);
//    Profile toEntity(GetProfileDto dto);
//    GetProfileDto toDto(Profile entity);
//}

