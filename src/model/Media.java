package model;

public class Media {
    private String name;
    private String outPut;
    private String directory;

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOutPut(String outPut) {
        this.outPut = outPut;
    }

    public String getName() {
        return this.name;
    }

    public String getOutPut(){
        return this.outPut;
    }

    public String getDirectory(){
        return this.directory;
    }
}
