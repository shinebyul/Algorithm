select a.ID, b.FISH_NAME, a.LENGTH
from FISH_INFO a
LEFT JOIN FISH_NAME_INFO b
ON a.FISH_TYPE = b.FISH_TYPE
WHERE (a.FISH_TYPE ,a.LENGTH) IN
        (
            select FISH_TYPE, MAX(LENGTH) AS MAX
            from FISH_INFO
            group by FISH_TYPE
        )
order by ID asc;