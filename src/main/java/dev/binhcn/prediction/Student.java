package dev.binhcn.prediction;

public class Student {

  public static String name() {
    return "John";
  }


  public String age() {
    return "Hello, I'm " + this.getAge();
  }

  public int getAge() {
    return 10;
  }

  public String job() {
    return "Hello, I'm a " + getJob();
  }

  public static String getJob() {
    return "student";
  }

  public void hello() {
    System.out.println("Hello");
  }

  public String callInternalPrivateMethod() {
    return address();
  }

  private String address() {
    return "Tien Giang";
  }
}
