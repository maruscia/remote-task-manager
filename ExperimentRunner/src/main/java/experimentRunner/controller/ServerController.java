package experimentRunner.controller;

import experimentRunner.entity.Server;
import experimentRunner.repository.ServerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("servers")
public class ServerController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ServerRepository  serverRepository;

    @RequestMapping(method=RequestMethod.GET)
    public List<Server> list() {
        return this.serverRepository.getListServer();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Server get(@PathVariable("id") int id) {
         return this.serverRepository.getServer(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Server create(@RequestBody @Valid Server server) {
        log.debug("INSERT with id: " + server);
        return this.serverRepository.createServer(server);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public Server update(@PathVariable("id") long id, @RequestBody @Valid Server server) {
        return this.serverRepository.updateServer(server);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        this.serverRepository.deleteServer(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
