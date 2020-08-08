DROP DATABASE IF EXISTS content;

CREATE DATABASE content;

USE content;

DROP TABLE IF EXISTS writers;

CREATE TABLE writers (
  username    varchar(16) PRIMARY KEY,
  password    varchar(16) NOT NULL,
  full_name   text
);

DROP TABLE IF EXISTS stories;

CREATE TABLE stories (
  id          int PRIMARY KEY auto_increment,
  writer      varchar(16) NOT NULL,            # FOREIGN KEY writers.username
  page        varchar(16) NOT NULL,            # FOREIGN KEY pages.code
  headline    text,
  story_text  text,
  picture     text,
  created     int,
  modified    int,
  published   int
);

DROP TABLE IF EXISTS pages;

CREATE TABLE pages (
  code        varchar(16) PRIMARY KEY,
  description text
);

DROP TABLE IF EXISTS writer_permissions;

CREATE TABLE writer_permissions (
  writer      varchar(16) NOT NULL,            # FOREIGN KEY writers.username
  page        varchar(16) NOT NULL             # FOREIGN KEY pages.code
);

DROP TABLE IF EXISTS keywords;

CREATE TABLE keywords (
  story       int NOT NULL,                    # FOREIGN KEY stories.id
  keyword     varchar(32) NOT NULL,
  weight      int NOT NULL
);



GRANT select, insert, update, delete
ON content.*
TO content@localhost identified by 'password';


insert into writers (username, password, full_name)
             values ('bob', password('password'), 'Robert Bobbins');

insert into writers (username, password, full_name)
             values ('bill', password('password'), 'William Billings');


insert into pages (code, description)
           values ('news', 'The Top News Stories From Around the World');

insert into pages (code, description)
           values ('sport', 'Sports Latest - All The Winners and Losers');

insert into pages (code, description)
           values ('weather', 'Up To The Minute Weather Reports and Forecasts');


insert into writer_permissions (writer, page) values ('bob', 'news');
insert into writer_permissions (writer, page) values ('bob', 'sport');

insert into writer_permissions (writer, page) values ('bill', 'news');
insert into writer_permissions (writer, page) values ('bill', 'weather');


insert into stories 
    (id, writer, page, headline, created, modified, published,
     story_text, picture)
values (1, 'bill', 'news', 'Man gives birth', 976573221, 976580154, 976570230,
   'A man today gave birth in a hospital on Staten Island, NY.  The baby boy weighed in at just over eight pounds and is doing well.  The parents were naturally overjoyed at the birth of their first son, and have have said they hope to have a large family.  <br /><br />Father Ted, 34, conceived using a new method known as paternatility whereby the fertilised embryo is transferred to the father\'s body at an early stage.  It is believed that this method reduces many of the risks of childbirth.', 'pictures/1.jpg');

insert into stories 
    (id, writer, page, headline, created, modified, published,
     story_text, picture)
values (2, 'bill', 'news', 'Fire!', 976562355, 976572203, 976570230,
    'Breaking news:  Reports are coming in of a fire in a barn somewhere in Arizona.  Our sources say the barn is very likely to burn to the ground and will not be economically viable to repair.<br /><br />A bystander is reputed to have said "There was quite a lot of smoke"', 'pictures/2.jpg');

insert into stories 
    (id, writer, page, headline, created, modified, published,
     story_text, picture)
values (3, 'bill', 'news', 'SFON Launch Party report', 976542355, 976542503, 976555650,
    'Yesterday has already gone down in history as the day the best news site on the web first hit the Internet.  Just to prove the point, there was a star-studded party last night at a secret location in Seattle.<br /><br />Joining our team for a boogie were several A-list celebs who wish to remain anonymous.', 'pictures/3.jpg');

insert into stories 
    (id, writer, page, headline, created, modified, published,
     story_text, picture)
values (4, 'bob', 'sport', 'World Crossword Championship Preview', 976531355, 976532503, 976533320,
    'It\'s now just three days to the start of the prestigious annual World Crossword Championship to be held this year for the first time live on the Internet.  The new media format will allow many more competitors than ever before to take part from the comfort of their own home, or from one of 126 regional centers.<br /><br />Last year\' champion is not keen on the new format.  She said "Crosswords should be done on paper, not online".', 'pictures/4.jpg');

insert into stories 
    (id, writer, page, headline, created, modified, published,
     story_text, picture)
values (5, 'bob', 'sport', 'Basketball is bad for you', 976542355, 976542503, 976555650,
    'Scientists believe that basketball can be bad for you.  Research has suggested that both watching and playing the game can have detrimental effects on your health.  The scientific evidence supporting this claim is currently being verified by our expert team and we will bring you updates as soon as we can.<br /><br />An NBA spokesperson said "That is complete rubbish".', 'pictures/5.jpg');

insert into stories 
    (id, writer, page, headline, created, modified, published,
     story_text, picture)
values (6, 'bill', 'weather', 'Storms to come', 976542355, 976542503,
976555650, 'It never rains but it pours.  When the rain comes in November there\'s gonna be a storm.<br /><br /> Meterologists predict rain, thunder, lightening and all the usual displeasures that you get during a period of inclement weather.  No word on a hurricane yet, but don\'t be surprised if we get one!', 'pictures/6.jpg');

insert into stories 
    (id, writer, page, headline, created, modified, published,
     story_text, picture)
values (7, 'bill', 'weather', 'Sun is shining, weather is sweet', 976451129, 976458734, 976458754,
    'The forecast for this weekend is good, with long spells of sunshine predicted in most areas.  The high temperature will be 96F and no rain is expected until November', '');

