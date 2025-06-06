
package com.pluralsight.ui;

public class AnimationHomeStart {
    private static boolean hasPlayed = false;

    private static final String[] BANNER = {
            """
        ,---,.                              ,----..                 ___                   .--.--.
        ,'  .'  \\                            /   /   \\    ,--,      ,--.'|_                /  /    '.                   ,---,
        ,---.' .' |                           |   :     : ,--.'|      |  | :,'              |  :  /`. /           ,--,  ,---.'|
        |   |  |: |                           .   |  ;. / |  |,       :  : ' :              ;  |  |--`          ,'_ /|  |   | :      .--.--.
        :   :  :  /    ,--.--.          .--,  .   ; /--`  `--'_     .;__,'  /         .--,  |  :  ;_       .--. |  | :  :   : :     /  /    '
        :   |    ;    /       \\       /_ ./|  ;   | ;     ,' ,'|    |  |   |        /_ ./|   \\  \\    `.  ,'_ /| :  . |  :     |,-. |  :  /`./
        |   :     \\  .--.  .-. |   , ' , ' :  |   : |     '  | |    :__,'| :     , ' , ' :    `----.   \\ |  ' | |  . .  |   : '  | |  :  ;_
        |   |   . |   \\__\\/ : .  /___/ \\: |  .   | '___  |  | :      '  : |__ /___/ \\: |    __ \\  \\  | |  | ' |  | |  |   |  / :  \\  \\    `.
        '   :  '; |   ,\" .--.; |   .  \\  ' |  '   ; : .'| '  : |__    |  | '.'|  .  \\  ' |   /  /`--'  / :  | : ;  ; |  '   : |: |   `----.   \\
        |   |  | ;   /  /  ,.  |    \\  ;   :  '   | '/  : |  | '.'|   ;  :    ;   \\  ;   :  '--'.     /  '  :  `--'   \\ |   | '/ :  /  /`--'  /
        |   :   /   ;  :   .'   \\    \\  \\  ;  |   :    /  ;  :    ;   |  ,   /     \\  \\  ;    `--'---'   :  ,      .-./ |   :    | '--'.     /
        |   | ,'    |  ,     .-./     :  \\  \\  \\   \\ .'   |  ,   /     ---`-'       :  \\  \\               `--`----'     /    \\  /    `--'---'
        `----'       `--`---'          \\  ' ;   `---`      ---`-'                    \\  ' ;                             `-'----'
                                         `--`                                          `--`
        """
    };

    private static final String[] SCENE = {
            "                                  _",
            "                                                          //",
            "                                                         //",
            "                                         _______________//__",
            "                                       .(______________//___).",
            "                                       |              /      |",
            "                                       |. . . . . . . / . . .|",
            "                                       \\ . . . . . ./. . . . /",
            "                                        |           / ___   |",
            "                    _.---._             |::......./../...\\.:|",
            "                _.-~       ~-._         |::::/::\\\\::/:\\\\::::::|",
            "            _.-~               ~-._     |::::\\\\::/::::::X:/::|",
            "        _.-~                       ~---.;:::::::/::\\\\::/:::::|",
            "    _.-~                                 ~\\\\::::::n::::::::::|",
            " .-~                                    _.;::/::::a::::::::/",
            " :-._                               _.-~ ./::::::::d:::::::|",
            " `-._~-._                   _..__.-~ _.-~|::/::::::::::::::|",
            "  /  ~-._~-._              / .__..--~----.YWWWWWWWWWWWWWWWP'",
            " \\\\_____(_;-._\\\\        _.-~_/       ~).. . \\\\",
            "    /(_____  \\\\`--...--~_.-~______..-+_______)",
            "  .(_________/`--...--~/    _/           /\\\\",
            " /-._     \\\\_     (___./_..-~__.....__..-~./",
            " `-._~-._   ~\\\\--------~  .-~_..__.-~ _.-~",
            "     ~-._~-._ ~---------'  / .__..--~",
            "         ~-._\\\\.        _.-~_/",
            "             \\\\`--...--~_.-~",
            "              `--...--~"
    };

    public static void play() {
        if (!hasPlayed) {
            clearScreen();
            typePrint(BANNER, 3);
            pause(800);

            for (String line : SCENE) {   // makes sure this only plays once
                System.out.println(line);
            }
            pause(500);

            hasPlayed = true;
        }
    }

    private static void typePrint(String[] lines, int delayMs) {
        for (String line : lines) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                pause(delayMs);
            }
            System.out.println();
        }
    }

    private static void pause(int ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException ignored) { }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
