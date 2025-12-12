package Race;

public class Racer implements Runnable
{
	private static int globalId = 1;

	private int id;
	private int speed;
	private Track track;

	public Racer(int speed, Track track)
	{
		if(speed < 1 || speed > 10)
		{
			System.out.println("ERROR: Speed must be between 1-10 !");
			return;
		}

		this.speed = speed;
		this.track = track;

		synchronized (this)
		{
			this.id = globalId++;
		}
	}

	public void go()
	{
		int distance = 0;

		while(distance < 100)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException(e);
			}

			distance += speed;

			if(distance < 100)
				System.out.printf("Runner %d ran %d meters\n", this.id, distance);
		}

		System.out.printf("Runner %d ran 100 meters\n", this.id);

		int place;
		synchronized (this)
		{
			place = ++track.finishedRaces;
		}
		System.out.printf("Runner %d finished %s\n", this.id, getNumSuffix(place));
	}

	public String getNumSuffix(int num)
	{
		if(num == 1)
			return "1st";
		else if(num == 2)
			return "2nd";
		else if(num == 3)
			return "3rd";
		else return (num + "th");
	}

	@Override
	public void run()
	{
		go();
	}
}
