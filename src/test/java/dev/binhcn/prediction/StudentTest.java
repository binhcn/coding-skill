package dev.binhcn.prediction;

//import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class StudentTest {

  @Test
  public void mockStatic() {
    try (MockedStatic<Student> theMock = Mockito.mockStatic(Student.class)) {
      theMock.when(Student::name).thenReturn("Rafael");
      assertEquals(Student.name(), "Rafael");
    }
  }

  @Test
  public void mockStaticWithFinal() {
    MockedStatic<Student> theMock = Mockito.mockStatic(Student.class);
    theMock.when(Student::age).thenReturn(9);
    assertThat(Student.age(), Matchers.greaterThan(5));
  }
}