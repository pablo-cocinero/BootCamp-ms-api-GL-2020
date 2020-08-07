select id, name
from ANIMALS
order by id desc;

select id, name
from ANIMALS
where weight > 30
order by id desc;

select id, name 
from ANIMALS
where name like 'L%'
order by id asc;

select id, name, weight, species, count(species)
from ANIMALS
group by species
order by id desc;

select id, name, weight, species, count(species)
from ANIMALS
where weight > 100
group by species
order by id asc;