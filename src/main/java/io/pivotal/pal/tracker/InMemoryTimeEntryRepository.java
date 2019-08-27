package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{



    Map<Long , TimeEntry> entryMap = new HashMap<Long, TimeEntry>();

    @Override
    public TimeEntry create(TimeEntry entry) {
        entryMap.put(entry.getId(), entry);
        return entry;
    }

    @Override
    public TimeEntry find(long id) {
        TimeEntry entry = entryMap.get(id);
        return entry;
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> entries = new ArrayList<>();
        Set<Long> keySet = entryMap.keySet();
        for(Long key : keySet){
            entries.add(entryMap.get(key));
        }
        return entries;
    }

    @Override
    public TimeEntry update(long id, TimeEntry entry) {
        entryMap.put(id, entry);
        return entryMap.get(id);
    }

    @Override
    public void delete(long id) {
        entryMap.remove(id);
    }
}
