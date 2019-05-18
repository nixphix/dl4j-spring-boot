package net.prabakaran.serializers;

public class Prediction {

    private ConfidenceScore confidenceScore;
    private String result;

    public Prediction() { }

    public Prediction(float[] result){
        this.confidenceScore = new ConfidenceScore(result);
        this.result = this.confidenceScore.getResult();
    }

    public ConfidenceScore getConfidenceScore() {
        return confidenceScore;
    }

    public String getResult() {
        return result;
    }

    public class ConfidenceScore {

        private float setosa, versicolor, virginica;

        public ConfidenceScore(){
        }

        public ConfidenceScore(float[] result){
            this.setosa = result[0];
            this.versicolor = result[1];
            this.virginica = result[2];
        }

        protected String getResult(){
            if (this.setosa > this.versicolor && this.setosa > this.virginica){
                return "Setosa";
            }
            else if (this.versicolor > this.virginica){
                return "Versicolor";
            }
            else {
                return "Virginica";
            }
        }

        public float getSetosa() {
            return setosa;
        }

        public float getVersicolor() {
            return versicolor;
        }

        public float getVirginica() {
            return virginica;
        }
    }
}
