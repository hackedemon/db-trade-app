DROP TABLE IF EXISTS trade_book;

CREATE TABLE trade_book (
	trade_id VARCHAR(20) NOT NULL,
	version INT(10) NOT NULL,
	counter_party_id VARCHAR(20) NOT NULL,
	book_id VARCHAR(20) NOT NULL,
	maturity_date DATE NOT NULL,
	created_date DATE NOT NULL,
	expired BOOLEAN NOT NULL
);

INSERT INTO trade_book
VALUES (
	'T1',
	1,
	'CP-1',
	'B1',
	'2021-05-20',
	'2021-04-28',
	false
);
INSERT INTO trade_book
VALUES (
	'T2',
	2,
	'CP-2',
	'B1',
	'2021-05-20',
	'2021-04-28',
	false
);
INSERT INTO trade_book
VALUES (
	'T2',
	1,
	'CP-1',
	'B1',
	'2014-05-20',
	'2021-04-28',
	false
);
INSERT INTO trade_book
VALUES (
	'T3',
	3,
	'CP-3',
	'B2',
	'2014-05-20',
	'2021-04-28',
	true
);
