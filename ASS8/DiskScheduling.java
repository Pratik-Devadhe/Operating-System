import java.util.*;

public class DiskScheduling {

    // FCFS
    public static void fcfs(int[] req, int head) {
        int seek = 0;
        System.out.print("Seek Sequence: " + head);

        for (int r : req) {
            seek += Math.abs(head - r);
            head = r;
            System.out.print(" -> " + r);
        }

        System.out.println("\nTotal Seek Time: " + seek);
    }

    // SSTF
    public static void sstf(int[] req, int head) {
        int n = req.length;
        boolean[] visited = new boolean[n];
        int seek = 0;

        System.out.print("Seek Sequence: " + head);

        for (int i = 0; i < n; i++) {
            int idx = -1;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(head - req[j]);
                    if (dist < min) {
                        min = dist;
                        idx = j;
                    }
                }
            }

            visited[idx] = true;
            seek += Math.abs(head - req[idx]);
            head = req[idx];

            System.out.print(" -> " + req[idx]);
        }

        System.out.println("\nTotal Seek Time: " + seek);
    }

    // SCAN
    public static void scan(int[] req, int head, int diskSize, String direction) {
        Arrays.sort(req);
        int seek = 0;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int r : req) {
            if (r < head) left.add(r);
            else right.add(r);
        }

        System.out.print("Seek Sequence: " + head);

        if (direction.equalsIgnoreCase("right")) {
            for (int r : right) {
                seek += Math.abs(head - r);
                head = r;
                System.out.print(" -> " + r);
            }

            // go to end
            seek += Math.abs(head - (diskSize - 1));
            head = diskSize - 1;

            for (int i = left.size() - 1; i >= 0; i--) {
                seek += Math.abs(head - left.get(i));
                head = left.get(i);
                System.out.print(" -> " + head);
            }
        } else {
            for (int i = left.size() - 1; i >= 0; i--) {
                seek += Math.abs(head - left.get(i));
                head = left.get(i);
                System.out.print(" -> " + head);
            }

            // go to start
            seek += Math.abs(head - 0);
            head = 0;

            for (int r : right) {
                seek += Math.abs(head - r);
                head = r;
                System.out.print(" -> " + r);
            }
        }

        System.out.println("\nTotal Seek Time: " + seek);
    }

    // LOOK
    public static void look(int[] req, int head, String direction) {
        Arrays.sort(req);
        int seek = 0;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int r : req) {
            if (r < head) left.add(r);
            else right.add(r);
        }

        System.out.print("Seek Sequence: " + head);

        if (direction.equalsIgnoreCase("right")) {
            for (int r : right) {
                seek += Math.abs(head - r);
                head = r;
                System.out.print(" -> " + r);
            }

            for (int i = left.size() - 1; i >= 0; i--) {
                seek += Math.abs(head - left.get(i));
                head = left.get(i);
                System.out.print(" -> " + head);
            }
        } else {
            for (int i = left.size() - 1; i >= 0; i--) {
                seek += Math.abs(head - left.get(i));
                head = left.get(i);
                System.out.print(" -> " + head);
            }

            for (int r : right) {
                seek += Math.abs(head - r);
                head = r;
                System.out.print(" -> " + r);
            }
        }

        System.out.println("\nTotal Seek Time: " + seek);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of requests: ");
        int n = sc.nextInt();

        int[] req = new int[n];
        System.out.println("Enter request sequence:");
        for (int i = 0; i < n; i++) {
            req[i] = sc.nextInt();
        }

        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        System.out.println("\nSelect Algorithm:");
        System.out.println("1. FCFS");
        System.out.println("2. SSTF");
        System.out.println("3. SCAN");
        System.out.println("4. LOOK");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                fcfs(req, head);
                break;

            case 2:
                sstf(req, head);
                break;

            case 3:
                System.out.print("Enter disk size: ");
                int size = sc.nextInt();
                System.out.print("Enter direction (left/right): ");
                String dir = sc.next();
                scan(req, head, size, dir);
                break;

            case 4:
                System.out.print("Enter direction (left/right): ");
                String d = sc.next();
                look(req, head, d);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
