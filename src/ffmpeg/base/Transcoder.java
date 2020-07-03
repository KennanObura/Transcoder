package ffmpeg.base;

import model.AppMessage;
import model.AppProcess;
import model.Media;
import util.OSValidator;

import java.io.File;

import static model.AppEvent.INITIALIZING;
import static model.LogMessageType.INFO;



public abstract class Transcoder implements TranscoderInterface, Runnable {
    public Transcoder(Media media) {
        this.media = media;
        this.file = new File(this.media.getName());
    }

    public Media media;
    public File file;
    public AppProcess process;

    @Override
    abstract public void write();

    @Override
    public void run() {
        AppMessage message = new AppMessage(
                this.media,
                this.process,
                INFO);

        message.write(INITIALIZING);
        this.write();
    }

    @Override
    public boolean createDirectory(String directory) {
        return new File(directory).mkdirs();
    }


    /**
     * @return String name of the OS environment
     */
    public String getCurrentEnvironment() {
        return OSValidator.getOperatingSystemEnvironment();
    }
}
