package com.example.mandatoryassignment.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Rating implements Parcelable {
    private int courseImage;
    private String teacherName;
    private String teacherCourses;
    private String email;

    public Rating(int courseImage, String teacherName, String teacherCourses, String email){
        this.courseImage = courseImage;
        this.teacherName = teacherName;
        this.teacherCourses = teacherCourses;
        this.email = email;
    }

    protected Rating(Parcel in) {
        courseImage = in.readInt();
        teacherName = in.readString();
        teacherCourses = in.readString();
        email = in.readString();
    }

    public static final Creator<Rating> CREATOR = new Creator<Rating>() {
        @Override
        public Rating createFromParcel(Parcel in) {
            return new Rating(in);
        }

        @Override
        public Rating[] newArray(int size) {
            return new Rating[size];
        }
    };

    public int getCourseImage() {
        return courseImage;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherCourses() {
        return teacherCourses;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(courseImage);
        dest.writeString(teacherName);
        dest.writeString(teacherCourses);
        dest.writeString(email);
    }
}
