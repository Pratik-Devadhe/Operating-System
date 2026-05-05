import java.util.*;

public class BankersAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of processes and resources
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter number of resources: ");
        int m = sc.nextInt();

        int[][] alloc = new int[n][m]; // Allocation Matrix
        int[][] max = new int[n][m];   // Max Matrix
        int[][] need = new int[n][m];  // Need Matrix
        int[] avail = new int[m];      // Available Resources

        // Input Allocation matrix
        System.out.println("Enter Allocation Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                alloc[i][j] = sc.nextInt();
            }
        }

        // Input Max matrix
        System.out.println("Enter Max Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[i][j] = sc.nextInt();
            }
        }

        // Input Available resources
        System.out.println("Enter Available Resources:");
        for (int i = 0; i < m; i++) {
            avail[i] = sc.nextInt();
        }

        // Calculate Need matrix = Max - Allocation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                need[i][j] = max[i][j] - alloc[i][j];
            }
        }

        boolean[] finish = new boolean[n];
        int[] safeSeq = new int[n];
        int count = 0;

        while (count < n) {
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (!finish[i]) {
                    int j;
                    for (j = 0; j < m; j++) {
                        if (need[i][j] > avail[j])
                            break;
                    }

                    // If all needs can be satisfied
                    if (j == m) {
                        for (int k = 0; k < m; k++) {
                            avail[k] += alloc[i][k];
                        }

                        safeSeq[count++] = i;
                        finish[i] = true;
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("System is NOT in safe state.");
                return;
            }
        }

        // Safe state
        System.out.println("System is in SAFE state.");
        System.out.print("Safe Sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + safeSeq[i] + " ");
        }

        sc.close();
    }
}
