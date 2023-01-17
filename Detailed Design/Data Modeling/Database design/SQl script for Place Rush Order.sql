CREATE TABLE CreditCard (
 id INT NOT NULL,
 name VARCHAR(45),
 number INT,
 isUsingBank SMALLINT,
 expirationDate DATE,
 code CHAR(5) NOT NULL
);

ALTER TABLE CreditCard ADD CONSTRAINT PK_CreditCard PRIMARY KEY (id);


CREATE TABLE User (
 id INT NOT NULL,
 receiverName VARCHAR(45),
 phoneNumber INT,
 email VARCHAR(45),
 province VARCHAR(45),
 shippingAddress VARCHAR(45)
);

ALTER TABLE User ADD CONSTRAINT PK_User PRIMARY KEY (id);


CREATE TABLE Media (
 id INT NOT NULL,
 name VARCHAR(45),
 categoryType INT,
 value INT,
 price INT
);

ALTER TABLE Media ADD CONSTRAINT PK_Media PRIMARY KEY (id);


CREATE TABLE Order (
 id INT NOT NULL,
 shippingFees INT,
 customerInfo_id INT NOT NULL
);

ALTER TABLE Order ADD CONSTRAINT PK_Order PRIMARY KEY (id);


CREATE TABLE OrderMedia (
 id INT NOT NULL,
 media_id INT NOT NULL,
 price INT,
 quantity INT,
 order_id INT NOT NULL
);

ALTER TABLE OrderMedia ADD CONSTRAINT PK_OrderMedia PRIMARY KEY (id);


CREATE TABLE PaymentTransaction (
 id INT NOT NULL,
 transactionCode CHAR(10),
 content VARCHAR(100),
 createTime DATE,
 credit_card_id INT NOT NULL
);

ALTER TABLE PaymentTransaction ADD CONSTRAINT PK_PaymentTransaction PRIMARY KEY (id);


CREATE TABLE TypeShipping (
 id INT NOT NULL,
 name VARCHAR(45),
 description VARCHAR(100)
);

ALTER TABLE TypeShipping ADD CONSTRAINT PK_TypeShipping PRIMARY KEY (id);


CREATE TABLE TypeShippingMedia (
 id INT NOT NULL,
 shippingAddress VARCHAR(45),
 media_id INT NOT NULL,
 typeShippng_id INT NOT NULL
);

ALTER TABLE TypeShippingMedia ADD CONSTRAINT PK_TypeShippingMedia PRIMARY KEY (id);


CREATE TABLE Book (
 id INT NOT NULL,
 authors VARCHAR(45),
 cover VARCHAR(45),
 publisher VARCHAR(45),
 publicationDate DATE,
 language VARCHAR(45),
 pageNumber INT,
 genres VARCHAR(45),
 media_id INT NOT NULL
);

ALTER TABLE Book ADD CONSTRAINT PK_Book PRIMARY KEY (id);


CREATE TABLE CD (
 id INT NOT NULL,
 musciColection VARCHAR(45),
 CDAlbum VARCHAR(45),
 artists VARCHAR(45),
 recordLabels VARCHAR(45),
 trackList VARCHAR(45),
 genres VARCHAR(45),
 media_id INT NOT NULL
);

ALTER TABLE CD ADD CONSTRAINT PK_CD PRIMARY KEY (id);


CREATE TABLE DVD (
 id INT NOT NULL,
 discFormate VARCHAR(45),
 director VARCHAR(45),
 runTime INT,
 media_id INT NOT NULL,
 studio VARCHAR(45),
 language VARCHAR(45),
 subtitles VARCHAR(45),
 releaseDate DATE,
 genres VARCHAR(45)
);

ALTER TABLE DVD ADD CONSTRAINT PK_DVD PRIMARY KEY (id);


CREATE TABLE Invoice (
 id INT NOT NULL,
 totalAmount INT,
 order_id INT NOT NULL,
 paymentTransaction_id INT
);

ALTER TABLE Invoice ADD CONSTRAINT PK_Invoice PRIMARY KEY (id);


ALTER TABLE Order ADD CONSTRAINT FK_Order_0 FOREIGN KEY (customerInfo_id) REFERENCES User (id);


ALTER TABLE OrderMedia ADD CONSTRAINT FK_OrderMedia_0 FOREIGN KEY (media_id) REFERENCES Media (id);
ALTER TABLE OrderMedia ADD CONSTRAINT FK_OrderMedia_1 FOREIGN KEY (order_id) REFERENCES Order (id);


ALTER TABLE PaymentTransaction ADD CONSTRAINT FK_PaymentTransaction_0 FOREIGN KEY (credit_card_id) REFERENCES CreditCard (id);


ALTER TABLE TypeShippingMedia ADD CONSTRAINT FK_TypeShippingMedia_0 FOREIGN KEY (media_id) REFERENCES Media (id);
ALTER TABLE TypeShippingMedia ADD CONSTRAINT FK_TypeShippingMedia_1 FOREIGN KEY (typeShippng_id) REFERENCES TypeShipping (id);


ALTER TABLE Book ADD CONSTRAINT FK_Book_0 FOREIGN KEY (media_id) REFERENCES Media (id);


ALTER TABLE CD ADD CONSTRAINT FK_CD_0 FOREIGN KEY (media_id) REFERENCES Media (id);


ALTER TABLE DVD ADD CONSTRAINT FK_DVD_0 FOREIGN KEY (media_id) REFERENCES Media (id);


ALTER TABLE Invoice ADD CONSTRAINT FK_Invoice_0 FOREIGN KEY (order_id) REFERENCES Order (id);
ALTER TABLE Invoice ADD CONSTRAINT FK_Invoice_1 FOREIGN KEY (paymentTransaction_id) REFERENCES PaymentTransaction (id);


