package com.cllstarter.repository;

import com.cllstarter.entity.LogTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<LogTable, Long> {
}
