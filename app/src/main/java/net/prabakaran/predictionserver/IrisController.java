package net.prabakaran.predictionserver;

import org.springframework.web.bind.annotation.*;
import net.prabakaran.importkeras.KerasRuntime;
import net.prabakaran.serializers.*;

@RestController
public class IrisController {

    @RequestMapping(value="/predict", method=RequestMethod.POST)
    public Prediction predict(@RequestBody Features features) throws Exception{
        KerasRuntime runtime = new KerasRuntime();
        return new Prediction(runtime.predict(features));
    }
}
