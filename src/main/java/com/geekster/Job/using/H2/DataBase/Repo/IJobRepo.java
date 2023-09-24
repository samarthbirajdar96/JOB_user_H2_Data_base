package com.geekster.Job.using.H2.DataBase.Repo;

import com.geekster.Job.using.H2.DataBase.Model.Job;
import com.geekster.Job.using.H2.DataBase.Model.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository <Job,Integer> {

    List<Job> findByJobTypeAndJobSalaryLessThanEqual(Type type, double salary);


    List<Job> findByJobTypeAndJobLocation(Type type, String location);

@Modifying
@Query(value = "UPDATE JOB SET JOB_SALARY=(JOB_SALARY+JOB_SALARY*(:hike)) WHERE JOB_TYPE=:type",nativeQuery = true)
    void updatejobbytype(float hike, String type);



@Modifying
@Query(value ="DELETE FROM JOB WHERE JOB_TYPE=:type" ,nativeQuery = true)
    void removejobbytype(String type);

}
