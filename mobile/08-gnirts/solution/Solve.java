import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*; 

// Flag format: x is lovercase, X is uppercase, 1 is numbers, - is dash, * repetition
// flag = "FLAG{xxx-xxxxxx-XXXXX-11xXx1111*}";

/**
 * TO BRUTE FORCE
 * if (me(dh(gs("xwe", "53P"), ps[0]), "82f5c1c9be89c68344d5c6bcf404c804")
 * 		&& me(dh(gs("asd", ",7Q"), ps[1]), "e86d706732c0578713b5a2eed1e6fb81")
 * 		&& me(dh(gs("uyt", "8=A"), ps[2]), "7ff1301675eb857f345614f9d9e47c89")
 * 		&& me(dh(gs("42s", "yvF"), ps[3]), "b446830c23bf4d49d64a5c753b35df9a")) {
 * 	if (me(dh(gs("70 IJTR", "dxa"), flag), "1b8f972f3aace5cf0107cca2cd4bdb3160293c97a9f1284e5dbc440c2aa7e5a2")) {
 * 		System.out.println("Flag is correct");
 * 	}
 * 	System.out.println("Bad flag value");
 * } else {
 * 	System.out.println("Bad flag section value");
 * }
 */


/**
 * NOTICE:
 * This code is not optimized, it is just a brute force solution to find the flag
 * It was written in the fastest way possible with the use of threads to speed up the process
 * Different number of threads were used for each part of the flag to optimize the process
 * 
 * To compile and run the code:
 * javac Solve.java
 * java Solve
 */


/**
 * After running the code, the flag was found in the following parts:
 * sic
 * parvis
 * MAGNA
 * 28jAn1596
 * 
 * Complete flag: FLAG{sic-parvis-MAGNA-28jAn1596}
 */


public class Solve {

	private static final int NUM_THREADS = 8;
	private static final int NUM_THREADS_FOURTH_PART = 10;

    public static void main(String[] args){
		// Decomment and run the following methods to find the flag

		checkFirstPart(); // Part 1 takes no time

		try {
			solveWithThreads(2); // Part 2 takes no time
			solveWithThreads(3); // Part 3 takes no time
			solveFourthPart(); // Part 4 takes around 30 minutes on my machine
		} catch (InterruptedException | ExecutionException e) {
			System.err.println("Exception: " + e.getMessage());
		}
    }

	private static String checkFirstPart() {
		for (char first = 'a'; first <= 'z'; first++) {
            for (char second = 'a'; second <= 'z'; second++) {
                for (char third = 'a'; third <= 'z'; third++) {
                    String combination = "" + first + second + third;
					if (me(dh(gs("xwe", "53P"), combination), "82f5c1c9be89c68344d5c6bcf404c804")) {
                    	System.out.println(combination);
						return combination;
					}
                }
            }
        }
		return "";
	}

	private static void solveWithThreads(int part) throws InterruptedException, ExecutionException  {
		ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // Split the first character into 8 parts, each handled by a different thread
        List<Callable<String>> tasks = new ArrayList<>();
        
        // Define the range each thread will handle
		if (part == 2) {
			for (int i = 0; i < NUM_THREADS; i++) {
				char startChar = (char) ('a' + (i * 3));  // Starting point for each thread
				char endChar = (i == NUM_THREADS - 1) ? 'z' : (char) ('a' + ((i + 1) * 3) - 1);  // End point for each thread
				tasks.add(() -> checkSecondPart(startChar, endChar));
			}
		}else if (part == 3) {
			for (int i = 0; i < NUM_THREADS; i++) {
				char startChar = (char) ('A' + (i * 3));  // Starting point for each thread
				char endChar = (i == NUM_THREADS - 1) ? 'Z' : (char) ('A' + ((i + 1) * 3) - 1);  // End point for each thread
				
				tasks.add(() -> checkThirdPart(startChar, endChar));
			}
		}

        // Submit the tasks to the executor
        List<Future<String>> results = executor.invokeAll(tasks);

        // Wait for the results
        for (Future<String> result : results) {
            String combination = result.get();
            if (!combination.isEmpty()) {
                System.out.println("Found combination: " + combination);
                break;  // Exit once a valid combination is found
            }
        }

        executor.shutdown();
	}

