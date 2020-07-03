package ffmpeg.base;

import model.LogMessageType;

public interface TranscoderInterface {

    public void write();

    public boolean createDirectory(String directory);

}
