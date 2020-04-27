/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest3;

/**
 *
 * @author CALVIN
 */
public class Quest3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String [][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}; 
        solution(relation);
    }
    
    public static String solution(String relation[][])
    {
        int count=0;
        for(int q = 0; q < relation.length ; q++)
        {
            if(q!=relation.length-1)
            for(int w = q+1 ; w < relation.length; w++)
            {
                if(!relation[q][1].equals(relation[w][1]) && relation[q][3].equals(relation[w][3]))
                {
                    count++;
                }
                else if(relation[q][1].equals(relation[w][1]))
                {
                    count--;
                }
            }
        }
        String answer= ""+count;
        System.out.println(answer);
        return answer;
    }
}
