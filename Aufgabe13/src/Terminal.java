/*******************************************************************************
 *   für diverse Übungen : globale Hilfsfunktionen für die Tastatur-Eingabe    *
 ******************************************************************************* 
 *               Java 1.4.1     2005-02-16     Version 1                       *
 *******************************************************************************/

import java.io.*;

public class Terminal{
  
  public static float readFloat(){
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    String eingabe = null;
    try {eingabe = console.readLine();} catch(IOException e){}
    return (new Float(eingabe).floatValue());
  }
      
  public static int readInt(){
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    String eingabe = null;
    try {eingabe = console.readLine();} catch(IOException e){}
    return (new Integer(eingabe).intValue());
  }
      
  public static String readString(){
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    String eingabe = null;
    try {eingabe = console.readLine();} catch(IOException e){}
    return (eingabe);
  }
      
  public static boolean readBool(){
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    String r = null;
    try {r = console.readLine();} catch(IOException e){}
    if ("jJtT1".indexOf(r)>=0){  // indexOf() ist Member von String
      return true;}
    else{
      return false;
    }
  } 
}