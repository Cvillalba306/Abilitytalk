import java.util.Scanner;
public class Inc {
    
public static void main(String[]args){
Scanner sc = new Scanner(System.in);

System.out.println("Bienvenido al sistema de test de AbilityTalk");
System.out.println("");
System.out.println("aqui podras seleccionar si gustas hacerle un test auditivo o del habla al niño");
System.out.println("pero primero debe ingresar sus datos principales");
System.out.println("ingrese su nombre:");
String name = sc.nextLine();   

System.out.println("ingrese el nombre del niño:");
String nani = sc.nextLine();

System.out.println("por ultimo, ingrese la edad del niño:");
int edni = sc.nextInt();
if (edni < 3) {
            System.out.println("Lo siento, este test solo está disponible para niños mayores de 3 años");
        } else {
System.out.println("el niño cumple con la edad necesaria para hacer los test");

System.out.println("ahora, seleccione que test quiere hacer: ");
System.out.println("a)test auditivo");
System.out.println("b)test del habla");
String opte = sc.next();

if (opte.equals("a")){
TA.TestAuditivo(name,nani,edni);
}
else if (opte.equals("b")){
    TH.TestHabla(name,nani,edni);
}
else{
    System.out.println("opcion no valida");
}
}
}
}  