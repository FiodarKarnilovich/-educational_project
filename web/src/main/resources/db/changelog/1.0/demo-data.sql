-- liquibase formatted sql

-- changeset Fiodar Karnilovich:1

INSERT INTO rentalcar_db.userRole (id, roleName)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

-- changeset Fiodar Karnilovich:2

INSERT INTO rentalcar_db.person (id, firstName, lastName, email, password, birthDay, phoneNumber, userRole_id)
VALUES (1, 'ADMIN', 'ADMIN', 'admin@admin.com', 'admin', '1979-03-16', '375291000000', 1),
       (2, 'USER', 'USER', 'user@user.com', 'user', '2000-01-01', '375291000000', 2);