package ffmpeg;

import ffmpeg.base.Transcoder;
import model.AppProcess;
import model.Media;


public class Sprint extends Transcoder {


    public Sprint(Media media){
        super(media);
        super.process = AppProcess.SPRINT;
    }

    @Override
    public void write() {
        for (int i = 0; i < 5 ; i++)
            System.out.println(i + " :" + this.process);
    }

}
