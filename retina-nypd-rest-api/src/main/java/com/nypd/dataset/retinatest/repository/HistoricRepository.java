package com.nypd.dataset.retinatest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nypd.dataset.retinatest.entity.Historic;

@Repository
public interface HistoricRepository extends JpaRepository<Historic, Integer> {
	
	@Query(value="SELECT h.id, h.ky_cd, h.cmplnt_num, COUNT(h.cmplnt_num) AS total_envents FROM Historic h GROUP BY h.ky_cd",
			nativeQuery = true)
	List<?> groupCountByKyCd();
}
