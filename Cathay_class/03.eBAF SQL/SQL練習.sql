--select * from DBXX.DTXXTP01 where DIV_NO like '9_00000' with ur;
--group by DIV_NO

/*select count(DIV_NO) as cnt, DIV_NO from DBXX.DTXXTP01 group by DIV_NO with ur */
  

--select * from DBXX.DTXXTP01 where 1=1  and EMP_ID = '00000' and DIV_NO like '%A%' with ur

select * from DBXX.DTXXTP01 where 1=1  and EMP_ID = '00000' --and DIV_NO like '%A%' with ur