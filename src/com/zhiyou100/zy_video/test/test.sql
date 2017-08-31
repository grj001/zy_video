  	select c.*, s.subject_name
  	from course c
  	left join subject s on s.id = c.subject_id;
  	
  	insert into course
		(course_name,course_descr,insert_time,subject_id)
		values('1','1','2017-08-22 22:11:11',1);
		
select s.* from speaker s limit 1,5 

select sum(video_play_times) from video
--speaker-playTimes
select 
sp.speaker_id, sp.course_id, sp.svpt, s.speaker_name
from
(select  v.speaker_id,v.course_id,sum(v.video_play_times) svpt
  	from video v
	group by speaker_id) sp

left join speaker s
on s.id = sp.speaker_id;



select sum(video_play_times) from video
--course-playTimes
select 
cp.speaker_id, cp.course_id, cp.cvpt, c.course_name
from
(select  v.speaker_id,v.course_id,sum(v.video_play_times) cvpt
  	from video v
	group by course_id) cp

left join course c
on c.id = cp.course_id;



--课程播放总次数
--course-playTimes
select 
cp.course_id, cp.cavpt, c.course_name
from
(select  v.course_id,avg(v.video_play_times) cavpt
  	from video v
	group by course_id) cp

left join course c
on c.id = cp.course_id;


--课程对应的视频数

select count(1),v.course_id
  	from video v
	group by course_id





select 
	v.course_id, avg(v.video_play_times) cavpt, course_name courseName
from
	video v, course c
	where c.id = v.course_id group by course_id

	
select * from user;	
update user set captcha = '1547' where email = '875654381@qq.com'; 


select * 
from video v
left join course c on c.id = v.course_id
left join subject s on s.id = c.subject_id

select * 
from course c
right join video v on v.course_id = c.id;


select * from video v
left join speaker s on s.id = v.speaker_id

select * from video v
left join course c on c.id = v.course_id
left join subject s on s.id = c.subject_id


select * from course c right join video v on v.course_id = c.id where c.subject_id = 1


select *, s.id sId,c.id cId  from video v
left join course c on c.id  = v.course_id
left join subject s on s.id = c.subject_id
having  s.id = 1

select *, v.id as vId from course c right join video v on v.course_id = c.id where c.subject_id = 1


select *, s.id sId, c.id cId 
from video v 
left join speaker s on s.id = v.speaker_id 
left join course c on c.id = v.course_id 
where v.id = 18

select *, v.id as vId from course c right join video v on v.course_id = c.id where c.subject_id = 11








  	