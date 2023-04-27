/* Populate table car*/
insert into cars (plate) values('ESM308');
insert into cars (plate) values('WMZ550');
insert into cars (plate) values('WGO385');
insert into cars (plate) values('WNZ132');
insert into cars (plate) values('SZM019');
insert into cars (plate) values('EXZ583');
insert into cars (plate) values('WOW395');
insert into cars (plate) values('WNU017');
insert into cars (plate) values('WDX501');
insert into cars (plate) values('TSP521');
insert into cars (plate) values('WNV375');
insert into cars (plate) values('WEP161');

/*populate table countrys */
insert into countrys (name) values('Colombia');

/* populate table citys*/
insert into citys (name,country_id) values('Bogotá','1');
insert into citys (name,country_id) values('Medellín','1');

/* populate table drivers*/
insert into drivers (first_name,last_name) values('Julio Alberto','Mesa Rodriguez');
insert into drivers (first_name,last_name) values('Javier Gustavo','Castañeda Saavedra');
insert into drivers (first_name,last_name) values('Jeferson Mauricio','Delgado Jimenez');
insert into drivers (first_name,last_name) values('Andres Fernando','Alvarez Gonzalez');
insert into drivers (first_name,last_name) values('Ribervin','Ojeda Romero');
insert into drivers (first_name,last_name) values('Armando','Diaz Suarez');
insert into drivers (first_name,last_name) values('Evencio','Vargas Lopez');

/*populate table passengers*/
insert into passengers (first_name,last_name) values('Ricardo','Sarmiento');
insert into passengers (first_name,last_name) values('Transporte','Mi Aguila');
insert into passengers (first_name,last_name) values('Admin','Mi Aguila');
insert into passengers (first_name,last_name) values('Christine','Ince');
insert into passengers (first_name,last_name) values('Juan Dayan','Beltrán Carranza');
insert into passengers (first_name,last_name) values('Maria Camila','Puentes Diaz');
insert into passengers (first_name,last_name) values('Gloria Cecilia','Gil Gutierrez');
insert into passengers (first_name,last_name) values('Jorge','Londoño Mejía');
insert into passengers (first_name,last_name) values('Mauricio','Garces');

/*populate table travel */
insert into travel (start_date,start_pickup_addres,end_pickup_addres,country_id,city_id,passenger_id,driver_id,car_id,status,check_code,created_at,price,driver_location) values('2019-01-25 19:06:27.9360000','Cl. 90 #19-41, Bogotá, Colombia','Ac. 100 #13-21, Bogotá, Colombia','1','1','1','1','1','started','66',NOW(),13800.0,'calle 16 # 14-02, Bogotá, Colombia');


