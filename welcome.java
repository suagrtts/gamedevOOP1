#include<stdio.h>
#include<string.h>

struct Course {
    char courseName[100];
    int units;
};

struct Student {
    char studentName[100];
    int idNum;
    struct Course enrolled;
};

void inputStudent(Student *s){
    printf("Enter your name: ");
    fgets(s->studentName, sizeof(s->studentName), stdin);

    printf("Enter your ID number: ");
    scanf("%d", &s->idNum);
}

void inputCourse(Course *c){
    printf("Enter the course name: ");
    fgets(c->courseName, sizeof(c->courseName), stdin);

    printf("Enter the number of units: ");
    scanf("%d", &c->units);
}

void enrollStudent(Student *s, Course *c){
    strcpy(s->enrolled, courseName);
    s->enrolled = c->units;
}

void updateCourse(Course *c, char *newCourse, int newUnits){
    strcpy(*newCourse, c->courseName);
    c->units = newUnits;
}

void display(Student s){
    printf("Name: %s\n", s.studentName);
    printf("ID: %d\n", s.idNum);
    printf("Enrolled in: %s (%d units)", s->enrolled.courseName, s->enrolled.units);
}

int main() {
    struct Student s;

    inputStudent(&s);
    inputCourse(&c);
    enrollStudent(&s, &c);
    display(s);
    updateCourse(&c, "Networking 1", 4);
    display(s);
}

