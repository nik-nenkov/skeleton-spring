package eu.nenkov.skeleton_projects.spring.dao.repository;

import eu.nenkov.skeleton_projects.spring.dao.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
