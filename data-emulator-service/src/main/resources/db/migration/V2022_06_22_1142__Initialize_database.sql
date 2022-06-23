CREATE TABLE "rooms"
(
    room_id     BIGSERIAL PRIMARY KEY,
    room_name   VARCHAR(40) NOT NULL,
    building_id BIGINT      NOT NULL
);

CREATE TABLE "persons"
(
    person_id   BIGSERIAL PRIMARY KEY,
    person_name VARCHAR(40) NOT NULL
);

CREATE TABLE "buildings"
(
    building_id              BIGSERIAL PRIMARY KEY,
    building_verbose_address VARCHAR(100) NOT NULL,
    building_owner_id           BIGINT       NOT NULL
);

ALTER TABLE "rooms"
    ADD FOREIGN KEY ("building_id") REFERENCES buildings ("building_id");

ALTER TABLE "buildings"
    ADD FOREIGN KEY ("building_owner_id") REFERENCES persons ("person_id");