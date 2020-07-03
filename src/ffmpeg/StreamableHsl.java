package ffmpeg;

import ffmpeg.base.Transcoder;
import model.AppEvent;
import model.AppMessage;
import model.AppProcess;
import model.Media;

import static model.AppEvent.TERMINATED;
import static model.LogMessageType.ERROR;


public class StreamableHsl  extends Transcoder {
    public StreamableHsl(Media media) {
        super(media);
        super.process = AppProcess.STREAMABLEHSL;
    }

    @Override
    public void write() {
        this.runCommand();
    }

    private void runCommand() {
        String[] cmd = {"C:\\ffmpeg\\bin\\ffmpeg", "-i", "concat:C:\\journalism\\videos\\vid1.ts|C:\\journalism\\videos\\vid2.ts", "-c", "copy", "C:\\journalism\\videos\\output.mp4"};
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (Exception e) {
            AppMessage message = new AppMessage(this.media, this.process, ERROR);
            message.write(TERMINATED, e.toString());
            throw new RuntimeException(e);
        }
    }

}
