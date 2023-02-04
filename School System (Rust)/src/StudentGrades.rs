impl StudentGrades {
    fn average(&self) -> f64 { // calculates average grade of student
        let mut totalGrade = 0.0;
        let mut count = 0.0;
        for scores in &self.grades {
            totalGrade += scores;
            count += 1.0;
        }
        totalGrade / (100.0 * count)
    }
    fn grade(&self, studentGrade: &f64) -> char { //returns a char and asseses returns A-F depending on the student's average
        if studentGrade >= &90.0 {
            'A'
        }
        else if studentGrade >= &80.0 {
            'B'
        }
        else if studentGrade >= &70.0 {
            'C'
        }
        else if studentGrade >= &60.0 {
            'D'
        }
        else {
            'F'
        }
    }
}

struct StudentGrades {
    name: String,
    grades: Vec<f64>
}

fn main() { // Creating students and populating it with data and unitesting to make sure it works
    let student1 = StudentGrades {
        name: String::from("Ethian"),
        grades: vec![79.9, 82.4, 65.7]
    };
    let student2 = StudentGrades {
        name: String::from("Alex"),
        grades: vec![9.9, 50.9, 83.2]
    };
    let student3 = StudentGrades {
        name: String::from("Elmo"),
        grades: vec![100.0, 72.3, 92.0]
    };

    let average_grade = student1.average() * 100.0;
    println!("{}", average_grade);
    let student_grade = student1.grade(&average_grade);
    println!("{}", student_grade);

    let average_grade = student2.average() * 100.0;
    println!("{}", average_grade);
    let student_grade = student2.grade(&average_grade);
    println!("{}", student_grade);
    
    let average_grade = student3.average() * 100.0;
    println!("{}", average_grade);
    let student_grade = student3.grade(&average_grade);
    println!("{}", student_grade);

    //unittests
    assert_eq!(76.0, &student1.average() * 100.0);
    assert_eq!(48.0, &student2.average() * 100.0);
    assert_eq!(88.1, &student3.average() * 100.0);

    assert_eq!('C', student1.grade(&student1.average() * 100.0));
    assert_eq!('F', student2.grade(&student2.average() * 100.0));
    assert_eq!('B', student3.grade(&student3.average() * 100.0));
}