	private static void solveFourthPart() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS_FOURTH_PART);

		// Split the first character into 8 parts, each handled by a different thread
		List<Callable<String>> tasks = new ArrayList<>();
		
		// Define the range each thread will handle
		for (int i = 0; i < NUM_THREADS_FOURTH_PART; i++) {
			// Directly assign the character '0' to '9' based on the thread index
			char startChar = (char) ('0' + i);  // '0' for i=0, '1' for i=1, ..., '9' for i=9
			tasks.add(() -> checkFourthPart(startChar));  // Add task for this specific digit
		}


		// Submit the tasks to the executor
		List<Future<String>> results = executor.invokeAll(tasks);

		// Wait for the results
		for (Future<String> result : results) {
			String combination = result.get();
			if (!combination.isEmpty()) {
				System.out.println("Found combination: " + combination);
				break;  // Exit once a valid combination is found
			}
		}

		executor.shutdown();
	}

	private static String checkSecondPart(char startChar, char endChar) {
        for (char first = startChar; first <= endChar; first++) {
			for (char second = 'a'; second <= 'z'; second++) {
				for (char third = 'a'; third <= 'z'; third++) {
					for (char fourth = 'a'; fourth <= 'z'; fourth++) {
						for (char fifth = 'a'; fifth <= 'z'; fifth++) {
							for (char sixth = 'a'; sixth <= 'z'; sixth++) {
								String combination = "" + first + second + third + fourth + fifth + sixth;
								if (me(dh(gs("asd", ",7Q"), combination), "e86d706732c0578713b5a2eed1e6fb81")) {
									System.out.println(combination);
									return combination;
								}
							}
						}
					}
				}
			}
		}
		return "";
	}

	private static String checkThirdPart(char startChar, char endChar) {
        for (char first = startChar; first <= endChar; first++) {
			for (char second = 'A'; second <= 'Z'; second++) {
				for (char third = 'A'; third <= 'Z'; third++) {
					for (char fourth = 'A'; fourth <= 'Z'; fourth++) {
						for (char fifth = 'A'; fifth <= 'Z'; fifth++) {
							String combination = "" + first + second + third + fourth + fifth;
							if (me(dh(gs("uyt", "8=A"), combination), "7ff1301675eb857f345614f9d9e47c89")) {
								System.out.println(combination);
								return combination;
							}
						}
					}
				}
			}
		}
		return "";
	}

	// 11xXx1111
	private static String checkFourthPart(char first) {
		System.out.println("Checking fourth part with first char: " + first);
		for (char second = '0'; second <= '9'; second++) {
			for (char third = 'a'; third <= 'z'; third++) {
				for (char fourth = 'A'; fourth <= 'Z'; fourth++) {
					for (char fifth = 'a'; fifth <= 'z'; fifth++) {
						for (char sixth = '0'; sixth <= '9'; sixth++) {
							for (char seventh = '0'; seventh <= '9'; seventh++) {
								for (char eighth = '0'; eighth <= '9'; eighth++) {
									for (char ninth = '0'; ninth <= '9'; ninth++) {
										String combination = "" + first + second + third + fourth + fifth + sixth + seventh + eighth + ninth;
										if (me(dh(gs("42s", "yvF"), combination), "b446830c23bf4d49d64a5c753b35df9a")) {
											System.out.println(combination);
											return combination;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("No combination found for first char: " + first);
		return "";
	}

    private static String dh(String hash, String s) {
        try {
            MessageDigest md = MessageDigest.getInstance(hash);
            md.update(s.getBytes());
            return toHexString(md.digest());
        } catch (Exception e) {
            return null;
        }
    }

    private static String toHexString(byte[] bytes) {
		StringBuilder hexString = new StringBuilder();
		for (byte b : bytes) {
			String hex = Integer.toHexString(b & 0xFF);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}


	private static String gs(String a, String b) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            s.append(Character.toString((char) (a.charAt(i) ^ b.charAt(i % b.length()))));
        }
        return s.toString();
    }

    private static boolean me(String s1, String s2) {
        // System.out.println("s1: " + s1 + " s2: " + s2);
        try {
            return ((Boolean) s1.getClass().getMethod(r("slauqe"), Object.class).invoke(s1, s2)).booleanValue();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return false;
        }
    }

	public static String r(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}
