package dev.binhcn.prediction;

/**
 * How many elements are there in the array split?
 */
public class Split {

  public static void main(String[] args) {
    String str = "a|b||d||e|||||";
    String[] arr = str.split("\\|");
    System.out.println(arr.length);
  }
}
