-------------------- Populate drone table ----------------------
INSERT INTO drone(id, state, serial_number, model, weight_limit, battery_capacity) VALUES
	(1, 'LOADING','drone-1', 'LIGHTWEIGHT', 500, 70);
INSERT INTO drone(id, state, serial_number, model, weight_limit, battery_capacity) VALUES
	(2, 'LOADING','drone-2', 'HEAVYWEIGHT', 500, 100);
INSERT INTO drone(id, state, serial_number, model, weight_limit, battery_capacity) VALUES
	(3, 'LOADED', 'drone-3', 'MIDDLEWEIGHT', 500, 80);
INSERT INTO drone(id, state, serial_number, model, weight_limit, battery_capacity) VALUES
	(4, 'DELIVERING', 'drone-4', 'CRUISERWEIGHT', 500, 50);
INSERT INTO drone(id, state, serial_number, model, weight_limit, battery_capacity) VALUES
	(5, 'DELIVERED', 'drone-5', 'LIGHTWEIGHT', 500, 60);
-------------------- Populate medication table ----------------------
INSERT INTO medication(id, name, weight, code, image, drone_id) VALUES
	(1, 'med-1', 50,'code_1', null, 1);
INSERT INTO medication(id, name, weight, code, image, drone_id) VALUES
	(2, 'med-2', 50,'code_2', null, 1);
INSERT INTO medication(id, name, weight, code, image, drone_id) VALUES
	(3, 'med-3', 100,'code_3', null, 2);
INSERT INTO medication(id, name, weight, code, image, drone_id) VALUES
	(4, 'med-4', 100,'code_4', null, 2);
INSERT INTO medication(id, name, weight, code, image, drone_id) VALUES
	(5, 'med-5', 100,'code_5', null, 3);