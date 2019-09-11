% Students
student(pam).
student(liz).
student(pat).
student(ann).
student(jim).
student(tom).
student(bob).
student(harry).
student(ron).
student(hermione).
student(neville).
student(dracobitch).

% Classes
class(a).
class(b).
class(c).

% Students associated with class
student_in_class(a, pam).
student_in_class(a, liz).
student_in_class(a, pat).
student_in_class(a, ann).
student_in_class(b, jim).
student_in_class(b, tom).
student_in_class(b, bob).
student_in_class(b, harry).
student_in_class(c, ron).
student_in_class(c, hermione).
student_in_class(c, neville).
student_in_class(c, dracobitch).

% Rooms
room(1).
room(2).
room(3).

% Dates
date(21/09).
date(22/09).
date(23/09).

% Classes associated with rooms
class_in_room(a, 1).
class_in_room(b, 2).
class_in_room(c, 3).

% Schoolday/date associated with student_in_class
schoolday_for_class(21/09, a).
schoolday_for_class(22/09, b).
schoolday_for_class(23/09, c).
schoolday_for_class(24/09, a).
schoolday_for_class(25/09, b).
schoolday_for_class(28/09, c).

% method to check whether a specific student is in a specific student_in_class
is_student_in_class(C, S) :-
    student_in_class(C),
    student(S),
    student_in_class(C, S).

% method to check whether a specific student_in_class is in a specific room
is_class_in_room(C, R) :-
    student_in_class(C),
    room(R),
    class_in_room(C, R).

% method to check whether a specific student_in_class has schoolday on a specific date
is_schoolday_for_class(D, C) :-
    date(D),
    student_in_class(C),
    schoolday_for_class(D, C).

% method to check whether two students is in the same class
is_students_in_same_class(S1, S2) :-
    student(S1),
    student(S2),
    student_in_class(C, S1),
    student_in_class(C, S2),
    S1 \== S2.


