package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class guitarHero {
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    public static final String keyboard="q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        int size = keyboard.length();
        GuitarString[] guitarStrings = new GuitarString[size];
        for (int i = 0; i < size; i++) {
            double freq = CONCERT_A * Math.pow(2,(double)(i - 12) / (double) 24);
            guitarStrings[i] = new GuitarString(freq);
            System.out.println(freq + " " + keyboard.charAt(i) + " " + Math.pow(2,(double)(i - 12) / (double) 24));
        }
        while (true) {

            /* check if the user has typed a key; if so, process it */
            int index = 0;
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                index = keyboard.indexOf(key);
                if (index == -1){
                    continue;
                }
                guitarStrings[index].pluck();
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < size; i++) {
                sample += guitarStrings[i].sample();
            }
            System.out.println(sample);
            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < size; i++) {
                guitarStrings[i].tic();
            }
            guitarStrings[index].tic();
        }
    }
}
