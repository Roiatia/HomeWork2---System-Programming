package Race;

public class Main {

	public static void main(String[] args){
		Track track = new Track();
		Racer racer1 = new Racer(10, track);
		Racer racer2 = new Racer(2, track);
		Racer racer3 = new Racer(3, track);
		Racer racer4 = new Racer(7, track);
		Thread t1 = new Thread(racer1);
		Thread t2 = new Thread(racer2);
		Thread t3 = new Thread(racer3);
		Thread t4 = new Thread(racer4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
