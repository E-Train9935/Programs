/*
A public struct called CourseSchedule. The struct has a type-associated function
from_file(file_path:String). The file_path is a path to a .xls file of the SDSU schedule. One is
downloadable from the same web page as this document. The struct has at least one method,
courses_at(time: &str, days: &str). 

The time is given in 24-hour format—for example, 1800
and 815. Days are limited to M, T, W, TH, MWF, MW, and TTH. The method returns a vector of
Course instances for courses being taught at the day and time indicated. The Struct Course
has at least the fields: catalog_number, title, and instructor.
*/
use std::fs::File;
use std::io::prelude::*;

struct CourseSchedule{
    creator: String
}

struct Course {
    catalog_number: String,
    title: String,
    instructor: String,
    day: String,
    time: String
}

impl CourseSchedule {
    fn from_file(&self, file_path: String, rows: usize) -> Vec<Vec<String>> { 
        let mut file = File::open(file_path).expect("No file found."); 
        let mut content_from_file = String::new();
        file.read_to_string(&mut content_from_file).expect("Cannot read file."); //reads file and "catches exception"

        //formatting the file content and splitting from endline and tabs
        let new_formatted_content: Vec<String> = content_from_file.split("\n").map(String::from).collect();
        let mut course_information: Vec<Vec<String>> = Vec::new();
        for student in new_formatted_content { //
            course_information.push(student.split("\t").map(String::from).collect());  
        }

        //make course object and adds all the necessary attributes to a new vector and returns it
        let mut course_objects: Vec<String> = Vec::new();
        let mut course_return_objects: Vec<Vec<String>> = Vec::new();
        for i in 2..rows+3 {
            let new_catalog_number = course_information[i][1] + course_information[i][2];
            let class_name = course_information[i][6];
            let time = course_information[i][23];
            let days = course_information[i][25];
            let teacher = course_information[i][26];
            course_objects.push(new_catalog_number);
            course_objects.push(class_name);
            course_objects.push(time);
            course_objects.push(days); 
            course_objects.push(teacher);
            course_return_objects.push(course_objects);
        }
        course_return_objects
    }

    fn courses_at(time: &str, days: &str, course_vector: Vec<Vec<String>>) -> Vec<Course> {
        let mut courses_at_time_and_days_wanted: Vec<Course> = Vec::new();
        for i in 0..course_vector.len() {
            if course_vector[i][2] == time && days == course_vector[i][3] {
                let course = Course {
                        catalog_number: course_vector[i][0],
                        title: course_vector[i][1],
                        instructor: course_vector[i][4],
                        day: course_vector[i][3],
                        time: course_vector[i][2]
                };
                courses_at_time_and_days_wanted.push(course);
            };
        }
        courses_at_time_and_days_wanted
    }
}

fn main() {
    let schedule = CourseSchedule{
        creator: "Ethian".to_string()
    }; 

    //unit tests
    assert_eq!(5, schedule.courses_at(schedule.from_file("search.xls".to_string(), 5)).len());
    assert_eq!(10, schedule.courses_at(schedule.from_file("search.xls".to_string(), 10)).len());
    assert_eq!(15, schedule.courses_at(schedule.from_file("search.xls".to_string(), 15)).len());
    assert_eq!(20, schedule.courses_at(schedule.from_file("search.xls".to_string(), 20)).len());
    assert_eq!(25, schedule.courses_at(schedule.from_file("search.xls".to_string(), 25)).len());

}