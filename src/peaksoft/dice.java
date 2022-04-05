package peaksoft;

public interface dice {

    static void one (){
        System.out.println("""
                +-------+
                |       |
                |   #   |
                |       |
                +-------+
                """);
    }
    static void two (){
        System.out.println("""
                +-------+
                |#      |
                |       |
                |      #|
                +-------+
                """);
    }
    static void three (){
        System.out.println("""
                +-------+
                |#      |
                |   #   |
                |      #|
                +-------+
                """);
    }
    static void four (){
        System.out.println("""
                +-------+
                |#     #|
                |       |
                |#     #|
                +-------+
                """);
    }
    static void five (){
        System.out.println("""
                +-------+
                |#     #|
                |   #   |
                |#     #|
                +-------+
                """);
    }
    static void six (){
        System.out.println("""
                +-------+
                |#  #  #|
                |       |
                |#  #  #|
                +-------+
                """);
    }
}
