import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class TA{

public static void TestAuditivo(String name,String nani,int edni){
    Scanner sc = new Scanner(System.in);
    int punt = 0;
  
try{
 System.out.println("bienvenido al test auditivo de AbilityTalk");
 Thread.sleep(1000);
            System.out.println("a continuacion, pondremos algunos audios y sonidos para identificar si "+nani+" tiene problemas auditivos");
            Thread.sleep(2000); 
            System.out.println("recomendamos que por cada audio vaya disminuyendo gradualmente el volumen, asi se conseguira un mejor resultado");
            Thread.sleep(2000);
            System.out.println("Por favor, realice las siguientes preguntas al niño y registre sus respuestas:"); 
Thread.sleep(1000);
 System.out.println("escucha con atencion!");
 Thread.sleep(1000);
 Sonido("welAT.wav");
 try {
     Thread.sleep(3000);
 } catch (InterruptedException e) {
     e.printStackTrace();
 }
 Thread.sleep(1000);
 System.out.println("¿escuchaste el sonido?");
 System.out.println("a.-si");
 System.out.println("b.-un poco");
 System.out.println("c.-no");
 String Res1 =sc.next();
 if (Res1.equals("a")){
    punt += 2;
 }
 else if(Res1.equals("b")){
    punt +=1;
 }
 else if(Res1.equals("c")){
    punt +=0;
 }
 else{
    System.out.println("opcion no valida");
 }
Thread.sleep(100); 

 System.out.println("!vamos de nuevo!");
Thread.sleep(1000);
 Sonido("welAT.wav");
  try {
      Thread.sleep(3000);
  } catch (InterruptedException e) {
      e.printStackTrace();
  }
  Thread.sleep(1000);
 System.out.println("¿escuchaste el sonido?");
 System.out.println("a.-si");
 System.out.println("b.-un poco");
 System.out.println("c.-no");
 String Res2 =sc.next();
 if (Res2.equals("a")){
    punt += 2;
 }
 else if (Res2.equals("b")){
  punt +=1;
 } 
 else if (Res2.equals("c")){
    punt +=0;
 }
 else{
    System.out.println("opcion no valida");
 }
 Thread.sleep(100); 
 System.out.println("!vamos de nuevo!");
 Thread.sleep(1000);
 Sonido("welAT.wav");
  try {
      Thread.sleep(3000);
  } catch (InterruptedException e) {
      e.printStackTrace();
  }
Thread.sleep(1000);
  System.out.println("¿escuchaste el sonido?");
System.out.println("a.-si");
System.out.println("b.-un poco");
System.out.println("c.-no");
String Res3 =sc.next();
if (Res3.equals("a")){
    punt +=2;
}
else if(Res3.equals("b")){
    punt +=1;
}
else if (Res3.equals("c")){
    punt +=0;
}
else{
    System.out.println("opcion no valida");
}
Thread.sleep(100); 
System.out.println("!vamos de nuevo!");
Thread.sleep(1000); 
Sonido("welAT.wav");
 try {
     Thread.sleep(3000);
 } catch (InterruptedException e) {
     e.printStackTrace();
 }
Thread.sleep(1000);
 System.out.println("¿escuchaste el sonido?");
System.out.println("a.-si");
System.out.println("b.-un poco");
System.out.println("c.-no");
String Res4 =sc.next();
if (Res4.equals("a")){
    punt+=2;
}
else if (Res4.equals("b")){
    punt+=1;
}
else if (Res4.equals("c")){
    punt += 0;
}
else{
    System.out.println("opcion no valida");
}

Thread.sleep(100); 
System.out.println("!vamos por ultima vez!");
Thread.sleep(1000); 
Sonido("welAT.wav");
 try {
     Thread.sleep(3000);
 } catch (InterruptedException e) {
     e.printStackTrace();
 }
Thread.sleep(1000); 
 System.out.println("¿escuchaste el sonido?");
System.out.println("a.-si");
System.out.println("b.-un poco");
System.out.println("c.-no");
String Res5 =sc.next();
if (Res5.equals("a")){
    punt+=2;
}
else if(Res5.equals("b")){
    punt+= 1;
}  
else if(Res5.equals("c")){
    punt+=0;
}
else{
    System.out.println("opcion no valida");
}

Thread.sleep(100); 
int total = 10; // Número total de iteraciones que tinene la barra
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
                System.out.print(" ");
            }
            System.out.print("] " + (progreso * 10) + "%");

            progreso++; // Incrementacion
        }

        System.out.println(); // Salto de línea
        System.out.println("¡Proceso completado!");

System.out.println("El puntaje final de "+nani+" es: "+punt);
if(punt >= 6){

System.out.println("Felicitaciones "+name+" su hijo "+nani+" tiene una capacidad auditiva !excelente!");
}
else{
    System.out.println("lo lamento "+name+" pero puede que su hijo "+nani+" tenga problemas auditivos, por favor, debe consultar con un especialista");
}
 

}catch(InterruptedException e){
    e.printStackTrace();
}
 sc.close();
}
public static void Sonido(String nombreSonido) {
    try {
        // esto Carga el archivo de sonido
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("D:\\sonidos\\" + nombreSonido));

        // esto crea un objeto Clip para reproducir el sonido
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        // esto reproduce el sonido
        clip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        //IMPORTANTE esto maneja cualquier excepción que pueda ocurrir al cargar o reproducir el sonido
        e.printStackTrace();
    }
}
}
/*autor: cesar villalba sanchez.
 nota: solo puse notas en las partes finales del codigo pq es lo que mas se me dificulto a la hora de hacer el codigo, espero que todo este bien, tal vez sea una manera algo obsoleta pero sirve, 
 pendientes y mejoras: 
  -implementar la graduacion de sonido por cada intento.
  -implementar mas "animaciones de carga"
*/