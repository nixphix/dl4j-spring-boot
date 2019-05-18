package net.prabakaran.serializers;

public class Features {
    private float[][] features;

    public Features(){ }

    public Features(float[][] features){
        this.features = features;
    }

    public float[][] getFeatures() {
        return features;
    }

    public void setFeatures(float[] features){
        if (features.length != 4)
            throw new IllegalArgumentException("Feature length should be 4");
        this.features = new float[1][features.length];
        System.arraycopy(features, 0, this.features[0], 0, features.length);
    }
}
