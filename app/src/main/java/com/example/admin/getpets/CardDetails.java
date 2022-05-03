package com.example.admin.getpets;

public class CardDetails {
    public long cardno;
    public String Name;
    public int date;
    public int cvv;

    public CardDetails() {}
    public CardDetails(long cardno, String Name, int date, int cvv) {
       this.cardno=cardno;
       this.Name=Name;
       this.date=date;
       this.cvv=cvv;
    }
}
