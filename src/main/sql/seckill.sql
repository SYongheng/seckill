--定义存储过程
--参数： in输入参数；out输出参数
--row_count()：返回上一条修改类型sql（delete，insert，update）的影响行数
create procedure seckill.execute_seckill(in v_seckill_id bigint,in v_phone bigint,in v_kill_time timestamp,out r_result int)
begin
    declare insert_count int default 0;
    start transaction;
    insert ignore into success_killed(seckill_id,user_phone,create_time) values (v_seckill_id,v_phone,v_kill_time);
    select row_count() into insert_count;
    if(insert_count = 0) then
        rollback;
        set r_result = -1;
    elseif(insert_count < 0) then
        rollback;
        set r_result = -2;
    else
        update seckill set number = number - 1
        where seckill_id = v_seckill_id and end_time > v_kill_time and start_time < v_kill_time and number > 0;
        select row_count() into insert_count;
        if(insert_count = 0) then
            rollback;
            set r_result = 0;
        elseif(insert_count < 0) then
            rollback;
            set r_result = -2;
        else
            commit;
            set r_result = 1;
        end if;
    end if;
end;
--存储过程
--1.存储过程优化；事务行级锁持有的时间
--2.不要过度依赖存储过程
--3.简单的逻辑可以应用存储过程
--4.qps：一个秒杀单6000qps


set @r_result = 3;
call execute_seckill(1,12345678911,now(),@r_result);
select @r_result;