/*
A public struct called CourseGrades. The struct has a type-associated
function from_file(file_path:String). The argument to the method is a path to a file. The
method reads the file. For each line in the file, it creates a StudentGrades object.

The struct has at least two methods: (associated functions): average and student. With the
input N an integer, the average method returns the average score of all students on the N'th
grade event. The first grade event is indexed by 1, not 0. average returns an Option, as the
input N could be out of range. student has one parameter: a string which is a student's name.
It returns an Option. If the name is found in the course, the StudentGrades is returned.
*/

use std::fs::File;
use std::io::prelude::*;

struct StudentGrades {
    name: String,
    grades: Vec<f64> 
}

struct CourseGrades;

impl CourseGrades {
    fn from_file(&self, file_path: String) -> Vec<StudentGrades> { //gets data from file and returns vector of student grades
        let mut file = File::open(file_path).expect("No file found.");
        let mut content = String::new();
        file.read_to_string(&mut content).expect("Cannot read file.");
        content.retain(|c| !c.is_whitespace() || c == '\n'); //gets rid of whitespace and keeps endlines
        let new_content: Vec<String> = content.split("\n").map(String::from).collect(); //splits content by endlines and makes all the data points a String

        let mut student_information: Vec<Vec<String>> = Vec::new();
        for student in new_content {
            student_information.push(student.split(',').map(String::from).collect());  //gets individual values of a student and stores it in student information to have every index be a different student
        }

        let mut student_grades_objects: Vec<StudentGrades> = Vec::new();
        for i in 0..student_information.len() {
            let student_grades: Vec<String> = student_information[i][1..student_information[i].len()].to_vec(); //gets only the grades, excludes the name of each student
            let student_grades: Vec<f64> = student_grades.iter().map(|index| index.parse::<f64>().unwrap()).collect(); //converts grades from String to f64
            let student =  StudentGrades { 
                name: student_information[i][0].to_string(),
                grades: student_grades
            };
            student_grades_objects.push(student);
        }
        student_grades_objects
    }
    fn average(&self, student_grades: &Vec<StudentGrades>, index: usize) -> Option<f64> {
        let mut average_grade = 0.0;
        let mut count = 0.0;
        for grade in student_grades {
            average_grade += grade.grades[index - 1];
            count += 1.0;
        }
        if count != 0.0 {
            println!("{}", average_grade);
            println!("{}", count);
            Some(average_grade / (100.0 * count))
        }
        else {
            None
        }
    }
    fn student(&self, student_name: String, student_objects: &Vec<StudentGrades>) -> Option<StudentGrades> {
        for student in student_objects {
            if student_name == student.name {
                return Some(student);
            }
        }
        None
    }
}

fn main() {
    let all_student_objects = CourseGrades.from_file("sample.txt".to_string()); 
    println!("{:?}", CourseGrades.average(&all_student_objects, 1 as usize));
    println!("{:?}", CourseGrades.student("pete".to_string(), &all_student_objects));

    //unitests
    assert_eq!(2, CourseGrades.from_file("sample.txt".to_string()).len())
    assert_eq!(5, CourseGrades.from_file("sample2.txt".to_string()).len())
    assert_eq!(0, CourseGrades.from_file("sample3.txt".to_string()).len())

    assert_eq!(Some(0.85), CourseGrades.average(CourseGrades.from_file("sample.txt".to_string()), 1 as usize))
    assert_eq!(Some(0.6192), CourseGrades.average(CourseGrades.from_file("sample2.txt".to_string()), 2 as usize))
    assert_eq!(None, CourseGrades.average(CourseGrades.from_file("sample3.txt".to_string()), 1 as usize))

    assert_eq!(1, CourseGrades.student("pete".to_string(), CourseGrades.from_file("sample.txt".to_string()).len()))
    assert_eq!(1, CourseGrades.student("alex".to_string(), CourseGrades.from_file("sample2.txt".to_string()).len()))
    assert_eq!(None, CourseGrades.student("elmo".to_string(), CourseGrades.from_file("sample2.txt".to_string())));
}