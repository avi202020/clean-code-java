package victor.training.cleancode;

import java.util.List;

public class BooleanParameters {
   public static void main(String[] args) {
      // The method is called from various foreign places in the codebase
      bigUglyMethod(1, 5);
      bigUglyMethod(2, 4);
      bigUglyMethod(3, 3);
      bigUglyMethod(4, 2);
      bigUglyMethod(5, 1);

      // TODO From my use-case 23, I call it too, to do more within:
      bigUglyMethodCR23(2, 1);

   }

   static void bigUglyMethod(int b, int a) {
      beforeLogic(b, a);
      afterLogic(b);
   }
   static void bigUglyMethodCR23(int b, int a) {
      beforeLogic(b, a);
      System.out.println("Cod pt usecaseul 23 " + a);
      afterLogic(b);
   }

   private static void beforeLogic(int b, int a) {
      System.out.println("Complex Logic 1 " + a + " and " + b);
      System.out.println("Complex Logic 2 " + a);
      System.out.println("Complex Logic 3 " + a);
   }

   private static void afterLogic(int b) {
      System.out.println("More Complex Logic " + b);
      System.out.println("More Complex Logic " + b);
      System.out.println("More Complex Logic " + b);
   }


   // ============== "BOSS" LEVEL: Deeply nested functions are a lot harder to break down =================

   public void bossLevelStuffFluff(List<Integer> tasks) {
      System.out.println("Logic1");
      System.out.println("Logic2");
      System.out.println("Logic3");
      int j = 0;
      for (int taskRaw : tasks) {
         System.out.println("Logic4: Validate " + taskRaw);
         // un pas in care modific valorile pentru vara
         j++;
         // daca faci modificari doar pe instanta elementului, for-ul urmator le va gasi gata modificate pe toate -- Nu e pb cata vreme forurile nu le interschimbi ordinea
//             ==> .stream.map
         // daca faci modificari in afara elementelor (eg j++), atunci da, ai probleme
//          ==> nu merg cu stream.amp
      }


      for (int taskUpdated : tasks) {
         // TODO When **I** call this method, I want this to run HERE, too:
         System.out.println("My Logic: " + taskUpdated + " cu j="+j);
      }


      int i = 0;
      for (int task : tasks) {
         i++;
         System.out.println("Logic5 " + i + " on " + task);
      }
      System.out.println("Logic6 " + tasks.size());
      System.out.println("Logic7");
   }
   public void bossLevelStuffNoFluff(List<Integer> tasks) {
      System.out.println("Logic1");
      System.out.println("Logic2");
      System.out.println("Logic7 " + tasks);
      System.out.println("Logic7");
   }
   public void bossLevelNoStuff() {
      System.out.println("Logic1");
      System.out.println("Logic7");
   }

}


class Task {

}