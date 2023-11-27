import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;
public class TH {
    
public static void TestHabla(String name,String nani,int edni){
Scanner sc = new Scanner(System.in);

System.out.println("Bienvenido "+name+" al test del habla!");
System.out.println("");
System.out.println("este test sirve para detectar algun problema o sospecha de algun problema del habla en tu niño "+nani);
System.out.println("!Empezemos!");
System.out.println("");
 try {
            AudioFormat format = new AudioFormat(44100, 16, 2, true, true);

            for (char letra : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                System.out.println("Pronuncie la letra: " + letra);

                waitForEnter(); // este "waitForEnter" es para esperar que el usuario presione Enter para comenzar a grabar

                // Iniciar grabación
                TargetDataLine lineIn = AudioSystem.getTargetDataLine(format);
                lineIn.open(format);
                lineIn.start();

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                // todo esto es el inicio del hilo de grabación
                Thread recordThread = new Thread(() -> {
                    byte[] buffer = new byte[4096];
                    try {
                        while (true) {
                            int bytesRead = lineIn.read(buffer, 0, buffer.length);
                            if (bytesRead > 0) {
                                byteArrayOutputStream.write(buffer, 0, bytesRead);
                            }
                            if (System.in.available() > 0) {
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lineIn.stop();
                        lineIn.close();
                    }
                });

                recordThread.start();

                System.out.println("Presione 1 vez la tecla 'enter' para empezar la grabacion");
                System.out.println("Presione de nuevo la tecla 'enter' para terminar y escuchar la grabacion");
                waitForEnter(); // el "waitForEnter" debe esperar a que el usuario presione Enter para detener la grabación

                // Detener la grabación
                recordThread.join();

                // aqui obtenemos los datos grabados
                byte[] audioData = byteArrayOutputStream.toByteArray();

                // y aqui reproducimos los datos grabados
                playAudio(format, audioData);
            }
            Thread.sleep(100);
            int total = 11; // Número total de iteraciones que tinene la barra
            int progreso = 0; // Variable para el progreso actual

            while (progreso < total) {
                Thread.sleep(500); // Simular una tarea que lleva tiempo (esto solo es decoracion jaja)

                // Actualizar la barra de carga
                System.out.print("\r[");
                for (int i = 0; i < progreso; i++) {
                    System.out.print("-");
                }
                System.out.print("|");
                for (int i = progreso; i < total; i++) {
                }
                System.out.print("] " + (progreso * 10) + "%");

                progreso++; // Incrementacion
            }

            System.out.println("");
            System.out.println("!Has concluido tu test de habla!");
            System.out.println("Pronto te daremos tus resultados");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void waitForEnter() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
     sc.close();
    }
    private static void playAudio(AudioFormat format, byte[] audioData) {
        try {
            SourceDataLine lineOut = AudioSystem.getSourceDataLine(format);
            lineOut.open(format);
            lineOut.start(); //esto inicia la reproducción de audio
            lineOut.write(audioData, 0, audioData.length);
            lineOut.drain();
            lineOut.stop();
            lineOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//autor : cesar villalba sanchez.
  