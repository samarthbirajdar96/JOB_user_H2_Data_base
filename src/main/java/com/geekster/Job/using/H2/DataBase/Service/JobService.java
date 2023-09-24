package com.geekster.Job.using.H2.DataBase.Service;

import com.geekster.Job.using.H2.DataBase.Model.Job;
import com.geekster.Job.using.H2.DataBase.Model.Type;
import com.geekster.Job.using.H2.DataBase.Repo.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {

    @Autowired
    IJobRepo iJobRepo;

    public String addjobs(List<Job> job) {
        iJobRepo .saveAll(job);
        return "added";
    }

    public List<Job> getalljob() {
        return(List<Job>) iJobRepo.findAll();
    }

    public String removebyid(Integer id) {
         iJobRepo.deleteById(id);
         return "deleted";
    }

    public String updatejobbyid(Integer id, String jobtitle) {
        Job job = iJobRepo.findById(id).orElse(null);
        if (job != null) {
            job.setJobTitle(jobtitle);
            iJobRepo.save(job);
            return "updated";
        } else {
            return "id not found";
        }

    }

    public List<Job> getjobsbytypelessthanequalsalary(Type type, double salary) {
       return iJobRepo.findByJobTypeAndJobSalaryLessThanEqual(type,salary);
    }


    public List<Job> getjobsbytypelocation(Type type, String location) {
        return iJobRepo.findByJobTypeAndJobLocation(type,location);
    }

@Transactional
    public String updatejobbytype(float hike, Type type) {
         iJobRepo.updatejobbytype(hike,type.name());
        return "updated";
    }


    @Transactional
    public String removejobbytype(Type type) {
        iJobRepo.removejobbytype(type.name());
        return "deleted";
    }
}
