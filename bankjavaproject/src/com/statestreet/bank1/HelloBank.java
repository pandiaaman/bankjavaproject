package com.statestreet.bank1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class HelloBank {
public static PriorityBlockingQueue<Customer> custq = new PriorityBlockingQueue<>(50,new CustomerCompare());
//public static PriorityQueue<Customer> custq = new PriorityQueue<>(50,new CustomerCompare());
static int[][] tellerarray = new int[3][50];
static int[] count= new int[3];

public static void main(String[] args) {
int y=0;
Scanner sc = new Scanner(System.in);
System.out.println("enter the no of customers");
int n = sc.nextInt();
for(int i=0;i<n;i++) {
try {
Customer c = new Customer(i,(int)(Math.random()));
custq.put(c);
//custq.add(c);
y++;
System.out.println("############ cusotmer id " + c.getCid() + " with token " + c.getToken()+ " is generated ");

}
catch(Exception e) {
System.out.println(e);
}
}
System.out.println(y);
//Collections.sort(custq, new CustomerCompare()); 

//Arrays.sort(custq.toArray());

Iterator<Customer> itr2 = custq.iterator(); 
while (itr2.hasNext()) 
           System.out.println(itr2.next().token); 

//Collections.sort(custq, new sort()); 

System.out.println("enter the no of tellers");
int t= sc.nextInt();

int[] stime= new int[] {15,10,2};

for(int i=0;i<n;i++) {
Teller teller = new Teller(i%t,stime[i%t]);
teller.start();
}
System.out.println(Teller.a1+" "+ Teller.b1 + " "+Teller.c1);
}

}

class CustomerCompare implements Comparator<Customer>{

@Override
public int compare(Customer c1, Customer c2) {
// TODO Auto-generated method stub
if(c1.getToken()<c2.getToken())
return 1;
else if(c1.getToken()<c2.getToken())
return -1;

return 0;
}

}
