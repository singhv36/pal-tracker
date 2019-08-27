package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {



    TimeEntryRepository timeEntryRepository;


    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody  TimeEntry entry){

        TimeEntry timeEntry = timeEntryRepository.create(entry);

        return  new ResponseEntity<>(timeEntry, HttpStatus.CREATED);
    }
   @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id){
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if(ObjectUtils.isEmpty(timeEntry)){
            return  new ResponseEntity<>(timeEntry, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(timeEntry, HttpStatus.OK);
        }
    }
   @GetMapping
    public ResponseEntity<List<TimeEntry>> list(){
        List<TimeEntry> entries = timeEntryRepository.list();
        return  new ResponseEntity<>(entries, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable long id,@RequestBody TimeEntry entry){
        TimeEntry updateTimeEntry=timeEntryRepository.update(id,entry);
        if(ObjectUtils.isEmpty(updateTimeEntry)){
            return  new ResponseEntity<>(updateTimeEntry, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(updateTimeEntry, HttpStatus.OK);
        }

    }
    @DeleteMapping("{id}")
    public  ResponseEntity delete(@PathVariable long id){
        timeEntryRepository.delete(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
