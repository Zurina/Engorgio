# Letter frequencies
Simple program used to illustrate performance problems. You should be able to optimize this program to run about twice as fast.

## Code performance

*Documentation of the current performance of the program, including why you believe your performance measurements are free of errors:*

We went with using the Mark 2 performance measurement technique, landing on 200 iterations with stable results. All test was performed on the same machine without altering workloads. Same amount of iterations were run for the first state of the program and the performance optimized state of the program.

### Initial performance
- 43-44 ms average for 200 iterations
- ~8,5 ms for execution of tallyChars method (measured in profiling)
![oldMainMethods](<images/oldMainMethods.png>)
- ~700.000 live objects 
![oldMainObjects](<images/oldMainObjects.png>)


*An explanation of the bottlenecks in the program and our improvements:*

The program allocated the type “Long” for the summation of each character, which allocates way more memory than needed for the particular number. We fixed this by changing it to Integer, which is 32 bit compared to Long’s 64 bit.

The program uses a FileReader class to read from the text file.This class accesses disk each time it reads and does a conversion to char, while the class we use, BufferedReader, reads only from disk once and then saves the data in memory and converts it to chars, which means every read after the first one is way faster.

The text file contains other characters than the ones in the alphabet, and the intention of the program is only to count the summation of each letter in the alphabet. The starting state of the program counted every character it came across, so we decided to set up a filter to solve this bottleneck.

Since the program only should count the letters of the english alphabet, we could use a HashMap with an initial size of 52 ( because we count both normal & capital letters). The program doesn’t do this, so it ends of changing the size of the HashMap multiple times unnecessarily.


*Documentation of the new performance, again including documentation that the measurements are free of errors:*
	
For the measurement of the new performance we have not altered the testing parameters, and stuck with the mark 2 technique.

### New Performance
- ~28-29 ms average for 200 iterations
    - Performance improvement of ~15 ms in execution time of project
- ~6.0 ms for execution of tallyChars method (measured in profiling)
![newMainMethods](<images/newMainMethods.png>)
    - Performance improvement of ~1.5 ms per execution of method. 

- ~190.000 Live objects
![newMainObjects](<images/newMainObjects.png>)
    - Memory improvement of ~510.000 less Live objects.


