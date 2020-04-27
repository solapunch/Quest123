/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest2;

/**
 *
 * @author CALVIN
 */
public class Quest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int N = 4;
        int [] users = {4, 4, 4, 4, 4};
        solution(N, users);
    }
    
    public static int [] solution(int n, int [] users)
    {
        int [] answer= new int [n];
        float [][] stage= new float [n][2];
        for(int q = 0 ; q < n ; q++)
        {
            stage[q][0]=q+1;
            int count=0;
            int pass=users.length;
            for(int w = 0 ; w < users.length ; w++)
            {
                if(q+1 == users[w])
                {
                    count++;
                }
            }
            stage[q][1]=count/pass;
            pass = pass-count;
        }
        
        float temp1=0;
        float temp2=0;
        for (int q = 0; q < n; q++) 
        {
            for (int w = q + 1; w < n; w++) 
            {
                if (stage[q][1] < stage[w][1]) 
                {
                    temp1 = stage[q][1]; temp2 = stage[q][0];
                    stage[q][1] = stage[w][1]; stage[q][0] = stage[w][0];
                    stage[w][1] = temp1; stage[w][0] = temp2;
                }
            }
        }
        for(int q = 0 ; q < n ; q++)
        {
            answer [q] = (int) stage[q][0];
            System.out.println(answer[q]);
        }
        return answer;
    }
}