import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static class InvalidDets extends Exception{
        public InvalidDets(String str){
            super(str);
        }
    }

    public static class Student{
        Scanner s = new Scanner(System.in);
        String reg;
        int[] marks = new int[5];
        int[] ques = new int[4];
        void getdets() throws InvalidDets{
            System.out.println("Give Reg no");
            reg = s.nextLine();
            System.out.println("Give the 4 attempted question numbers");
            for (int i=0;i<4;i++){
                int x = s.nextInt();
                if (x>=1 && x<=10)
                    ques[i] = x;
                else {
                    throw new InvalidDets("Wrong i/p");
                }
            }
            System.out.println("Give quiz marks");
            int x = s.nextInt();
            if(x>=0 && x<=10)
                marks[4] = x;
            else
                throw new InvalidDets("Wrong i/p");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Q1","List");
        map.put("Q2","Dictionary");
        map.put("Q3","Exception Handling");
        map.put("Q4","Functions");
        map.put("Q5","OOPS");
        map.put("Q6","Flow Control");
        map.put("Q7","Files");
        map.put("Q8","Date&Time");
        map.put("Q9","Pandas");
        map.put("Q10","Numpy");

        FileReader fr =new FileReader("D:/AnswerKey.txt");
        BufferedReader br = new BufferedReader(fr);
        String line= "";
        String[][] ques = new String[10][10];
        int z=1;
        while((line = br.readLine()) != null){
            if(z%2 != 0)
                z++;
            else {
                if (z == 2) {
                    ques[(z/2)-1] = line.split(",");
                }
                else if (z == 4)
                    ques[(z/2)-1] = line.split(",");
                else if (z == 6)
                    ques[(z/2)-1] = line.split(",");
                else if (z == 8)
                    ques[(z/2)-1] = line.split(",");
                else if (z == 10)
                    ques[(z/2)-1] = line.split(",");
                else if (z == 12)
                    ques[(z/2)-1] = line.split(",");
                else if (z == 14)
                    ques[(z/2)-1] = line.split(",");
                else if (z == 16)
                    ques[(z/2)-1] = line.split(",");
                else if (z == 18)
                    ques[(z/2)-1] = line.split(",");
                else if (z == 20)
                    ques[(z/2)-1] = line.split(",");
                z++;
            }
        }
        fr.close();
        br.close();

        int n = 5;//Number of students
        Map<Integer, Map<String,Integer>> test = new HashMap<>();
        Student[] stud = new Student[n];
        Map<String,Integer> q1 = new HashMap<>(),q2= new HashMap<>(),q3= new HashMap<>(),q4= new HashMap<>(),q5= new HashMap<>(),q6= new HashMap<>(),q7= new HashMap<>(),q8= new HashMap<>(),q9= new HashMap<>(),q10  = new HashMap<>();

        for(int i=0;i<n;i++){
            System.out.println("For Student"+(i+1));
            stud[i] = new Student();
            stud[i].getdets();
            String f;
            System.out.println("Give file name");
            f  = s.nextLine();
            fr = new FileReader("D:/"+f+".txt");
            br = new BufferedReader(fr);
            for(int x=0;x<4;x++)
                stud[i].marks[x] = 0;
            int j=-1;
            while((line = br.readLine()) != null){

                if(line.charAt(0) == 'Q')
                    j++;
                else{
                    int q = stud[i].ques[j] - 1;
                    String ans[] = line.split(" ");
                    int m = 0;
                    for (int k=0;k<ans.length;k++){
                        for (int l=0;l<ques[q].length;l++){
                            if (ans[k].indexOf(ques[q][l]) != -1)
                                m++;
                        }
                    }
                    if(stud[i].marks[j] < 10)
                        stud[i].marks[j] += m;
                }
            }
            for(int k=0;k<4;k++){
                if (stud[i].ques[k] == 1)
                    q1.put(stud[i].reg,stud[i].marks[k]);
                else if (stud[i].ques[k] == 2)
                    q2.put(stud[i].reg,stud[i].marks[k]);
                else if (stud[i].ques[k] == 3)
                    q3.put(stud[i].reg,stud[i].marks[k]);
                else if (stud[i].ques[k] == 4)
                    q4.put(stud[i].reg,stud[i].marks[k]);
                else if (stud[i].ques[k] == 5)
                    q5.put(stud[i].reg,stud[i].marks[k]);
                else if (stud[i].ques[k] == 6)
                    q6.put(stud[i].reg,stud[i].marks[k]);
                else if (stud[i].ques[k] == 7)
                    q7.put(stud[i].reg,stud[i].marks[k]);
                else if (stud[i].ques[k] == 8)
                    q8.put(stud[i].reg,stud[i].marks[k]);
                else if (stud[i].ques[k] == 9)
                    q9.put(stud[i].reg,stud[i].marks[k]);
                else if (stud[i].ques[k] == 10)
                    q10.put(stud[i].reg,stud[i].marks[k]);
            }
        }

        System.out.println("Class wise marks");
        int max=0;
        for (int i=0;i<n;i++){
            int tot =0;
            System.out.println("Reg: "+stud[i].reg);
            for (int j=0;j<5;j++){
                tot += stud[i].marks[j];
                if (j == 4)
                    System.out.println("Quiz marks = "+stud[i].marks[j]);
                else
                    System.out.println("Question "+stud[i].ques[j]+" -> Marks = "+stud[i].marks[j]);
            }
            System.out.println("Total marks out of 50 = "+tot);
            max = max+tot;
        }
        float avg = max/n;
        System.out.println("Class average = "+avg);

        test.put(1,q1);
        test.put(2,q2);
        test.put(3,q3);
        test.put(4,q4);
        test.put(5,q5);
        test.put(6,q6);
        test.put(7,q7);
        test.put(8,q8);
        test.put(9,q9);
        test.put(10,q10);

        System.out.println("Question wise class average:");
        for (Map.Entry<Integer, Map<String,Integer>> entry : test.entrySet()){
            System.out.println("Question "+entry.getKey());
            int tot=0,count =0;
            for (Map.Entry<String,Integer> e: entry.getValue().entrySet()){
                count++;
                tot += e.getValue();
            }
            float a = tot/count;
            System.out.println("\tAvg = "+a+"\n");
        }

    }
}