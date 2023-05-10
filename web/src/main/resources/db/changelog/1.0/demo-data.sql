-- liquibase formatted sql

-- changeset Fiodar Karnilovich:1

INSERT INTO rentalcar_db.userRole (id, roleName)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

-- changeset Fiodar Karnilovich:2

INSERT INTO rentalcar_db.person (id, firstName, lastName, email, password, birthDay, phoneNumber, userRole_id)
VALUES (1, 'ADMIN', 'ADMIN', 'admin@admin.com', 'admin', '1979-03-16', '375291000000', 1),
       (2, 'USER', 'USER', 'user@user.com', 'user', '2000-01-01', '375291000000', 2);

-- changeset Fiodar Karnilovich:3
INSERT INTO rentalcar_db.autoBrand (id, brandName)
VALUES (1, 'BMW'),
       (2, 'MERCEDES'),
       (3,'AUDI');

-- changeset Fiodar Karnilovich:4
INSERT INTO rentalcar_db.autoModel (id, brandName_id, modelName )
VALUES (1, 1, 'X5'),
       (2, 1, '7 long'),
       (3, 1, 'M5'),
       (4, 2, 'E class 6.3 AMG'),
       (5, 2, 'C class'),
       (6, 2, 'G class'),
       (7, 3, 'R8'),
       (8, 3, 'RS6'),
       (9, 3, 'Q8');

-- changeset Fiodar Karnilovich:5
INSERT INTO rentalcar_db.auto (id, modelName_id, colourAuto, transmissionAuto, yearAuto, priceAuto)
VALUES (1, 1, 'black', 'A', 2022, 100.0),
       (2, 3, 'blue', 'M', 2018, 200.0),
       (3, 4, 'gold', 'A', 2023, 400.0),
       (4, 7, 'red', 'A', 2020, 550.0),
       (5, 9, 'white', 'A', 2015, 100.0);

-- changeset Fiodar Karnilovich:6
INSERT INTO rentalcar_db.carOrder (id, person_id, auto_id, dateStart, dateFinish)
VALUES (1, 1, 1, 2022-05-06, 2022-05-12),
       (2, 3, 3, 2022-05-01, 2022-05-09);

