package g3;

import java.io.Serializable;

public class Exam implements Serializable {
private String rollNumber;
private String fullName;
private String examId;
private String examName;
private float mark;
public Exam(){

}
public Exam(String rollNumber,String fullName,String examId,String examName,float mark){
   this.rollNumber=rollNumber;
   this.fullName=fullName;
   this.examId=examId;
   this.examName=examName;
   this.mark=mark;
}
public String getExamId() {
    return examId;
}public void setExamId(String examId) {
    this.examId = examId;
}public String getExamName() {
    return examName;
}public void setExamName(String examName) {
    this.examName = examName;
}public String getFullName() {
    return fullName;
}public void setFullName(String fullName) {
    this.fullName = fullName;
}public float getMark() {
    return mark;
}public void setMark(float mark) {
    this.mark = mark;
}public String getRollNumber() {
    return rollNumber;
}public void setRollNumber(String rollNumber) {
    this.rollNumber = rollNumber;
}

}
