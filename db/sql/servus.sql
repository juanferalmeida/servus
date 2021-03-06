CREATE TABLE LOGIN (
  mail VARCHAR(80) NOT NULL,
  code VARCHAR(20) NOT NULL,
  active BOOLEAN NOT NULL,
  userId VARCHAR(80) NOT NULL UNIQUE,
  PRIMARY KEY (mail)
);

CREATE TABLE PERSON (
  userId VARCHAR(80) NOT NULL,
  type VARCHAR(1) NOT NULL CHECK(type='A' OR type='C'),
  name VARCHAR(80) NOT NULL,
  mobile VARCHAR(20) NOT NULL,
  birthday DATE,
  PRIMARY KEY (userId),
  FOREIGN KEY (userId) REFERENCES LOGIN (userId)  
);

CREATE TABLE SERVICETYPE (
  serviceType VARCHAR(20) NOT NULL,
  name VARCHAR(80) NOT NULL,
  PRIMARY KEY (serviceType)
);

CREATE TABLE SERVICE (
  serviceId INT NOT NULL AUTO_INCREMENT,
  userId VARCHAR(80) NOT NULL,
  serviceType VARCHAR(20) NOT NULL,
  name VARCHAR(80) NOT NULL,
  description VARCHAR(200) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  country VARCHAR(2) NOT NULL,
  city VARCHAR(20),
  address VARCHAR(80),
  map VARCHAR(200),
  available BOOLEAN NOT NULL,
  price DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (serviceId),
  FOREIGN KEY (userId) REFERENCES PERSON (userId),
  FOREIGN KEY (serviceType) REFERENCES SERVICETYPE (serviceType)
);

CREATE TABLE RESERVE (
  reserveId INT NOT NULL AUTO_INCREMENT,
  userId VARCHAR(80) NOT NULL,
  serviceId INT NOT NULL,
  reserveDate DATE NOT NULL,
  reserveStart TIME NOT NULL,
  reserveEnd TIME NOT NULL,
  status VARCHAR(20) NOT NULL CHECK(status='OPEN' OR status='INPROGRESS' OR status='CANCELED' OR status='DONE'),
  score TINYINT NOT NULL CHECK (score>=0 AND score<=5),
  PRIMARY KEY (reserveId),
  FOREIGN KEY (userId) REFERENCES PERSON (userId),
  FOREIGN KEY (serviceId) REFERENCES SERVICE (serviceId)
);