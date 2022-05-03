package com.example.admin.getpets;

public class PetDetails {

    // fields
    public int petID;
    public String petName;
    public double weight;
    public double height;
    public int lifeExpectancy;
    public int availability;
    public double adoptionFees;
    public String image1;
    public String image2;

    // constructors
    public PetDetails() {}
    public PetDetails(int petID, String petName, double weight, double height,
                      int lifeExpectancy, int availability, double adoptionFees,String image1,String image2) {
        this.petID = petID;
        this.petName = petName;
        this.weight = weight;
        this.height = height;
        this.lifeExpectancy = lifeExpectancy;
        this.availability = availability;
        this.adoptionFees = adoptionFees;
        this.image1=image1;
        this.image2=image2;
    }
    // properties
    public void setID(int id) {
        this.petID = id;
    }
    public int getID() {
        return this.petID;
    }
}
