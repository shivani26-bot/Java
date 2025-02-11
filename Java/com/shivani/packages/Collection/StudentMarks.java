package com.shivani.packages.Collection;

// public class StudentMarks {

//     private int maths;
//     private int physics;

//     @Override
//     public String toString() {
//         return "StudentMarks [maths=" + maths + ", physics=" + physics + "]";
//     }

//     public int getMaths() {
//         return maths;
//     }

//     public int getPhysics() {
//         return physics;
//     }

//     public StudentMarks(int maths, int physics) {
//         this.maths = maths;
//         this.physics = physics;
//     }
// }

public class StudentMarks implements Comparable<StudentMarks> {

    private int maths;
    private int physics;

    @Override
    public String toString() {
        return "StudentMarks [maths=" + maths + ", physics=" + physics + "]";
    }

    public int getMaths() {
        return maths;
    }

    public int getPhysics() {
        return physics;
    }

    public StudentMarks(int maths, int physics) {
        this.maths = maths;
        this.physics = physics;
    }

    @Override
    // compare the current instance of class with the object that is passed as
    // parameter
    public int compareTo(StudentMarks o) {
        // current object < other object return -1
        // current object > other object return 1
        // current object == other object return 0

        // if (this.maths < o.maths)
        // return -1;
        // if (this.maths > o.maths)
        // return 1;
        // if (this.maths == o.maths)
        // return 0;
        // return 0;

        System.out.println("comparable's compareTo () is called");
        // return this.maths - o.maths;//ascending sorting
        return o.maths - this.maths; // descending sorting
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + maths;
        result = prime * result + physics;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudentMarks other = (StudentMarks) obj;
        if (maths != other.maths)
            return false;
        if (physics != other.physics)
            return false;
        return true;
    }
}
