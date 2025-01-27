package org.rahimliparviz.linkup.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericMapper<E, D> {
    E toEntity(D dto);
    D toDto(E entity);

    default List<E> toEntityList(List<D> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    default List<D> toDTOList(List<E> entityList) {
        return entityList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
