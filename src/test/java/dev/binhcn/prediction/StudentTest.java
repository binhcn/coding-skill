package dev.binhcn.prediction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class StudentTest {

  @InjectMocks
  private Student student;

  private Student studentSpy;

  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void mockStatic() {
    //Use try when mock static method in order not to affect other unit tests which use same static method
    try (MockedStatic<Student> theMock = Mockito.mockStatic(Student.class)) {
      theMock.when(Student::name).thenReturn("Rafael");
      assertThat(Student.name(), Matchers.startsWith("Raf"));
    }
  }

  @Test
  public void mockWithInternalMethod() {
    studentSpy = Mockito.spy(student);
    when(studentSpy.getAge()).thenReturn(20);
    assertEquals(studentSpy.age(), "Hello, I'm 20");
  }

  @Test
  public void mockWithInternalStaticMethod() {
    studentSpy = Mockito.spy(student);
    MockedStatic<Student> theMock = Mockito.mockStatic(Student.class);
    theMock.when(Student::getJob).thenReturn("IT");
    assertEquals(studentSpy.job(), "Hello, I'm a IT");
  }

  @Test(expected = NullPointerException.class)
  public void voidMethod() {
    Student mockStudent = mock(Student.class);
    doThrow(new NullPointerException()).when(mockStudent).hello();
    mockStudent.hello();
  }

  @Test
  public void privateMethod()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method method = Student.class.getDeclaredMethod("address");
    method.setAccessible(true);
    String actual = (String)method.invoke(student);
    assertThat(actual, is("Tien Giang"));
  }
}