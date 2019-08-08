# edu-threading
Simple java program that uses threads to add a list of positive integers.  The initial motivation behind the program was to demonstrate the difference in running times between similar programs that did and did not use threading.
Interestingly enough, multi-threading this program caused it to run slower (due to context switching) on a single processor system.

The main method is contained in the Master class and can be run with
the following sample input:
  12 1 2 5 8 10 91 3 10 8
