package com.statestreet.bank1;

public class Customer {
int cid;
int token;

public Customer(int a,int b) {
this.cid=a;
this.token=b;
}
public int getCid() {
return cid;
}
public void setCid(int cid) {
this.cid = cid;
}
public int getToken() {
return token;
}
public void setToken(int token) {
this.token = token;
}
}
