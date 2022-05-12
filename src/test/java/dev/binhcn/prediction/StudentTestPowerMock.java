package dev.binhcn.prediction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Student.class)
public class StudentTestPowerMock {

  @InjectMocks
  private Student student;

  private Student studentSpy;

  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void internalPrivateMethod() throws Exception {
    studentSpy = Mockito.spy(student);
    when(studentSpy, "address").thenReturn("TPHCM");
    String actual = studentSpy.callInternalPrivateMethod();
    verifyPrivate(studentSpy, times(1)).invoke();
    assertThat(actual, is("TPHCM"));
  }
}