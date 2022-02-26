import java.util.Scanner;

public class BrainfuckInterpreter {

	public String runCode(String codeIn) {
		Scanner sc = new Scanner(System.in);
		String output = " ";
		int[] memoryArray = new int[255];
		int currentMem = 0;
		char[] codeArray = codeIn.toCharArray();

		// Check Code for errors
		for (long i = 0; i < codeArray.length; i++) {
			if (codeArray[(int) i] != '<' && codeArray[(int) i] != '>' && codeArray[(int) i] != '+'
					&& codeArray[(int) i] != '-' && codeArray[(int) i] != '[' && codeArray[(int) i] != ']'
					&& codeArray[(int) i] != '.' && codeArray[(int) i] != '^' && codeArray[(int) i] != ',') {
				Long y = i + 1;
				output = "Error. An invalid character was entered at character " + Long.toString(y);
			}
		}

		for (long i = 0; i < codeArray.length; i++) {
			if (codeArray[(int) i] == '+') {
				memoryArray[currentMem] = memoryArray[currentMem] + 1;
				System.out.println(
						memoryArray[currentMem] + " is the new Memory Value of memoryArray at position " + currentMem);
			}
			if (codeArray[(int) i] == '-') {
				memoryArray[currentMem] = memoryArray[currentMem] - 1;
				System.out.println(
						memoryArray[currentMem] + " is the new Memory Value of memoryArray at position " + currentMem);
			}
			if (codeArray[(int) i] == '<') {
				if (currentMem == 0) {
					currentMem = 254;
				} else {
					currentMem--;
				}
				System.out.println("The new Memory Location is " + currentMem);
			}
			if (codeArray[(int) i] == '>') {
				if (currentMem == 254) {
					currentMem = 0;
				} else {
					currentMem++;
				}
				System.out.println("The new Memory Location is " + currentMem);
			}
			if (codeArray[(int) i] == '.') {
				System.out.println("Adding char at memory location " + currentMem + " to output.");
				System.out.println(memoryArray[currentMem]);
				output = output + (char) memoryArray[currentMem];
			}
			if (codeArray[(int) i] == ',') {
				System.out.println("Please enter the character you wish to input");
				String input = sc.next();
				char in = input.charAt(0);
				System.out.println(
						"Setting memory location " + currentMem + " to the ASCII value of the charater entered.");
				memoryArray[currentMem] = (int) in;
			}

			if (codeArray[(int) i] == '[') {
				System.out.println("Loop has started at character " + (i + 1));
				int loopCount = currentMem;
				System.out.println("The loop counter is located at memoryAddress " + loopCount + " and has the value "
						+ memoryArray[loopCount]);
				int loopStart = (int) i;
				Long loopEnd = (long) 0;
				boolean found = false;
				boolean end = false;
				int curChar = (int) i;
				while (found == false || end == false) {
					System.out.println(codeArray[curChar]);
					curChar++;
					if (codeArray[curChar] == ']') {
						loopEnd = (long) curChar;
						found = true;
					} else if (curChar == codeArray.length - 1) {
						end = true;
					}

				}
				System.out.println(found);
				if (found) {
					System.out.println("memoryArray[loopcount] equals" + memoryArray[loopCount]);

					for (int x = memoryArray[loopCount]; x > 0; x--) {// loops the instructions contained in the loop
																		// specified before

						System.out.println("The following code will loop " + memoryArray[loopCount]
								+ " times the instructions from char " + loopStart + " to " + loopEnd);

						for (int counter = loopStart; counter < loopEnd - 1; counter++) {
							if (codeArray[counter] == '+') {
								memoryArray[currentMem] = memoryArray[currentMem] + 1;
								System.out.println(memoryArray[currentMem]
										+ " is the new Memory Value of memoryArray at position " + currentMem);
							}
							if (codeArray[counter] == '-') {
								memoryArray[currentMem] = memoryArray[currentMem] - 1;
								System.out.println(memoryArray[currentMem]
										+ " is the new Memory Value of memoryArray at position " + currentMem);
							}
							if (codeArray[counter] == '<') {
								if (currentMem == 0) {
									currentMem = 254;
								} else {
									currentMem--;
								}
								System.out.println("The new Memory Location is " + currentMem);
							}
							if (codeArray[(int) i] == ',') {
								System.out.println("Please enter the character you wish to input");
								String input = sc.next();
								char in = input.charAt(0);
								System.out.println("Setting memory location " + currentMem
										+ " to the ASCII value of the charater entered.");
								memoryArray[currentMem] = (int) in;
							}
							if (codeArray[counter] == '>') {
								if (currentMem == 254) {
									currentMem = 0;
								} else {
									currentMem++;
								}
								System.out.println("The new Memory Location is " + currentMem);
							}
							if (codeArray[counter] == '.') {
								System.out.println("Adding char at memory location " + currentMem + " to output.");
								System.out.println(memoryArray[currentMem]);
								output = output + (char) memoryArray[currentMem];
							}
							System.out.println("The amount of loops to still be done is " + memoryArray[loopCount]);
						}

					}
					i = loopEnd;
					System.out.println("The loop has ended");
				}
			}

		}

		return output;
	}
}