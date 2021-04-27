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

