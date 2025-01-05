-- 코드를 작성해주세요
select 
    YEAR(a.DIFFERENTIATION_DATE) as YEAR, 
    (b.MAX - a.SIZE_OF_COLONY) as YEAR_DEV, 
    a.ID as ID
from ECOLI_DATA a
join (
    select 
        MAX(SIZE_OF_COLONY) as MAX, 
        YEAR(DIFFERENTIATION_DATE) as YEAR
    from ECOLI_DATA
    group by YEAR(DIFFERENTIATION_DATE)
) b on YEAR(a.DIFFERENTIATION_DATE) = b.YEAR
order by YEAR asc, YEAR_DEV asc;

