# Operating System Assignments

This repository contains implementations of various Operating System concepts including system calls, shell scripting, process synchronization, scheduling, memory management, deadlock avoidance, and disk monitoring.

---

## Folder-wise Assignment Details

### 📂 [ASS2: Process Control & System Calls](./ASS2)
Programs demonstrating basic process creation and system calls in C.
* **[one.c](./ASS2/one.c)**: Demonstrates child process creation using the `fork()` system call, printing parent and child PIDs.
* **[two.c](./ASS2/two.c)**: Demonstrates process synchronization where the parent process waits for the child process to complete execution using `wait(NULL)`.
* **[three.c](./ASS2/three.c)**: Demonstrates program overlay/execution using the `execlp()` system call to execute the `ls -l` command.

### 📂 [ASS3: Bash Shell Scripting](./ASS3)
Automation and utility scripts written in Bash.
* **[ass3.sh](./ASS3/ass3.sh)**: An interactive, menu-driven file operation utility (Create, Delete, Copy, and List files).
* **[calculator.sh](./ASS3/calculator.sh)**: A simple terminal-based calculator implementing basic arithmetic operations (+, -, *, /).
* **[diskUsage.sh](./ASS3/diskUsage.sh)**: A monitoring script that alerts the user and logs warnings when disk space usage on the `/home` partition exceeds 80%.

### 📂 [ASS5: Deadlock Avoidance](./ASS5)
Deadlock handling algorithm implemented in Java.
* **[BankersAlgorithm.java](./ASS5/BankersAlgorithm.java)**: Implements the Banker's Algorithm to check whether the system is in a safe state and determines the safe sequence for process execution.

### 📂 [ASS6: Page Replacement](./ASS6)
Memory management algorithms implemented in Java.
* **[PageReplacement.java](./ASS6/PageReplacement.java)**: A simulator that implements **FIFO (First-In-First-Out)**, **LRU (Least Recently Used)**, and **Optimal** page replacement algorithms to compute and display page hits, page faults, and hit/fault ratios.

### 📂 [ASS7: CPU Scheduling](./ASS7)
Process scheduling algorithms implemented in Java.
* **[CPUScheduling.java](./ASS7/CPUScheduling.java)**: Implements and compares **FCFS (First-Come, First-Served)**, **SJF (Shortest Job First - Non-preemptive)**, and **Round Robin (RR)** CPU scheduling algorithms. It outputs a Gantt chart along with turnaround time (TAT) and waiting time (WT) for each process.

### 📂 [ASS8: Disk Scheduling](./ASS8)
Secondary storage management algorithms implemented in Java.
* **[DiskScheduling.java](./ASS8/DiskScheduling.java)**: Simulates head movement and calculates total seek time using **FCFS**, **SSTF (Shortest Seek Time First)**, **SCAN**, and **LOOK** disk scheduling algorithms.