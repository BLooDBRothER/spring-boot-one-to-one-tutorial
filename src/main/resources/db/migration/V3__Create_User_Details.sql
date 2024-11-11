CREATE TABLE usermanagement.USER_DETAILS
(
    email         VARCHAR(255),
    user_id       BIGINT PRIMARY KEY,

    created_at    TIMESTAMP,
    updated_at    TIMESTAMP,

    CONSTRAINT fk_email_on_user FOREIGN KEY (user_id)
        REFERENCES usermanagement.USER (id)
);