package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import java.util.HashMap;

/**
 * Contains unit test for the Department class to validate  
 * its functionality, including methods and the constructor. 
 */
@SpringBootTest
@ContextConfiguration
public class DepartmentUnitTests {

  @BeforeAll
  public static void setupDepartmentForTesting() {
    testCourses = new HashMap<>();
    Course COMS4111 = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
    testCourses.put("4111", COMS4111);
    testDepartment = new Department("COMS", testCourses, "Paul Blaer", 3000);
  }

  @Test
  public void toStringTest() {
    String expectedResult = "COMS 4111: \n"
            + "Instructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testDepartment.toString());
  }

  @Test
  public void getNumberOfMajorsTest() {
    assertEquals(3000, testDepartment.getNumberOfMajors());
  }

  @Test
  public void getDepartmentChairTest() {
    assertEquals("Paul Blaer", testDepartment.getDepartmentChair());
  }

  @Test
  public void getCourseSelectionTest() {
    assertEquals(testCourses, testDepartment.getCourseSelection());
  }

  @Test
  public void addPersonToMajorTest() {
    testDepartment.addPersonToMajor();
    assertEquals(3001, testDepartment.getNumberOfMajors());
  }

  @Test
  public void dropPersonFromMajorTest() {
    testDepartment.dropPersonFromMajor();
    assertEquals(2999, testDepartment.getNumberOfMajors());
  }

  @Test
  public void addCourseTest() {
    Course COMS1004 = new Course("Adam Cannon", "417 IAB", "10:10-11:25", 250);
    testDepartment.addCourse("1004", COMS1004);
    assertEquals(COMS1004.toString(), testDepartment.getCourseSelection().get("1004").toString());
  }

  @Test
  public void createCourseTest() {
    Course COMS3134 = new Course("Brian Borowski", "301 URI", "11:40-12:55", 200);
    testDepartment.createCourse("3134", "Brian Borowski", "301 URI", "11:40-12:55", 200);
    assertEquals(COMS3134.toString(), testDepartment.getCourseSelection().get("3134").toString());
  }

  /** The test courses instance used for testing. */
  public static HashMap<String, Course> testCourses;
  
  /** The test department instance used for testing. */
  public static Department testDepartment;
}

