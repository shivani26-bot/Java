package com.shivani.packages.MultiThreading.ThreadCommunication.LambdaExpression;

public class EngineeringStudent implements Student {
    // we have to do so much work , first define interface then implement that and
    // then create object in main method
    // instead of doing all this, as this class only contains one method , we have
    // no need of this class we can implement the method directly in main method

    @Override
    public String getBio(String name) {
        // TODO Auto-generated method stub
        return name + " is Engineering student ";
    }

}
