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

class(a).
class(b).
class(c).

class(a, pam).
class(a, liz).
class(a, pat).
class(a, ann).
class(b, jim).
class(b, tom).
class(b, bob).
class(b, harry).
class(c, ron).
class(c, hermione).
class(c, neville).
class(c, dracobitch).

room(1).
room(2).
room(3).

date(21/09).
date(22/09).
date(23/09).

class_in_room(a, 1).
class_in_room(b, 2).
class_in_room(c, 3).

schoolday_for_class(21/09, a).
schoolday_for_class(22/09, b).
schoolday_for_class(23/09, c).
schoolday_for_class(24/09, a).
schoolday_for_class(25/09, b).
schoolday_for_class(28/09, c).

is_student_in_class(C, S) :-
    class(C),
    student(S),
    class(C, S).

is_class_in_room(C, R) :-
    class(C),
    room(R),
    class_in_room(C, R).

is_schoolday_for_class(D, C) :-
    date(D),
    class(C),
    schoolday_for_class(D, C).


