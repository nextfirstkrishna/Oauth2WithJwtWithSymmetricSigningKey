CREATE TABLE IF NOT EXISTS oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(1024),
  client_secret VARCHAR(256) NOT NULL,
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(1024),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INT(11),
  refresh_token_validity INT(11),
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_client_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_access_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication BLOB,
  refresh_token VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication BLOB
);

CREATE TABLE IF NOT EXISTS user(
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(256) NOT NULL,
  password VARCHAR(256) NOT NULL,
  email VARCHAR(256) NOT NULL,
  enabled BIT(1),
  account_expired BIT(1),
  credentials_expired BIT(1),
  account_locked BIT(1),
  UNIQUE KEY unique_username(username)
);

CREATE TABLE IF NOT EXISTS permission(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(60) UNIQUE KEY
);

CREATE TABLE IF NOT EXISTS role(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(60) UNIQUE KEY
);

CREATE TABLE IF NOT EXISTS permission_role(
permission_id INT,
FOREIGN KEY(permission_id) REFERENCES permission(id),
role_id INT,
FOREIGN KEY(role_id) REFERENCES role(id) 
);

CREATE TABLE IF NOT EXISTS role_user(
role_id INT,
FOREIGN KEY(role_id) REFERENCES role(id),
user_id INT,
FOREIGN KEY(user_id) REFERENCES user(id)
);

