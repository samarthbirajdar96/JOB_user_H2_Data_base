package com.geekster.Job.using.H2.DataBase.Controller;

import com.geekster.Job.using.H2.DataBase.Model.Job;
import com.geekster.Job.using.H2.DataBase.Model.Type;
import com.geekster.Job.using.H2.DataBase.Service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class JobController {


    @Autowired
    JobService jobService;

    @PostMapping("jobs")
    public String addjobs(@RequestBody List<Job> job) {
        return jobService.addjobs(job);
    }

    @GetMapping("jobs")
    public List<Job> getalljob(){
        return jobService.getalljob();
    }
   @DeleteMapping("job/id/{id}")
    public String  removebyid(@PathVariable Integer id){
        return jobService.removebyid(id);
}
     @PutMapping("jobs/id/{id}")
    public String updatejobbyid(@PathVariable Integer id,@RequestParam String jobtitle){
        return jobService.updatejobbyid(id,jobtitle);
 }

    @GetMapping("jobs/type/{type}/salary/lessOrEqual/{salary}")
    public List<Job> getjobsbytypelessthanequalsalary(@PathVariable Type type , @PathVariable @Valid double salary){
        return jobService.getjobsbytypelessthanequalsalary(type,salary);
 }

    @GetMapping("jobs/type/{type}/location/{location}")
    public List<Job> getjobsbytypelocation(@PathVariable Type type , @PathVariable  String location){
        return jobService.getjobsbytypelocation(type,location);
    }

 @PutMapping("jobs/salary/type")
    public String updatejobbytype(@RequestParam float hike,@RequestParam Type type){
        return jobService.updatejobbytype(hike,type);
 }

    @DeleteMapping ("jobs/type")
    public String removejobbytype(@RequestParam Type type){
        return jobService.removejobbytype(type);
    }

}
