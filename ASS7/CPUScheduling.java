import java.util.*;

class Process {
    int id, at, bt, ct, tat, wt, rt;

    Process(int id, int at, int bt) {
        this.id = id;
        this.at = at;
        this.bt = bt;
        this.rt = bt; // for RR
    }
}

public class CPUScheduling {

    // FCFS Scheduling
    public static void fcfs(List<Process> p) {
        p.sort(Comparator.comparingInt(a -> a.at));

        int time = 0;
        double totalTAT = 0, totalWT = 0;

        System.out.println("\nGantt Chart:");

        for (Process pr : p) {
            if (time < pr.at)
                time = pr.at;

            System.out.print("| P" + pr.id + " ");
            time += pr.bt;

            pr.ct = time;
            pr.tat = pr.ct - pr.at;
            pr.wt = pr.tat - pr.bt;

            totalTAT += pr.tat;
            totalWT += pr.wt;
        }
        System.out.println("|");

        printResult(p, totalTAT, totalWT);
    }

    // SJF (Non-preemptive)
    public static void sjf(List<Process> p) {
        int n = p.size();
        boolean[] done = new boolean[n];

        int time = 0, completed = 0;
        double totalTAT = 0, totalWT = 0;

        System.out.println("\nGantt Chart:");

        while (completed < n) {
            int idx = -1;
            int minBT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!done[i] && p.get(i).at <= time && p.get(i).bt < minBT) {
                    minBT = p.get(i).bt;
                    idx = i;
                }
            }

            if (idx == -1) {
                time++;
                continue;
            }

            Process pr = p.get(idx);
            System.out.print("| P" + pr.id + " ");

            time += pr.bt;
            pr.ct = time;
            pr.tat = pr.ct - pr.at;
            pr.wt = pr.tat - pr.bt;

            totalTAT += pr.tat;
            totalWT += pr.wt;

            done[idx] = true;
            completed++;
        }

        System.out.println("|");
        printResult(p, totalTAT, totalWT);
    }

    // Round Robin
    public static void roundRobin(List<Process> p, int tq) {
        Queue<Process> q = new LinkedList<>();
        int time = 0;
        double totalTAT = 0, totalWT = 0;

        p.sort(Comparator.comparingInt(a -> a.at));
        int i = 0;

        System.out.println("\nGantt Chart:");

        while (true) {
            while (i < p.size() && p.get(i).at <= time) {
                q.add(p.get(i));
                i++;
            }

            if (q.isEmpty()) {
                if (i < p.size()) {
                    time = p.get(i).at;
                    continue;
                } else break;
            }

            Process pr = q.poll();
            System.out.print("| P" + pr.id + " ");

            int execTime = Math.min(pr.rt, tq);
            pr.rt -= execTime;
            time += execTime;

            while (i < p.size() && p.get(i).at <= time) {
                q.add(p.get(i));
                i++;
            }

            if (pr.rt > 0) {
                q.add(pr);
            } else {
                pr.ct = time;
                pr.tat = pr.ct - pr.at;
                pr.wt = pr.tat - pr.bt;

                totalTAT += pr.tat;
                totalWT += pr.wt;
            }
        }

        System.out.println("|");
        printResult(p, totalTAT, totalWT);
    }

    // Print Results
    public static void printResult(List<Process> p, double totalTAT, double totalWT) {
        System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");

        for (Process pr : p) {
            System.out.println("P" + pr.id + "\t" + pr.at + "\t" + pr.bt + "\t" +
                    pr.ct + "\t" + pr.tat + "\t" + pr.wt);
        }

        System.out.printf("\nAverage TAT = %.2f", totalTAT / p.size());
        System.out.printf("\nAverage WT = %.2f\n", totalWT / p.size());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        List<Process> processes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Arrival Time and Burst Time for P" + (i + 1) + ": ");
            int at = sc.nextInt();
            int bt = sc.nextInt();
            processes.add(new Process(i + 1, at, bt));
        }

        System.out.println("\nSelect Scheduling Algorithm:");
        System.out.println("1. FCFS");
        System.out.println("2. SJF");
        System.out.println("3. Round Robin");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                fcfs(processes);
                break;

            case 2:
                sjf(processes);
                break;

            case 3:
                System.out.print("Enter Time Quantum: ");
                int tq = sc.nextInt();
                roundRobin(processes, tq);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
