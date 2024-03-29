package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry entry);
    public TimeEntry find(long id);
    public List<TimeEntry> list();
    public  TimeEntry update(long id,TimeEntry entry);
    public  void delete(long id);

}
