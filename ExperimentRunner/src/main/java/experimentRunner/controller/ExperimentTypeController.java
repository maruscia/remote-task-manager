package experimentRunner.controller;

import experimentRunner.entity.ExperimentType;
import experimentRunner.repository.ExperimentTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("experimentType")
public class ExperimentTypeController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ExperimentTypeRepository experimentTypeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<ExperimentType> list() {
        return this.experimentTypeRepository.getListExperimentType();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ExperimentType get(@PathVariable("id") int id) {
        return this.experimentTypeRepository.getExperimentType(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ExperimentType create(@RequestBody @Valid ExperimentType experimentType) {
        return this.experimentTypeRepository.createExperimentType(experimentType);
    }

}
