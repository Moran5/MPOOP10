import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    System.out.println("File");
    File archivo = new File("file.txt");
    System.out.println(archivo.exists());
    if(!archivo.exists()){
      try{
        boolean seCreo = archivo.createNewFile();
        System.out.println(seCreo);
        System.out.println(archivo.exists());
      } catch(IOException e){
        System.out.println(e.getMessage());
      }
    }

    System.out.println("File Writer");
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Esrciba texto");
      String texto = br.readLine();
      String texto2 = "Hola";

      FileWriter fw = new FileWriter("fw.csv");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter salida = new PrintWriter(bw);
      salida.println(texto);
      salida.println(texto2);
      salida.println("Texto linea 3");
      for(int i=0;i<10;i++){
        salida.println("Linea "+i+" del for");
      }
      String[] array = {"a","e","i","o","u"};
      for(int i=0;i<array.length;i++){
        salida.println(array[i]);
      }
      for(int i=0;i<10;i++){
        salida.println("Alejandro,Moran,Duque,318555146,19,45");
      }
      salida.close();
    }catch(IOException e){
        System.out.println(e.getMessage());
      }

    System.out.println("File Reader");
    try{
      FileReader fr = new FileReader("fw.csv");
      BufferedReader br = new BufferedReader(fr);
      String linea = br.readLine();
      while(linea != null){
        System.out.println(linea);
        linea = br.readLine();
      }
      br.close();
    }catch(FileNotFoundException e){
       System.out.println(e.getMessage());
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
    System.out.println("String Tokenizer");

    String linea = "Alejandro,Moran,Duque,318555146,19,45";
    StringTokenizer tokenizador = new StringTokenizer(linea,",");
    int count = 0;
    String nombre = null ,aPaterno= null ,aMaterno = null;
    int numCuenta = 0,edad = 0;
    float creditos = 0;
    while(tokenizador.hasMoreTokens()){
      String temp = tokenizador.nextToken();
      System.out.println(temp);
      if(count == 0)
        nombre=temp;
      else if(count == 1)
        aPaterno = temp;
      else if(count == 2)
        aMaterno = temp;
      else if(count == 3)
        numCuenta = Integer.parseInt(temp);
      else if(count == 4)
        edad = Integer.parseInt(temp);
      else if(count == 5)
        creditos = Float.parseFloat(temp);     
    count++;
    }
    System.out.println("El alumno es:");
    System.out.println(nombre+" "+aPaterno+" "+aMaterno+numCuenta+edad+creditos);
    count = 0;
  }
}