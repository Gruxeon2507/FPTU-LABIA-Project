USE LAB_ReportGradeSystem;
Select s FROM LAB_ReportGradeSystem.Student s 
inner join LAB_ReportGradeSystem.Grade g on s.studentId=g.studentId
inner join LAB_ReportGradeSystem.GradeCategory gc on g.gradeCategoryId=gc.gradeCategoryId
inner join LAB_ReportGradeSystem.Course c on c.courseId=gc.courseId
inner join LAB_ReportGradeSystem.Semester sem on sem.semesterId=g.semesterId
where s.studentId = 'HE170996' and sem.semesterId= 'SP2023' and c.courseId='PRJ301'
    
    
	Select g FROM LAB_ReportGradeSystem.Grade g 
	inner join LAB_ReportGradeSystem.GradeCategory gc on g.gradeCategoryId=gc.gradeCategoryId
	inner join LAB_ReportGradeSystem.Course c on c.courseId=gc.courseId
	inner join LAB_ReportGradeSystem.Student s on s.studentId=g.studentId
	inner join LAB_ReportGradeSystem.Semester sem on sem.semesterId=g.semesterId
	where s.studentId = 'HE170996' and sem.semesterId= 'SP2023' and c.courseId='PRJ301'

select * from Semester