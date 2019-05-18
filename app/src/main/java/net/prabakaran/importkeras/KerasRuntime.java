package net.prabakaran.importkeras;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.io.ClassPathResource;
import org.nd4j.linalg.api.ndarray.INDArray;
import net.prabakaran.serializers.*;

public class KerasRuntime {

    private final String modelWeights = "model/weights.h5";
    private final MultiLayerNetwork model;

    public KerasRuntime() throws Exception {
        String modelWeightsPath = new ClassPathResource(this.modelWeights).getFile().getPath();
        this.model = KerasModelImport.importKerasSequentialModelAndWeights(modelWeightsPath);
    }

    public float[] predict(Features features){
        INDArray featuresArray = Nd4j.create(features.getFeatures());
        return this.model.output(featuresArray).toFloatVector();
    }
}
