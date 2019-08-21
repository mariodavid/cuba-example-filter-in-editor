-- begin CEFIE_CUSTOMER
create table CEFIE_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end CEFIE_CUSTOMER
-- begin CEFIE_ORDER
create table CEFIE_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_DATE date,
    ORDER_ID varchar(255),
    AMOUNT decimal(19, 2),
    PAYMENT_METHOD varchar(50),
    CUSTOMER_ID varchar(36),
    --
    primary key (ID)
)^
-- end CEFIE_ORDER
