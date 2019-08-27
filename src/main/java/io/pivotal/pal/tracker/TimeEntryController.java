package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {


    @Autowired
    TimeEntryRepository repository;

    public TimeEntryController() {
    }

    public TimeEntryController(TimeEntryRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/time-entries" , method = RequestMethod.POST )
    public ResponseEntity<TimeEntry> create(@RequestBody  TimeEntry entry){

        TimeEntry timeEntry = repository.create(entry);

        return  new ResponseEntity<>(timeEntry, HttpStatus.OK);
    }
    @RequestMapping(value = "/read/{id}" , method = RequestMethod.GET )
    public ResponseEntity<TimeEntry> read(@RequestParam long id){
        TimeEntry timeEntry = repository.find(id);
        return  new ResponseEntity<>(timeEntry, HttpStatus.OK);
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET )
    public ResponseEntity<List<TimeEntry>> list(){
        List<TimeEntry> entries = repository.list();
        return  new ResponseEntity<>(entries, HttpStatus.OK);
    }
    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT )
    public  ResponseEntity update(@RequestParam long id,@RequestBody TimeEntry entry){
        repository.update(id,entry);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE )
    public  ResponseEntity delete(@RequestParam long id){
        repository.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
