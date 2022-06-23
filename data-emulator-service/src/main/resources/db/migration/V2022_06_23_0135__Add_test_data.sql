INSERT INTO "persons" (person_id, person_name)
VALUES (1, 'Israel Adesanya'),
       (2, 'Jon Jones'),
       (3, 'Jose Aldo'),
       (4, 'Lyoto Machida'),
       (5, 'Robert Whittaker');

INSERT INTO "buildings" (building_id, building_verbose_address, building_owner_id)
VALUES (1, 'San Joseppe, 32a', 1),
       (2, 'Visconti, 11', 1),
       (3, 'Palma, 23a', 2),
       (4, 'Oritella, 12/3', 3),
       (5, 'Sola, 2', 4),
       (6, 'Manila, 321', 4),
       (7, 'Santi, 90/22', 4);

INSERT INTO "rooms" (room_id, room_name, building_id)
VALUES (1, 'First Bedroom', 1),
       (2, 'Second Bedroom', 1),
       (3, 'Hall', 2),
       (4, 'Kitchen', 2),
       (5, 'First Bedroom', 3),
       (6, 'Bathroom', 4),
       (7, 'Hall', 5),
       (8, 'Kitchen', 6),
       (9, 'Game Room', 7);


