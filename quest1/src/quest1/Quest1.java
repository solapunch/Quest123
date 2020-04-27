/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest1;

import java.util.ArrayList;

/**
 *
 * @author CALVIN
 */
public class Quest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String [] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        solution(input);
    }
    
    public static String [] solution(String [] input)
    {
        ArrayList<Temp> data = new ArrayList<Temp>();
        int x=0;
        int hidden=0;
        while(x < input.length)
        {
            if(input[x].startsWith("Enter"))
            {
                hidden++;
                if(data.isEmpty())
                {
                    Temp t = new Temp (input[x].substring(input[x].lastIndexOf(' ')+1) , input[x].substring(input[x].indexOf(' ')+1, input[x].lastIndexOf(' ')));
                    data.add(t);
                }
                else
                {
                    int count = 0; 		
                    while (data.size() > count)
                    {
                      if(!data.isEmpty())
                      {
                          if(data.get(count).getUid().equalsIgnoreCase(input[x].substring(input[x].indexOf(' ')+1, input[x].lastIndexOf(' '))))
                          {
                              data.get(count).setName(input[x].substring(input[x].lastIndexOf(' ')+1));
                          }
                          else
                          {
                            Temp t = new Temp (input[x].substring(input[x].lastIndexOf(' ')+1), input[x].substring(input[x].indexOf(' ')+1, input[x].lastIndexOf(' ')));
                            data.add(t);
                          }
                      }
                      count++;
                    }
                }
            }
            else if(input[x].startsWith("Leave"))
            {
                hidden++;
            }
            else if(input[x].startsWith("Change"))
            {
                int count = 0; 		
                    while (data.size() > count)
                    {
                      if(!data.isEmpty())
                      {
                          if(data.get(count).getUid().equalsIgnoreCase(input[x].substring(input[x].indexOf(' ')+1, input[x].lastIndexOf(' '))))
                          {
                              data.get(count).setName(input[x].substring(input[x].lastIndexOf(' ')+1));
                          }
                          else
                          {
                            Temp t = new Temp (input[x].substring(input[x].lastIndexOf(' ')+1), input[x].substring(input[x].indexOf(' ')+1, input[x].lastIndexOf(' ')));
                            data.add(t);
                          }
                      }
                      count++;
                    }
            }
            x++;
        }
        
        x=0;
        String [] answer = new String [hidden];
        while(x < input.length)
        {
            if(input[x].startsWith("Enter"))
            {
                int y=0;
                while(y<data.size())
                {
                    if(data.get(y).getUid().equalsIgnoreCase(input[x].substring(input[x].indexOf(' ')+1, input[x].lastIndexOf(' '))))
                    answer[x] = data.get(y).getName()+" came in";
                    y++;
                }
            }
            else if(input[x].startsWith("Leave"))
            {
                int y=0;
                while(y<data.size())
                {
                    if(data.get(y).getUid().equalsIgnoreCase(input[x].substring(input[x].lastIndexOf(' ')+1)))
                    answer[x] = data.get(y).getName()+" has left";
                    y++;
                }
            }
            else
            {}
            x++;
        }
        
        x=0;
        while(x<hidden)
        {
            System.out.println(answer[x]);
            x++;
        }
        return answer;
    }
}

class Temp
{
    protected String name;
    protected String uid;
    public Temp(String name, String uid)
    {
        this.name = name;
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public String getUid() {
        return uid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
}
