package experimentRunner.business;

import experimentRunner.entity.ExperimentTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class ScriptController {



    protected final Logger log = LoggerFactory.getLogger(getClass());



    public static void executeScript(ExperimentTask experimentTask){

        // -d Dataset -t type -i ip -a la -p lp -c core
        String param =  " -d " + experimentTask.getExperimentType_dataset() +
                        " -t " + experimentTask.getExperimentType_type() +
                        " -i " + experimentTask.getServer_ip() +
                        " -a " + experimentTask.getExperimentType_la() +
                        " -p " + experimentTask.getExperimentType_lp() +
                        " -c " + experimentTask.getCore_assigned();
        String path="./scripts/deploy_experiment_task "  + param ;
        Runtime rn = Runtime.getRuntime();
        try {
            Process pr= rn.exec(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
