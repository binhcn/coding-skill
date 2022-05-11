package dev.binhcn.prediction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConvertIntArray2List {

  public static void main(String[] args) {
    int[] nums = new int[] {1,2,3};

    List<Integer> currList1 = IntStream.of(nums).boxed().collect(Collectors.toList());
    List<Integer> currList2 = Arrays.stream(nums).boxed().collect(Collectors.toList());
    Integer[] currList3 = IntStream.of(nums).boxed().toArray(Integer[]::new);
    Integer[] currList4 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
  }
}
