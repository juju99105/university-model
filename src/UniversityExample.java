/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Department.Department;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import Persona.Transcript;

/**
 *
 * @author kal bugrara
 */
public class UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Department department = new Department("Information Systems");
      
        
        StudentDirectory sd = department.getStudentDirectory();
        PersonDirectory pd = department.getPersonDirectory();

        // Student side process
        Person archilPerson = pd.newPerson("0123", "Archil");
        StudentProfile archil = sd.newStudentProfile(archilPerson);
        
        Transcript archilsTranscript = archil.getTranscript();

        CourseLoad archilsSpring2024 = archilsTranscript.newCourseLoad("Spring2024");
        CourseLoad archilsCurrentCourseLoad = archil.getCurrentCourseLoad();


        // Course side
        
        CourseCatalog courseCatalog = department.getCourseCatalog();
        Course info5001 = courseCatalog.newCourse("info5001", "Application Design & Modeling", 4);    
        Course info5100 = courseCatalog.newCourse("info5100", "Application Engineering Development", 4);

        CourseSchedule csSpring2024 = department.newCourseSchedule("Spring2024");
        
        CourseOffer info5001offerSpring2024 = csSpring2024.newCourseOffer("info5001");
        CourseOffer info5100offerSpring2024 = csSpring2024.newCourseOffer("info5100");
        
        info5001offerSpring2024.generateSeats(10); // This means 10 students can take this class
        info5100offerSpring2024.generateSeats(5);
        
        SeatAssignment archilRegisteredForInfo5001inSpring2024 = info5001offerSpring2024.assignEmptySeat(archilsCurrentCourseLoad);
        SeatAssignment archilRegisteredForInfo5100 = info5100offerSpring2024.assignEmptySeat(archilsCurrentCourseLoad);
        

        archil.printTranscript();

    }

}
