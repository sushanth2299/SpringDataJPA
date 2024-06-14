package com.app.spring_rest;

import com.app.spring_rest.model.JobPost;
import com.app.spring_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobposts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }
    @GetMapping("jobpost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
    @PostMapping("jobpost")
    public void addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);

    }

    @PutMapping("jobpost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @DeleteMapping("jobpost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }
    @GetMapping("load")
    public String loadData(){
        service.load();
        return "success";
    }
    @GetMapping("jobposts/keyword/{keyword}")
    public List<JobPost> search(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }
}
