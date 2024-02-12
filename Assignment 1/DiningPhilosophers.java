public class DiningPhilosophers {

  public static void main(String[] args) throws InterruptedException {

    // Acquire necessary arguments

    int numPhilosophers = Integer.parseInt(args[0]);
    int numChopsticks = Integer.parseInt(args[1]);
    int thinkTime = Integer.parseInt(args[2]);
    int eatTime = Integer.parseInt(args[3]);
    int maxCycles = Integer.parseInt(args[4]);

    Philosopher[] philosophers = new Philosopher[numPhilosophers];
    Chopstick[] chopsticks = new Chopstick[numPhilosophers];
    
    for (int i = 0; i < numPhilosophers; ++i)
      chopsticks[i] = new Chopstick(i);
    for (int i = 0; i < numPhilosophers; ++i) {
      philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % numPhilosophers], i ,thinkTime, eatTime, numChopsticks, maxCycles);
      philosophers[i].start();
    }
    for (int i = 0; i < numPhilosophers; ++i)
      philosophers[i].join();
  }
}