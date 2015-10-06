public class SieveOfEratosthenes {

	public static void main(String[] args){
		int max = Integer.valueOf(args[0]);
		boolean[] flags = new boolean[max];
		init(flags);
		int prime = 2;
		
		while(prime <= Math.sqrt(max)){
			crossOff(flags, prime);
			prime = getNextPrime(flags, prime);
			if(prime >= max){
				break;
			}
		}
		
		for(int i=0;i<flags.length;i++){
			if(flags[i]){
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	
	private static void crossOff(boolean[] flags, int prime){
		for(int i=prime*prime;i<flags.length;i+=prime){
			flags[i] = false;
		}
	}
	
	private static int getNextPrime(boolean[] flags, int prime){
		int nextPrime = prime+1;
		while(nextPrime < flags.length && !flags[nextPrime]){
			nextPrime++;
		}
		return nextPrime;
	}
	
	private static void init(boolean[] flags){
		flags[1] = true;
		for(int i=2;i<flags.length;i++){
			flags[i] = true;
		}
	}

}