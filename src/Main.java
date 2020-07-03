import ffmpeg.Sprint;
import ffmpeg.StreamableHsl;
import ffmpeg.Thumbnail;
import model.Media;

public class Main {
    public static void main(String[] args) {

        Media media = new Media();
        media.setName("/home/kennan/Downloads/Insecure.S04E04.INTERNAL.480p.x264-mSD[eztv]");
        media.setDirectory("/home/kennan/Downloads/Insecure.S04E04.INTERNAL.480p.x264-mSD[eztv].mkv");
        media.setOutPut("file output");


        Thread hslGeneratorThread = new Thread(new StreamableHsl(media));
        hslGeneratorThread.start();


        Thread thumbnailGeneratorThread = new Thread(new Thumbnail(media));
        thumbnailGeneratorThread.start();


        Thread sprintGeneratorThread = new Thread(new Sprint(media));
        sprintGeneratorThread.start();


    }
}
