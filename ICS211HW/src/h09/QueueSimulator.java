package h09;

/*Author Tanner Berry
 * HW09 ICS 211
 */
import java.util.Random;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class QueueSimulator {
	@SuppressWarnings("rawtypes")
	private class Customer implements Comparable {
		int arrivalTime;
		int serviceTime;

		public Customer() {
			Random rand = new Random();
			arrivalTime = rand.nextInt(86101);
			serviceTime = 30 + rand.nextInt(271);
		}

		public int compareTo(Object obj) {
			Customer cust = (Customer) obj;
			return this.arrivalTime - cust.arrivalTime;
		}
	}
	
	

	private class Server {
		int finishTime;
		public Server() {
			finishTime = 0;
		}
		public boolean isIdle(int currentTime) {
			return currentTime >= finishTime;
		}
	}

	private boolean isSorted(Customer[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].arrivalTime > array[i + 1].arrivalTime) {
				return false;
			}
		}
		return true;
	}

	private int shortestQueueIndex(@SuppressWarnings("rawtypes") Queue[] queues) {
		int minIndex = 0;
		for (int i = 1; i < queues.length; i++) {
			if (queues[i].size() < queues[minIndex].size()) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	@SuppressWarnings("unchecked")
	public int simulator(boolean singleQueue, int numCustomers) {

		Customer[] customers = new Customer[numCustomers];
		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer();
		}
		Arrays.sort(customers);
		System.out.println("customers array sorted? " + isSorted(customers));
		Server[] servers = new Server[10];
		for (int i = 0; i < servers.length; i++) {
			servers[i] = new Server();
		}
		Queue<Customer>[] queues;
		if (singleQueue) {
			queues = new LinkedList[1];
			queues[0] = new LinkedList<Customer>();
		} else {
			queues = new LinkedList[10];
			for (int i = 0; i < queues.length; i++) {
				queues[i] = new LinkedList<Customer>();
			}
		}
		for (int i = 0; i < queues.length; i++) {
			queues[i] = new LinkedList<Customer>();
		}
		int totalWaitingTime = 0;
		int custIndex = 0; // keep track of customers being added to queue(s) and servers
		for (int currentTime = 0; currentTime < 86400; currentTime++) {
			// While loop to add customers into queue(s)
			while (custIndex < customers.length && customers[custIndex].arrivalTime == currentTime) {
				Customer cust = customers[custIndex];
				int shortestQueueIndex = shortestQueueIndex(queues);
				queues[shortestQueueIndex].offer(cust);
				custIndex++;
			}
			// Have Server add a new customer if finished with the current customer
			for (int i = 0; i < servers.length; i++) {
				if (servers[i].isIdle(currentTime)) {
					if (singleQueue) {
						if (!queues[0].isEmpty()) {
							Customer cust = queues[0].poll();
							int waitingTime = currentTime - cust.arrivalTime;
							totalWaitingTime += waitingTime;
							servers[i].finishTime = currentTime + cust.serviceTime;
						}
					} else {
						int shortestQueueIndex = shortestQueueIndex(queues);
						while (!queues[shortestQueueIndex].isEmpty()) {
							Customer cust = queues[shortestQueueIndex].peek();
							if (cust.arrivalTime <= currentTime) {
								queues[shortestQueueIndex].poll();
								int waitingTime = currentTime - cust.arrivalTime;
								totalWaitingTime += waitingTime;
								servers[i].finishTime = currentTime + cust.serviceTime;
								break;
								// put in code for multiple queues
							} else {
								// If the customer in the front of the queue hasn't arrived yet,
								// move on to the next shortest queue.
								shortestQueueIndex = (shortestQueueIndex + 1) % queues.length;
							}
						}
					}
				}
			}
		}
		return totalWaitingTime;
	}
	public static void main(String[] args) {
		int numCustomers = 5000;
		QueueSimulator qSim = new QueueSimulator();
		int singleQueueTime = qSim.simulator(true, numCustomers);
		int multipleQueueTime = qSim.simulator(false, numCustomers);
		System.out.println("singleQueueTime is " + singleQueueTime);
		System.out.println("multipleQueueTime is " + multipleQueueTime);
	}
}