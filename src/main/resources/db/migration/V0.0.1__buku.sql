CREATE TABLE buku (
    BUKU_ID bigint PRIMARY KEY,
    CREATED_AT DATETIME,
    UPDATED_AT DATETIME,
    NAME varchar(225),
    AUTHOR varchar(225),
    PAGE int
);