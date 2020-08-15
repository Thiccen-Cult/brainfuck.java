import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args){
    int[] base = new int[30000];
    int pointer = 0;
    String fileName = args[0];
    String line = null;
    List<Character> instructions = new ArrayList<>();
    try{
      FileReader filereader = new FileReader(fileName);
      BufferedReader br = new BufferedReader(filereader);
      while((line = br.readLine()) != null){
          for(int i = 0; i < line.length(); i++){
            instructions.add(line.charAt(i));
          }
      }
      br.close();
    } catch(Exception e){}
    List<Integer> charPos = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    for(int i = 0; i < instructions.size(); i++){
      switch(instructions.get(i)){
        case '>': 
            pointer++; break;
        case '<': 
            pointer--; break;
        case '+': 
            base[pointer]++; break;
        case '-': 
            base[pointer]--; break;
        case '[': 
            charPos.add(i); break;
        case ']': 
            if(base[pointer]!=0){
          i=charPos.get(charPos.size()-1);
        }
          else{charPos.remove(charPos.size()-1);}
          break;
        case '.': 
            System.out.print((char)base[pointer]);break;
        case ',': try{
            base[pointer]=(int)(scan.nextLine().charAt(0));
        } catch(Exception e){} break;
      }
    }
  }
}
