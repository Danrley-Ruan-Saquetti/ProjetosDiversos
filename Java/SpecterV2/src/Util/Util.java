package Util;

import java.util.Random;
import java.util.Scanner;

public class Util {
  
  public static final Scanner scan = new Scanner(System.in);
  public static final Random random = new Random();
  
  public static <T> T newInstance(Class<T> classConstructor) {
    try {
      return (T) classConstructor.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
