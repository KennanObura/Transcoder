package ffmpeg;

import ffmpeg.base.Transcoder;
import model.AppMessage;
import model.AppProcess;
import model.Media;

import static model.AppEvent.TERMINATED;
import static model.LogMessageType.*;


public class Thumbnail extends Transcoder {

    public Thumbnail(Media media) {
        super(media);
        super.process = AppProcess.THUMBNAIL;
    }

    @Override
    public void write() {
        this.runCommand();
    }

    private void runCommand() {

        String[] command = {"ffmpeg -i  "
                + this.media.getDirectory()
                + " -an -ss 00:00:05 -r 1 -vframes 1 -y -s 320x240 thumbnail%d.jpg "};

        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            AppMessage message = new AppMessage(this.media, this.process, ERROR);
            message.write(TERMINATED, e.toString());
            throw new RuntimeException(e);
        }
    }
}
