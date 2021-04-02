insert into User(userId, firstName, lastName, age, address, cardNumber, username, password, email, customerUser) values (USER_SEQ.nextval, 'Lucy', 'Smith', 17, '30 Harefield Lane', 4837381, 'lucyanne', 'java', 'lucy@anne.com', true);

insert into User(userId, firstName, lastName, age, address, cardNumber, username, password, email, customerUser) values (USER_SEQ.nextval, 'John', 'Jones', 20, '10 Harrow Vale', 2938345, 'jonny', 'ruby', 'jonny@jones.com', true);

insert into User(userId, firstName, lastName, age, address, cardNumber, username, password, email, customerUser) values (USER_SEQ.nextval, 'Billy', 'Rose', 28, '29 Green Street', 4823242, 'billy', 'javascript', 'billy@rose.com', true);

insert into User(userId, firstName, lastName, age, address, cardNumber, username, password, email, customerUser) values (USER_SEQ.nextval, 'Emily', 'Jackson', 39, '83 Flower Crescent', 3893890, 'adminemily', 'athenahack', 'emily@jackson.com', false);

insert into User(userId, firstName, lastName, age, address, cardNumber, username, password, email, customerUser) values (USER_SEQ.nextval, 'James', 'Fisher', 40, '40 Fisher Price Road', 5883473, 'james', 'fisherprice', 'james@fisher.com', true);

insert into store (storeId, name, location, phone) values (STORE_SEQ.nextval, 'Perfect Perfumes Westfield', 'Westfield', 45693847);

insert into store (storeId, name, location, phone) values (STORE_SEQ.nextval, 'Perfect Perfumes Oxford Street', 'Oxford Street', 4857283);

insert into store (storeId, name, location, phone) values (STORE_SEQ.nextval, 'Perfect Perfumes Brighton', 'Brighton', 9837482);

insert into store (storeId, name, location, phone) values (STORE_SEQ.nextval, 'Perfect Perfumes Meadowhall', 'MeadowHall', 7485837);

insert into store (storeId, name, location, phone) values (STORE_SEQ.nextval, 'Perfect Perfumes Manchester', 'Manchester', 3749492);

insert into store(storeId, name, location, phone) values (STORE_SEQ.nextval, 'Perfect Perfumes Manchester Arndale', 'Manchester Arndale', 58493049);

insert into store(storeId, name, location, phone) values (STORE_SEQ.nextval, 'Perfect Perfumes Kingston Bentalls Centre', 'Kingston', 58493049);

insert into perfume (perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'COCO MADEMOISELLE', 67.00, 'An oriental fragrance with a strong personality, yet surprisingly fresh', 50, 2001, 1);

insert into perfume (perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'Daisy', 59.00, 'Daisy is a sparkly floral-woody fragrance, fresh and feminine at the same time', 50, 2008, 4);


insert into perfume(perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'Midnight Fantasy', 20.00, 'In the top notes there are exotic framboise, black cherry, and plum', 100, 2006, 3);

insert into perfume(perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'Daisy Dream Forever', 57.93, 'Daisy Dream Forever is inspired by endless blue sky', 50, 2017, 4);

insert into perfume(perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'Fantasia', 29.95, 'Fantasias woodsy and floral fragrance conjures up sensuality, femininity, and mystery', 30, 2017, 6);


insert into perfume(perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'Bombshell', 69.37, 'Bombshell is a sparkling mix of fresh-cut peonies and afternoon sun', 100, 2010, 9);

insert into perfume(perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'Love', 69.37, 'A fresh fusion of aromatic Juniper Berries. Apricot Blush, a petally floral', 100, 2017, 9);

insert into perfume(perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'My Burberry Blush', 62.05, 'A blend of glazed pomegranate and vibrant lemon, and delicate rose petal notes', 50, 2014, 12);

insert into perfume(perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'Le Classique', 76.50, 'A wonderful mix of of Bergamot, rose, pear, star anise, mandarin orange, and orange blossom', 100, 1993, 8);

insert into perfume(perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'Olympéa Eau de Parfum', 70.50, 'A fresh oriental fragrance whose balance of the accords forms a genuine Paco Rabanne signature.', 80, 2015, 2);

insert into perfume(perfumeId, name, price, description, volume, yearReleased, brandid) values (PERFUME_SEQ.nextval, 'Woman', 30.60, 'A fruity floral fragrance with an unconventional boyish twist with Boysenberry, Mandarin, Iris, Black tea, Sandalwood, Cedarwood', 50, 2014, 5);

insert into Review (reviewId, title, body, dateOfReview, userId, perfumeId) values (REVIEW_SEQ.nextval, 'What a product!', 'I love this perfume, it smells so good', TO_DATE('2000/01/01', 'yyyy/mm/dd'), 1, 1);

insert into Review (reviewId, title, body, dateOfReview, userId, perfumeId) values (REVIEW_SEQ.nextval, 'Fabulous', 'Smells lush', TO_DATE('2000/01/01', 'yyyy/mm/dd'), 2, 1);

insert into Review (reviewId, title, body, dateOfReview, userId, perfumeId) values (REVIEW_SEQ.nextval, 'Brilliant', 'I will be buying this for my best friend', TO_DATE('2000/01/01', 'yyyy/mm/dd'), 3, 1);

insert into Basket (basketId, userId) values (BASKET_SEQ.nextval, 1);

insert into Basket (basketId, userId) values (BASKET_SEQ.nextval, 3);

insert into Basket (basketId, userId) values (BASKET_SEQ.nextval, 4);

insert into Basket (basketId, userId) values (BASKET_SEQ.nextval, 2);

insert into Basket (basketId, userId) values (BASKET_SEQ.nextval, 5);

insert into Checkout (checkoutId, basketId) values (CHECKOUT_SEQ.nextval, 1);

insert into Checkout (checkoutId, basketId) values (CHECKOUT_SEQ.nextval, 2);

insert into Checkout (checkoutId, basketId) values (CHECKOUT_SEQ.nextval, 3);

insert into Checkout (checkoutId, basketId) values (CHECKOUT_SEQ.nextval, 4);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (1,1);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (1,3);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (1,5);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (2,2);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (2,3);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (3,4);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (3,5);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (3,1);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (3,1);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (4,2);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (4,3);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (5,2);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (5,6);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (6,4);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (6,1);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (6,2);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (7,5);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (7,2);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (8,1);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (8,3);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (8,5);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (9,1);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (9,6);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (9,3);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (10,4);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (10,5);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (10,6);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (11,5);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (11,2);

insert into perfume_store(Perfume_perfumeId, Stores_storeId) values (11,3);

insert into basket_perfume (Basket_basketId, Perfumes_perfumeId) values (1,1);

insert into basket_perfume (Basket_basketId, Perfumes_perfumeId) values (1,6);

insert into basket_perfume (Basket_basketId, Perfumes_perfumeId) values (2,1);

insert into basket_perfume (Basket_basketId, Perfumes_perfumeId) values (2,2);

insert into basket_perfume (Basket_basketId, Perfumes_perfumeId) values (2,3);

insert into basket_perfume (Basket_basketId, Perfumes_perfumeId) values (2,4);

insert into basket_perfume (Basket_basketId, Perfumes_perfumeId) values (3,1);

insert into basket_perfume (Basket_basketId, Perfumes_perfumeId) values (3,7);

insert into basket_perfume (Basket_basketId, Perfumes_perfumeId) values (3,8);

insert into basket_perfume (Basket_basketId, Perfumes_perfumeId) values (3,9);
