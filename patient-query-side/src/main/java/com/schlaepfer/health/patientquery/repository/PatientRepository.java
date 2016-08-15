package com.schlaepfer.health.patientquery.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unchecked")
@RepositoryRestResource(collectionResourceRel = "patients", path = "patients")
public interface  PatientRepository  extends ReadOnlyPagingAndSortingRepository {

}
