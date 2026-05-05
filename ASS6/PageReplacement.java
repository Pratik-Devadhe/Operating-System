import java.util.*;

class PageReplacement{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        

        //enter the referenace string size;
        
        System.out.print("enter the referenace string size :");
        int n = sc.nextInt();

        int[] ref = new int[n];
        
        System.out.print("enter the referenace string (Space seprated) :");

        for(int i=0; i < n; i++){
            ref[i] = sc.nextInt();
        }

        System.out.print("enter the frame size :");
        int frames = sc.nextInt();

        System.out.print("Choose the algorithm :");
        System.out.println("1 : First In First Out");
        System.out.println("2 : Least Recently Used");
        System.out.println("3 : Optimal Algorithm");

        int algo = sc.nextInt();

        int hit = 0;
        int fault = 0;

        if(algo == 1){
            Queue<Integer> q = new LinkedList<>();
            

            for(int i =0; i < n; i++){

                if(q.size() > 0 && q.contains(ref[i])){
                    hit++;
                }else if(q.size() < frames){
                    fault++;
                    q.add(ref[i]);
                }else{
                        q.poll();
                        q.add(ref[i]);
                        fault++;
                }
            }
            double hitratio = (double)hit / n;
            double faultratio = (double)fault / n;

            System.out.println("Page Hits : " + hit);
            System.out.println("Page Faults : " + fault);
            System.out.println("Page Hit Ratio : " + hitratio * 100 + "%");
            System.out.println("Page Fault Ratio : " +  faultratio * 100 + "%");
        }else if(algo == 2){
            
            List<Integer> list = new ArrayList<>();

            for(int i=0; i < n; i++){
                if(list.contains(ref[i])){
                    list.remove((Integer) ref[i]);
                    list.add(ref[i]);
                    hit++;
                }else{
                    if(list.size() == frames){
                        list.remove(0);
                       
                    }
                        list.add(ref[i]);  
                        fault++;  
                }
            }

            double hitratio = (double)hit / n;
            double faultratio = (double)fault / n;

            System.out.println("Page Hits : " + hit);
            System.out.println("Page Faults : " + fault);
            System.out.println("Page Hit Ratio : " + hitratio * 100 + "%");
            System.out.println("Page Fault Ratio : " +  faultratio * 100 + "%");

        }else if(algo == 3){
            List<Integer> list = new ArrayList<>();

            for(int i =0; i < n; i++){
                if(list.contains(ref[i])){
                    hit++;
                }else{
                    fault++;
                     if(list.size() < frames){
                       list.add(ref[i]);
                     }else{
                        int idx = -1;
                        int farthest = i;

                        for(int j =0; j < list.size(); j++){
                            int page = list.get(j);
                            
                            int k;
                            for(k =0; k < n ; k++){
                                if(ref[k] == page){
                                    idx = k;
                                    break;
                                }
                            }

                            if(k == list.size()){
                                farthest = list.size();
                                break;
                            }

                            if(k > farthest){
                                farthest = k;
                                idx = j;
                            }
                        }
                        list.set(idx , ref[i]);
                     }

                     
                }
            }

            double hitratio = (double)hit / n;
            double faultratio = (double)fault / n;

            System.out.println("Page Hits : " + hit);
            System.out.println("Page Faults : " + fault);
            System.out.println("Page Hit Ratio : " + hitratio * 100 + "%");
            System.out.println("Page Fault Ratio : " +  faultratio * 100 + "%");


        }

        sc.close();
    } 
}
