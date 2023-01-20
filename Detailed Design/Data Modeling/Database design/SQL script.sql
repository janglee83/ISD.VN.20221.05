CREATE TABLE bike_type (
 id INT NOT NULL,
 name VARCHAR(45),
 value SMALLINT
);

ALTER TABLE bike_type ADD CONSTRAINT PK_bike_type PRIMARY KEY (id);


CREATE TABLE Dock (
 id INT NOT NULL,
 name VARCHAR(45),
 dockArea FLOAT(20),
 address VARCHAR(100),
 dock_image_url VARCHAR(100)
);

ALTER TABLE Dock ADD CONSTRAINT PK_Dock PRIMARY KEY (id);


CREATE TABLE dock_empty_point (
 id INT NOT NULL,
 empty_points INT,
 max_available_points INT,
 dock_id INT NOT NULL,
 bike_type_id INT NOT NULL
);

ALTER TABLE dock_empty_point ADD CONSTRAINT PK_dock_empty_point PRIMARY KEY (id);


CREATE TABLE Transaction (
 id CHAR(10) NOT NULL,
 name VARCHAR(45),
 code VARCHAR(100),
 time DATE WITH TIME ZONE,
 content VARCHAR(100),
 amount INT
);

ALTER TABLE Transaction ADD CONSTRAINT PK_Transaction PRIMARY KEY (id);


CREATE TABLE Bike (
 id INT NOT NULL,
 name VARCHAR(45),
 bikeValue INT,
 isBeingUsed SMALLINT,
 licence_plate VARCHAR(100),
 bike_image_url VARCHAR(30),
 brand VARCHAR(100),
 bike_type_id INT NOT NULL,
 dock_id INT NOT NULL
);

ALTER TABLE Bike ADD CONSTRAINT PK_Bike PRIMARY KEY (id);


CREATE TABLE bike_attribute (
 id INT NOT NULL,
 name VARCHAR(45),
 value VARCHAR(100),
 bike_id INT
);

ALTER TABLE bike_attribute ADD CONSTRAINT PK_bike_attribute PRIMARY KEY (id);


CREATE TABLE rental_bike_code (
 id INT NOT NULL,
 bar_code VARCHAR(100),
 bike_id INT
);

ALTER TABLE rental_bike_code ADD CONSTRAINT PK_rental_bike_code PRIMARY KEY (id);


ALTER TABLE dock_empty_point ADD CONSTRAINT FK_dock_empty_point_0 FOREIGN KEY (dock_id) REFERENCES Dock (id);
ALTER TABLE dock_empty_point ADD CONSTRAINT FK_dock_empty_point_1 FOREIGN KEY (bike_type_id) REFERENCES bike_type (id);


ALTER TABLE Bike ADD CONSTRAINT FK_Bike_0 FOREIGN KEY (bike_type_id) REFERENCES bike_type (id);
ALTER TABLE Bike ADD CONSTRAINT FK_Bike_1 FOREIGN KEY (dock_id) REFERENCES Dock (id);


ALTER TABLE bike_attribute ADD CONSTRAINT FK_bike_attribute_0 FOREIGN KEY (bike_id) REFERENCES Bike (id);


ALTER TABLE rental_bike_code ADD CONSTRAINT FK_rental_bike_code_0 FOREIGN KEY (bike_id) REFERENCES Bike (id);


