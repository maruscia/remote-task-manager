package experimentRunner.controller;

import experimentRunner.business.ScriptController;
import experimentRunner.entity.ExperimentTask;
import experimentRunner.repository.ExperimentTaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("experimentTask")
public class ExperimentTaskController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ExperimentTaskRepository experimentTaskRepository;

    @RequestMapping(method= RequestMethod.GET)
    public List<ExperimentTask> list() {
        return this.experimentTaskRepository.getListExperimentTask();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ExperimentTask get(@PathVariable("id") int id) {
        return this.experimentTaskRepository.getExperimentTask(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ExperimentTask create(@RequestBody @Valid ExperimentTask experimentTask) {
        log.debug("INSERT with id: " + experimentTask);
        return this.experimentTaskRepository.createExperimentTask(experimentTask);

    }

    @RequestMapping(value="/{id}/_run" , method=RequestMethod.GET)
    public ResponseEntity<Boolean> run (@PathVariable("id") int id) {
        ExperimentTask experimentTask = this.experimentTaskRepository.getExperimentTask(id);

        ScriptController.executeScript(experimentTask);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }


}
