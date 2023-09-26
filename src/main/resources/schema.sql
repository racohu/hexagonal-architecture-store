DROP TABLE IF EXISTS PRICE;

CREATE TABLE PRICE (
  BRAND_ID INT NOT NULL,
  START_DATE TIMESTAMP WITH TIME ZONE NOT NULL,
  END_DATE TIMESTAMP WITH TIME ZONE NOT NULL,
  PRICE_LIST INT PRIMARY KEY NOT NULL,
  PRODUCT_ID INT NOT NULL,
  PRIORITY INT NOT NULL,
  PRICE NUMERIC(8,2) NOT NULL,
  CURR VARCHAR(3) NOT NULL
);