package org.rahimliparviz.linkup.repository;

import org.rahimliparviz.linkup.entity.Profile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends ElasticsearchRepository<Profile,String> {
}
