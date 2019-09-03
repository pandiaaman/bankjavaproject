package com.statestreet.bank1;

import java.util.ArrayList;
import java.util.Date;

class Teller extends Thread{

int sleep;
int tnum;
static int a1=0;
static int b1=0;
static int c1=0;
static int counter=0;

Teller(int tnum,int sleep){
this.tnum= tnum;
this.sleep = sleep;

}

int processcount;
ArrayList<Customer> servedCustomer = new ArrayList<>();

@Override
public void run() {
// TODO Auto-generated method stub
System.out.println("teller " + tnum + "waiting at " + new Date());
while(!HelloBank.custq.isEmpty()) {
Customer c = HelloBank.custq.poll();
if(tnum==0) {
a1++;
}
if(tnum==1) {
b1++;
}
if(tnum==2) {
c1++;
}
System.out.println("teller  "+ tnum + " with sleep time " + sleep+ " is servicing customer "+ c.getCid() + " with token "+ c.getToken());
try {
Thread.sleep(sleep*1000);
}
catch(Exception e) {
System.out.println(e);
}
//System.out.println("teller  "+ tnum + " with slep time " + sleep+ " served customer "+ c.getCid()+ " with token "+ c.getToken());
//processcount++;
//servedCustomer.add(c);
}

System.out.println("teller " + tnum + "completed at " + new Date());

while(HelloBank.custq.isEmpty()) {
	if(counter==0) {
System.out.println(a1 + " "+ b1 + " "+ c1);
}
	counter++;
}
//System.out.println("teller " + tnum + "served" + processcount + " customers");


////////////////////////////////////////////////////////////////////////////////////

/*
System.out.println("teller " + tnum + "began at " + new Date());

try {
Customer c = HelloBank.custq.poll();
HelloBank.tellerarray[tnum][HelloBank.count[tnum]++]=c.getCid();
System.out.println("teller  "+ tnum + " with slep time " + sleep+ " is servicing customer "+ c.getCid()+" with token "+ c.getToken());

Thread.sleep(sleep*1000);
//System.out.println("hello 3 "+ tnum + " " + sleep);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
System.out.println("teller " + tnum + "completed at " + new Date());
/*System.out.println("printing the 2d array");
for(int i=0;i<tnum;i++) {
for(int j=0;)
}*/
//System.out.println("no of customers serviced by the tellers");

}

}
public class TellerThread{
public static void main(String[] args) {
// TODO Auto-generated method stub
Teller t1 = new Teller(1,2);
Teller t2 = new Teller(2,4);
Teller t3 = new Teller(3,6);

t1.start();
t2.start();
t3.start();
}



}
