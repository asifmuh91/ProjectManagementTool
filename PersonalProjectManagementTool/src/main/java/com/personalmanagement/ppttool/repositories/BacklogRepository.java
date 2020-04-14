package com.personalmanagement.ppttool.repositories;

import com.personalmanagement.ppttool.domain.Backlog;
import org.springframework.data.repository.CrudRepository;

public interface BacklogRepository extends CrudRepository<Backlog, Long> {

    Backlog findByProjectIdentifier(String projectIdentifier);

}
