package com.example.Cadence.controller;


import com.example.Cadence.servicies.ActivityWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadence")
@RequiredArgsConstructor
public class WorkflowWorker {

    private final ActivityWorker activityWorker;

    @PostMapping("/save/{city}")
    public ResponseEntity saveInfo(@PathVariable String city){
        try{
            activityWorker.saveWeatherInfo(city);
            return ResponseEntity.ok("Record saved!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to save record!");
        }
    }


}
