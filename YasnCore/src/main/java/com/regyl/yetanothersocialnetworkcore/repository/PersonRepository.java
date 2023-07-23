package com.regyl.yetanothersocialnetworkcore.repository;

import com.regyl.yetanothersocialnetworkcore.model.Person;
import com.regyl.yetanothersocialnetworkcore.model.enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends AbstractRepository<Person> {

    @Query("select count(id) from Person where isRussian = true and birthPlace is not null and livePlace is not null and birthPlace <> livePlace")
    Long countRussianRelocated();

    Long countByIsRussianTrue();

    Long countByIsRussianTrueAndGender(Gender gender);
}
