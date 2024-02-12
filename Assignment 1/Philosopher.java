import java.util.Random;

class Philosopher extends Thread {
  private Chopstick right, left;
  private Random random;
  private int thoughts;
  private int thinkDuration;
  private int eatDuration;
  private int maxCycles;
  private int philosopherID;
  private int handedness;

  public Philosopher(Chopstick right, Chopstick left, int philosopherID, int thinkDuration, int eatDuration, int maxCycles, int handedness) {
    this.right = right; this.left = left;
    this.thinkDuration = thinkDuration;
    this.eatDuration = eatDuration;
    this.maxCycles = maxCycles;
    this.philosopherID = philosopherID;
    this.handedness = handedness;

    random = new Random();
    if (maxCycles == 0){
      thoughts = -2147483648;
    }
  }

  public void run() {
    try {
      // Philosophers operate differently based on handedness
      if (handedness == 0){
        while (thoughts < maxCycles) {
          ++thoughts;
          if (thoughts % 10 == 0)
            System.out.println("Philosopher " + philosopherID + " has thought " + thoughts + " times");
          int tt = random.nextInt(100);
          System.out.println("Philosopher " + philosopherID + " thinks for " + tt + " units");
          Thread.sleep(tt);     // Think for a while
          System.out.println("Philosopher " + philosopherID + " requests right chopstick");
          synchronized(right) {                    // Acquire right chopstick 
            System.out.println("Philosopher " + philosopherID + " has right chopstick");
            System.out.println("Philosopher " + philosopherID + " requests left chopstick");
            synchronized(left) {
              System.out.println("Philosopher " + philosopherID + " has left chopstick");                 // Acquire left chopstick
              int et = random.nextInt((10));
              System.out.println("Philosopher " + philosopherID + " eats for " + et + " units");
              Thread.sleep(et); // Eat for a while
            }
            System.out.println("Philosopher " + philosopherID + " releases left chopstick");
          }
          System.out.println("Philosopher " + philosopherID + " releases right chopstick");
        }
      }

      // Philosopher handedness logic
      else{
        // Right-handed philosophers
        if (philosopherID % 2 == 0){
          while (thoughts < maxCycles) {
            ++thoughts;
            if (thoughts % 10 == 0)
              System.out.println("Philosopher " + philosopherID + " has thought " + thoughts + " times");
            int tt = random.nextInt(10);
            System.out.println("Philosopher " + philosopherID + " thinks for " + tt + " units");
            Thread.sleep(tt);     // Think for a while
            System.out.println("Philosopher " + philosopherID + " requests right chopstick");
            synchronized(right) {                    // Acquire right chopstick 
              System.out.println("Philosopher " + philosopherID + " has right chopstick");
              System.out.println("Philosopher " + philosopherID + " requests left chopstick");
              synchronized(left) {
                System.out.println("Philosopher " + philosopherID + " has left chopstick");                 // Acquire left chopstick
                int et = random.nextInt((10));
                System.out.println("Philosopher " + philosopherID + " eats for " + et + " units");
                Thread.sleep(et); // Eat for a while
              }
              System.out.println("Philosopher " + philosopherID + " releases left chopstick");
            }
            System.out.println("Philosopher " + philosopherID + " releases right chopstick");
          }
        }
        // Left-handed philosophers
        else if (philosopherID % 2 != 0){
          while (thoughts < maxCycles) {
            ++thoughts;
            if (thoughts % 10 == 0)
              System.out.println("Philosopher " + philosopherID + " has thought " + thoughts + " times");
            int tt = random.nextInt(10);
            System.out.println("Philosopher " + philosopherID + " thinks for " + tt + " units");
            Thread.sleep(tt);     // Think for a while
            System.out.println("Philosopher " + philosopherID + " requests left chopstick");
            synchronized(left) {                    // Acquire left chopstick 
              System.out.println("Philosopher " + philosopherID + " has left chopstick");
              System.out.println("Philosopher " + philosopherID + " requests right chopstick");
              synchronized(right) {
                System.out.println("Philosopher " + philosopherID + " has right chopstick");                 // Acquire right chopstick
                int et = random.nextInt((10));
                System.out.println("Philosopher " + philosopherID + " eats for " + et + " units");
                Thread.sleep(et); // Eat for a while
              }
              System.out.println("Philosopher " + philosopherID + " releases right chopstick");
            }
            System.out.println("Philosopher " + philosopherID + " releases left chopstick");
          }

        }
      }
    } catch(InterruptedException e) {}
  }
}