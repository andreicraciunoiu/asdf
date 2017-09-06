package com.dbtechschool.controller;

import com.dbtechschool.model.DatesContainer;
import com.dbtechschool.model.Section;
import com.dbtechschool.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nicoleta on 8/20/2017.
 */
@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @RequestMapping(value = "/section", method = RequestMethod.GET)
    public List<Section> getAll() {
        return sectionService.findAllSections();
    }

    @RequestMapping(value = "/section/{id}", method = RequestMethod.GET)
    public Section getById(@PathVariable(value = "id") Long id) {
        return sectionService.getById(id);
    }

    @RequestMapping(value = "/sections/day/{dayid}", method = RequestMethod.POST)
    public List<Section> getByDay(@PathVariable(value = "dayid") Long dayid) {
        return ((List<Section>) sectionService.getByDay(dayid));
    }
    
    @RequestMapping(value = "/sections/hours", method = RequestMethod.DELETE)
	public List<DatesContainer> getSectionsHours() {
		return sectionService.getSectionsHours();
	}
    
    @RequestMapping(value = "/section/hours/{id}", method = RequestMethod.GET)
	public List<String> getDatesById(@PathVariable(value = "id") Long id) {
		return sectionService.getHoursBySectionId(id);
	}

    @RequestMapping(value = "/section/{id}", method = RequestMethod.PUT)
    public void deleteById(@PathVariable(value = "id") Long id) {
        sectionService.deleteById(id);
    }

    @RequestMapping(value = "/clear/sections", method = RequestMethod.DELETE)
    public void deleteAll() {
        sectionService.removeAll();
    }

    @RequestMapping(value = "/section", method = RequestMethod.POST)
    public void insertUser(@RequestBody Section s) {
        sectionService.insertSection(s);

    }

    @RequestMapping(value = "/section/{id}", method = RequestMethod.PUT)
    public void updatetSection(@RequestBody Section s, @PathVariable(value = "id") Long id) {
        sectionService.updateSectionById(s.getName(), s.getStart(), s.getEnd(), s.getRoom(), s.getTrainer(),
                s.getDescription(), s.getRatingAvg(), s.getDay(), id);
    }
}
