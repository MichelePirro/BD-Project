DROP DATABASE IF EXISTS campionato;
CREATE DATABASE campionato;
USE campionato;


CREATE TABLE campionato (
CodC varchar(30) NOT NULL,
NomeC varchar(30) NOT NULL,
PRIMARY KEY (CodC)
);

CREATE TABLE squadra (
CodS varchar(30) NOT NULL,
NomeS varchar(30) NOT NULL,
CodC varchar(30) NOT NULL,
Punti int Default 0,
GoalFatti int DEFAULT 0,
GoalSubiti int DEFAULT 0,
PRIMARY KEY (CodS),
KEY CodC (CodC),
FOREIGN KEY (CodC) REFERENCES campionato (CodC) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE allenamento (
CodAll varchar(30) NOT NULL,
Luogo varchar(30) NOT NULl,
Data date NOT NULL,
CodS varchar(30) NOT NULL,
PRIMARY KEY (CodAll),
FOREIGN KEY (CodS) REFERENCES squadra (CodS) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE giocatore (
  CodT varchar(30) NOT NULL,
  Nome varchar(30) NOT NULL,
  Cognome varchar(30) NOT NULL,
  Ruolo varchar(30) NOT NULL,
  Stipendio double NOT NULL,
  NumMaglia int(11) DEFAULT NULL,
  CodS varchar(30) DEFAULT NULL,
  PRIMARY KEY (CodT),
  KEY CodS (CodS),
  FOREIGN KEY (CodS) REFERENCES squadra (CodS) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE torneo (
  CodT varchar(30) NOT NULL,
  NomeT varchar(30) NOT NULL,
  PRIMARY KEY (CodT)
);

CREATE TABLE partecipat (
CodS varchar(30) NOT NULL,
CodT varchar(30) NOT NULL,
PRIMARY KEY (CodS,CodT),
KEY CodT (CodT),
FOREIGN KEY (CodS) REFERENCES squadra (CodS) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (CodT) REFERENCES torneo (CodT) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE arbitro (
CodAr varchar(30) NOT NULL ,
Nome varchar(30) NOT NULL,
Cognome varchar(30) NOT NULL,
Tipologia varchar(30) NOT NULL,
PRIMARY KEY (CodAr)
);

CREATE TABLE stadio (
CodST varchar(30) NOT NULL,
CostoBigl double NOT NULL,
PostiDisp int NOT NULL,
PostiOcc int NOT NULL,
PRIMARY KEY (CodST)
);

CREATE TABLE formazione (
CodF varchar(30) NOT NULL,
Modulo varchar(30) NOT NULL,
Sostituti int NOT NULL,
PRIMARY KEY (CodF)
);

CREATE TABLE partita (
CodP varchar(30) NOT NULL,
CodSCasa varchar(30) NOT NULL,
CodSTrasferta varchar(30) NOT NULL,
Data date NOT NULL,
GoalCasa int(11) DEFAULT NULL,
GoalTrasferta int(11) DEFAULT NULL,
NGiorn int(11) DEFAULT NULL,
NCartellini int (11) DEFAULT NULL, 
CodAr varchar(30) NOT NULL ,
CodST varchar(30) NOT NULL,
CodFCasa varchar(30) NOT NULL,
CodFTrasferta varchar(30) NOT NULL,
PRIMARY KEY (CodP,CodSCasa),
KEY CodSCasa (CodSCasa),
KEY CodSTrasferta (CodSTrasferta),
FOREIGN KEY (CodSCasa) REFERENCES squadra (CodS) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (CodSTrasferta) REFERENCES squadra (CodS) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (CodAr) REFERENCES arbitro (CodAr) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (CodST) REFERENCES stadio (CodST) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (CodFCasa) REFERENCES formazione (CodF) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (CodFTrasferta) REFERENCES formazione (CodF) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE allenatore (
CodT varchar(30) NOT NULL,
CodS varchar(30) NOT NULL,
Nome varchar(30) NOT NULL,
Cognome varchar(30) NOT NULL,
Stipendio double NOT NULL,
PRIMARY KEY (CodT,CodS),
KEY CodS ( CodS ),
FOREIGN KEY ( CodS ) REFERENCES squadra ( CodS ) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dirigenza (
CodDir varchar(30) NOT NULL,
CodT varchar(30) NOT NULL,
Sede varchar(30) NOT NULL,
NomeDir varchar(30) NOT NULL,
Durata int NOT NULL,
PRIMARY KEY (CodDir),
FOREIGN KEY (CodT)  REFERENCES allenatore (CodT) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE infortunio (
CodInf varchar(30) NOT NULL,
CodT varchar(30) NOT NULL,
Tipologia varchar(30) NOT NULL,
Gravita varchar(50) NOT NULL,
MedicoCurante varchar(30) NOT NULL,
PRIMARY KEY (CodInf),
FOREIGN KEY (CodT)  REFERENCES giocatore (CodT) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO campionato VALUES ('camp1','Serie A'),
('camp2','Ligue 1'),
('camp3','Premier League'),
('camp4','Liga BBVA'),
('camp5','Bundesliga'),
('camp6','Eredivisie');

INSERT INTO squadra VALUES ('eng1','Manchester City','camp3',0,34,14),
('eng2','Manchester United','camp3',0,36,24),
('eng3','Tottenham','camp3',0,35,28),
('eng4','Chealsea','camp3',0,32,45),
('eng5','Liverpool','camp3',0,52,65),
('eng6','West Ham','camp3',0,35,44),
('eng7','Southampton FC','camp3',0,12,55),
('fra1','Paris Saint Germain','camp2',0,34,5),
('fra2','OGC Nice','camp2',0,39,65),
('fra3','Saint Etienne','camp2',0,56,99),
('fra4','AS Monaco','camp2',0,67,34),
('fra5','Olympique Lione','camp2',0,27,26),
('fra6','Olympique Marseille','camp2',0,24,34),
('ger1','Bayern Monaco','camp5',0,14,36),
('ger2','Borussia Dortmund','camp5',0,24,17),
('ger3','Borussia Monchengladbach','camp5',0,23,34),
('ger4','Bayern Leverkusen','camp5',0,12,25),
('ger5','Red Bull Lipsia','camp5',0,12,23),
('ita1','Milan','camp1',0,34,45),
('ita2','Juventus','camp1',0,12,23),
('ita3','Napoli','camp1',0,24,34),
('ita4','Roma','camp1',0,32,5),
('ita5','Inter','camp1',0,33,25),
('ita6','Fiorentina','camp1',0,12,42),
('ita7','Sampdoria','camp1',0,33,44),
('ita8','Benevento','camp1',0,32,30),
('ita9','Atalanta','camp1',0,31,40),
('ola1','PSV Heindoven','camp6',0,22,55),
('ola2','Feeyenord','camp6',0,34,5),
('ola3','Ajax','camp6',0,52,35),
('spa1','Real Madrid','camp4',0,37,42),
('spa2','Barcellona','camp4',0,22,46),
('spa3','Atletico Madrid','camp4',0,34,42),
('spa4','Athletic Bilbao','camp4',0,22,35),
('spa5','Valencia','camp4',0,22,44),
('spa6','Siviglia FC','camp4',0,31,42);


INSERT INTO allenamento VALUES ('all1','Caixa Futebol Campos','2020-02-23','eng1'),
('all2','Säbener Strasse','2020-04-27','eng2'),
('all3','Ciutat Esportiva','2020-05-23','eng5'),
('all4','Chelsea Training Ground','2020-12-24','ita4'),
('all5','Milanello','2020-02-21','ger5'),
('all6','Ctfd PortoGaia','2020-06-05','eng4'),
('all7','Melwood','2020-04-17','ita8'),
('all8','Colney Training Centre','2020-08-16','ger3'),
('all9','Juventus Center','2020-12-13','eng6'),
('all10','Tottenham Training Centre','2020-10-03','spa1');

INSERT INTO giocatore VALUES ('geng11','Sergio','Aguero','Attaccante',1400000,10,'eng1'),
('geng110','Benjamin','Mendy','Difensore',900000,4,'eng1'),
('geng111','Ruben','Diaz','Difensore',800000,NULL,'eng1'),
('geng12','Kevin','De-Bruyne','Centrocampista',1400000,17,'eng1'),
('geng13','Gabriel','Jesus','Attaccante',1300000,9,'eng1'),
('geng14','Rodrigo-Hernández','Cascante','Centrocampista',1000000,16,'eng1'),
('geng15','Phil','Foden','Centrocampista',1100000,47,'eng1'),
('geng16','Raheem','Sterling','Centrocampista',1300000,7,'eng1'),
('geng17','Ederson','Moraes','Portiere',1000000,1,'eng1'),
('geng18','Vincent','Kompany','Difensore',1200000,2,'eng1'),
('geng19','John','Stones','Difensore',1000000,3,'eng1'),                                                      
('geng21','Largie','Ramazani','Attaccante',700000,59,'eng2'),
('geng210','Eric','Bailly','Difensore',900000,3,'eng2'),
('geng211','Victor','Lindelof','Difensore',750000,NULL,'eng2'),
('geng22','Paul','Pogba','Centrocampista',1600000,6,'eng2'),
('geng23','Daniel','James','Attaccante',140000,21,'eng2'),
('geng24','Anthony','Martial','Attaccante',1200000,9,'eng2'),
('geng25','Jesse','Lingard','Centrocampista',1000000,14,'eng2'),
('geng26','David','De-gea','Portiere',1200000,1,'eng2'),
('geng27','Marcus','Rashford','Attaccante',900000,10,'eng2'),
('geng28','Luke','Shaw','Difensore',800000,3,'eng2'),
('geng29','Diogo','Dalot','Difensore',1000000,20,'eng2'),
('geng31','Harry','Kane','Attaccante',1600000,10,'eng3'),
('geng310','Tody','Alderweireld','Difensore',850000,4,'eng3'),
('geng311','Ben','Davies','Difensore',550000,NULL,'eng3'),
('geng32','Son','Heung-Min','Attaccante',1200000,9,'eng3'),
('geng33','Dele','Alli','Centrocampista',1000000,11,'eng3'),
('geng34','Gedson','Fernandes','Centrocampista',900000,30,'eng3'),
('geng35','Giovani','Lo-Celso','Centrocampista',950000,18,'eng3'),
('geng36','Davinson','Sanchez','Difensore',600000,3,'eng3'),
('geng37','Hugo','Lloris','Portiere',1200000,1,'eng3'),
('geng38','Erik','Lamela','Centrocampista',1000000,6,'eng3'),
('geng39','Danny','Rose','Difensore',800000,2,'eng3'),
('gfra11','Junior','Neymar','Attaccante',2500000,10,'fra1'),
('gfra110','Mitchel','Bakker','Difensore',1600000,25,'fra1'),
('gfra111','Junior','Marquinhos','Difensore',950000,NULL,'fra1'),
('gfra12','Kylian','Mbappè','Attaccante',1900000,9,'fra1'),
('gfra13','Edinson','Cavani','Attaccante',1700000,9,'fra1'),
('gfra14','Angel','Di-Maria','Centrocampista',1500000,11,'fra1'),
('gfra15','Ander','Herrera','Centrocampista',1200000,21,'fra1'),
('gfra16','Pablo','Sarabia','Centrocampista',1000000,19,'fra1'),
('gfra17','Thiago','Silva','Difensore',1400000,2,'fra1'),
('gfra18','Marcin','Bulka','Portiere',1000000,30,'fra1'),
('gfra19','Layvin','Kurzawa','Difensore',1200000,3,'fra1'),
('gfra21','Kasper','Dolberg','Attaccante',1400000,9,'fra2'),
('gfra210','Pierre','Lees-Melou','Centrocampista',400000,8,'fra2'),
('gfra211','Arnaud','Lusamba','Centrocampista',150000,NULL,'fra2'),
('gfra22','Balthazar','Pierret','Centrocampista',1000000,34,'fra2'),
('gfra23','Wylan','Cyprien','Centrocampista',900000,11,'fra2'),
('gfra24','Costa','Dante','Difensore',800000,2,'fra2'),
('gfra25','Alexandre','Gameiro','Attaccante',900000,35,'fra2'),
('gfra26','Yoan','Cardinale','Portiere',600000,1,'fra2'),
('gfra27','Malang','Sarr','Difensore',400000,3,'fra2'),
('gfra28','Arnaud','Souquet','Difensore',600000,4,'fra2'),
('gfra29','Santos','Marlon','Difensore',250000,5,'fra2'),
('gfra31','Stèphane','Ruffier','Portiere',1000000,1,'fra3'),
('gfra310','Mathieu','Debuchy','Difensore',150000,26,'fra3'),
('gfra311','Leo','Lacroix','Difensore',100000,NULL,'fra3'),
('gfra32','Loic','Perrin','Difensore',800000,2,'fra3'),
('gfra33','Romain','Hamouma','Centrocampista',600000,6,'fra3'),
('gfra34','Sergi','Palencia','Difensore',250000,23,'fra3'),
('gfra35','Charles','Abi','Attaccante',300000,31,'fra3'),
('gfra36','Yann','Vila','Centrocampista',350000,8,'fra3'),
('gfra37','Bilal','Benkhedim','Centrocampista',360000,15,'fra3'),
('gfra38','Franck','Honorat','Attaccante',200000,14,'fra3'),
('gfra39','Wahbi','Khazri','Centrocampista',300000,10,'fra3'),
('gger11','James','Rodriguez','Centrocampista',1500000,10,'ger1'),
('gger110','Jerome','Boateng','Difensore',1400000,3,'ger1'),
('gger111','David','Alaba','Difensore',1300000,NULL,'ger1'),
('gger12','Robert','Lewandowski','Attaccante',1600000,9,'ger1'),
('gger13','Jamal','Musiala','Centrocampista',1600000,42,'ger1'),
('gger14','Manuel','Neuer','Portiere',1800000,1,'ger1'),
('gger15','Thomas','Muller','Attaccante',1700000,7,'ger1'),
('gger16','Javi','Martínez','Centrocampista',1600000,8,'ger1'),
('gger17','Joshua','Kimmich','Centrocampista',1500000,6,'ger1'),
('gger18','Leon','Goretzka','Centrocampista',1000000,5,'ger1'),
('gger19','Lucas','Hernández','Difensore',1300000,21,'ger1'),
('gger21','Youssoufa','Moukoko','Attaccante',1600000,18,'ger2'),
('gger210','Sokratis','Papastatopulos','Difensore',800000,4,'ger2'),
('gger211','Roman','Burki','Portiere',900000,NULL,'ger2'),
('gger22','Marco','Reus','Centrocampista',1500000,11,'ger2'),
('gger23','Mahmoud','Dahoud','Centrocampista',1300000,8,'ger2'),
('gger24','Jude','Bellingham','Centrocampista',1100000,22,'ger2'),
('gger25','Christian','Pulisic','Centrocampista',1000000,9,'ger2'),
('gger26','Erling','Håland','Attaccante',1200000,10,'ger2'),
('gger27','Andrè','Schurrle','Centrocampista',1200000,5,'ger2'),
('gger28','Raphaël','Guerreiro','Difensore',1000000,13,'ger2'),
('gger29','Manuel','Akanji','Difensore',900000,16,'ger2'),
('gger31','Hannes','Wolf','Attaccante',540000,11,'ger3'),
('gger310','Nico','Elvedi','Difensore',360000,4,'ger3'),
('gger311','Julio','Villalba','Attaccante',400000,NULL,'ger3'),
('gger32','Florian','Neuhaus','Centrocampista',450000,32,'ger3'),
('gger33','Christoph','Kramer','Centrocampista',400000,11,'ger3'),
('gger34','Lars','Stindl','Centrocampista',350000,8,'ger3'),
('gger35','Yann','Sommer','Portiere',500000,1,'ger3'),
('gger36','Michael','Lang','Difensore',500000,3,'ger3'),
('gger37','Ibrahima','Traorè','Centrocampista',600000,5,'ger3'),
('gger38','Torben','Müsel','Centrocampista',300000,26,'ger3'),
('gger39','Oscar','Wendt','Difensore',400000,3,'ger3'),
('gita11','Rafael','Leão','Attaccante',1000000,17,'ita1'),
('gita110','Theo','Hernández','Difensore',1200000,19,'ita1'),
('gita111','Diogo','Dalot','Difensore',700000,NULL,'ita1'),
('gita12','Hakan','Çalhanoğlu','Centrocampista',1100000,10,'ita1'),
('gita13','Alexis','Saelemaekers','Centrocampista',1200000,56,'ita1'),
('gita14','Giacomo','Olzer','Centrocampista',1000000,92,'ita1'),
('gita15','Samu','Castillejo','Attaccante',800000,7,'ita1'),
('gita16','Zlatan','Ibrahimović','Attaccante',900000,11,'ita1'),
('gita17','Davide','Calabria','Difensore',600000,3,'ita1'),
('gita18','Andrea','Conti','Difensore',1600000,14,'ita1'),
('gita19','Gianluigi','Donnarumma','Portiere',1800000,99,'ita1'),
('gita21','Wojciech','Szczęsny','Portiere',2000000,1,'ita2'),
('gita210','Alex','Sandro','Difensore',1500000,7,'ita2'),
('gita211','Merih','Demiral','Difensore',650000,NULL,'ita2'),
('gita22','Federico','Bernardeschi','Attaccante',2100000,33,'ita2'),
('gita23','Paulo','Dybala','Attaccante',1800000,10,'ita2'),
('gita24','Cristiano','Ronaldo','Attaccante',15000000,7,'ita2'),
('gita25','Rodrigo','Bentancur','Centrocampista',1400000,30,'ita2'),
('gita26','Blaise','Matuidi','Centrocampista',1200000,6,'ita2'),
('gita27','Alessandro','Riccio','Centrocampista',1500000,47,'ita2'),
('gita28','Giorgio','Chiellini','Difensore',1600000,3,'ita2'),
('gita29','Matthijs','de-Ligt','Difensore',1200000,4,'ita2'),
('gita31','Lorenzo','Insigne','Attaccante',1750000,24,'ita3'),
('gita310','Giovanni','Di-Lorenzo','Difensore',1300000,22,'ita3'),
('gita311','David','Ospina','Portiere',1500000,NULL,'ita3'),
('gita32','Dries','Mertens','Attaccante',1600000,14,'ita3'),
('gita33','Matteo','Politano','Attaccante',1500000,21,'ita3'),
('gita34','Piotr','Zielinski','Centrocampista',1200000,20,'ita3'),
('gita35','Fabián','Ruiz','Centrocampista',1600000,8,'ita3'),
('gita36','Eljif','Elmas','Centrocampista',1300000,7,'ita3'),
('gita37','Mario','Rui','Difensore',700000,3,'ita3'),
('gita38','Kalidou','Koulybali','Difensore',1400000,26,'ita3'),
('gita39','Kévin','Malcuit','Difensore',1200000,2,'ita3'),
('gola11','Hirving','Lozano','Attaccante',700000,11,'ola1'),
('gola110','Daniel','Schwaab','Difensore',230000,6,'ola1'),
('gola111','Albert','Guomundsson','Centrocampista',120000,NULL,'ola1'),
('gola12','Luuk','de-Jong','Attaccante',540000,10,'ola1'),
('gola13','Maximiliano','Romero','Attaccante',600000,9,'ola1'),
('gola14','Marco','Van-Ginkel','Centrocampista',500000,8,'ola1'),
('gola15','Jeroen','Zoet','Portiere',450000,1,'ola1'),
('gola16','Santiago','Arias','Difensore',500000,2,'ola1'),
('gola17','Nicolas','Isimat-Mirin','Difensore',230000,3,'ola1'),
('gola18','Jorrit','Hendrix','Centrocampista',400000,4,'ola1'),
('gola19','Joshua','Brenet','Difensore',400000,5,'ola1'),
('gspa11','Eden','Hazard','Attaccante',3000000,7,'spa1'),
('gspa110','Andrij','Carvajal','Difensore',1900000,5,'spa1'),
('gspa111','Thibaut','Courtois','Portiere',1500000,NULL,'spa1'),
('gspa12','Karim','Benzema','Attaccante',2900000,11,'spa1'),
('gspa13','Gareth','Bale','Attaccante',2500000,10,'spa1'),
('gspa14','Luka','Modric','Centrocampista',2200000,8,'spa1'),
('gspa15','Tony','Kroos','Centrocampista',2400000,9,'spa1'),
('gspa16','Carlos','Casemiro','Centrocampista',2000000,6,'spa1'),
('gspa17','Sergio','Ramos','Difensore',2500000,2,'spa1'),
('gspa18','Raphael','Varane','Difensore',2000000,3,'spa1'),
('gspa19','Junior','Marcelo','Difensore',2000000,4,'spa1'),
('gspa21','Lionel','Messi','Attaccante',3100000,10,'spa2'),
('gspa210','Marc-Andrè','Ter-Stegen','Portiere',2000000,1,'spa2'),
('gspa211','Sergi','Roberto','Difensore',1200000,NULL,'spa2'),
('gspa22','Luis','Suarez','Attaccante',3000000,9,'spa2'),
('gspa23','Ousmane','Dembélé','Attaccante',1500000,11,'spa2'),
('gspa24','Sergio','Busquets','Centrocampista',1500000,5,'spa2'),
('gspa25','Carles','Aleñá','Centrocampista',1700000,6,'spa2'),
('gspa26','Miralem','Pjanic','Centrocampista',2400000,8,'spa2'),
('gspa27','Jordi','Alba','Difensore',2000000,5,'spa2'),
('gspa28','Gerard','Pique','Difensore',2100000,2,'spa2'),
('gspa29','Samuel','Umtiti','Difensore',1300000,3,'spa2'),
('gspa31','Antoine','Griezmann','Attaccante',2000000,10,'spa3'),
('gspa310','Jose','Gimenez','Difensore',1000000,4,'spa3'),
('gspa311','Francisco','Juan','Difensore',932000,NULL,'spa3'),
('gspa32','Diego','Costa','Attaccante',1500000,11,'spa3'),
('gspa33','Fernando','Torres','Attaccante',1600000,9,'spa3'),
('gspa34','Yannick','Carrasco','Centrocampista',1200000,7,'spa3'),
('gspa35','Sergio','Koke','Centrocampista',1300000,8,'spa3'),
('gspa36','Saul','Niguez','Centrocampista',1400000,6,'spa3'),
('gspa37','Jan','Oblak','Portiere',1900000,1,'spa3'),
('gspa38','Diego','Godin','Difensore',1600000,2,'spa3'),
('gspa39','Filipe','Luis','Difensore',1200000,3,'spa3'),
('svin1','Bacary','Sagna','Difensore',40000.3,NULL,NULL);


INSERT INTO torneo VALUES ('torn1','Champions League'),
('torn2','Europa League'),
('torn3','Coppa Italia'),
('torn4','FA Cup'),
('torn5','International Cup'),
('torn6','Supercoppa Italiana'),
('torn7','Internation SuperCup'),
('torn8','Copa del Rey');

INSERT INTO partecipat VALUES ('eng1','torn1'),
('eng2','torn1'),
('eng3','torn1'),
('fra1','torn1'),
('fra2','torn1'),
('ger1','torn1'),
('ger2','torn1'),
('ita1','torn1'),
('ita2','torn1'),
('ita3','torn1'),
('ola1','torn1'),
('spa1','torn1'),
('spa2','torn1'),
('spa3','torn1'),
('eng3','torn2'),
('eng4','torn2'),
('eng5','torn2'),
('fra2','torn2'),
('fra3','torn2'),
('fra4','torn2'),
('ger2','torn2'),
('ger3','torn2'),
('ger4','torn2'),
('ita3','torn2'),
('ita4','torn2'),
('ita5','torn2'),
('ola1','torn2'),
('ola2','torn2'),
('spa3','torn2'),
('spa4','torn2'),
('spa5','torn2'),
('ita1','torn3'),
('ita2','torn3'),
('ita3','torn3'),
('ita4','torn3'),
('ita5','torn3'),
('ita6','torn3'),
('ita7','torn3'),
('ita8','torn3'),
('eng1','torn4'),
('eng2','torn4'),
('eng3','torn4'),
('eng4','torn4'),
('eng6','torn4'),
('eng7','torn4'),
('eng1','torn5'),
('fra1','torn5'),
('ger1','torn5'),
('ita1','torn5'),
('ita3','torn5'),
('ola1','torn5'),
('spa1','torn5'),
('ita1','torn6'),
('ita2','torn6'),
('ita3','torn6'),
('ita4','torn6'),
('ita2','torn7'),
('ita3','torn7'),
('spa1','torn7'),
('spa2','torn7');

INSERT INTO arbitro VALUES ('arb1','Filippo','Meli','guardalinea'),
('arb2','Anthony','Taylor','guardalinea'),
('arb3','Felix ','Brych','quartouomo'),
('arb4','Carlos ','Del Cerro Grande','guardalinea'),
('arb5','Björn ','Kuipers','guardalinea'),
('arb6','Daniele','Orsato','quartouomo'),
('arb7','Gianluca','Rocchi','guardalinea'),
('arb8','Daniel','Siebert','direttore-di-gara'),
('arb9','Srđan','Jovanović','guardalinea'),
('arb10','Marco','Guida','quartouomo'),
('arb11','Georgi ','Kabakov','direttore-di-gara'),
('arb12','William','Collum','direttore-di-gara'),
('arb13','Alessandro','Giallatini','guardalinea'),
('arb14','Hessel','Steegstra','guardalinea'),
('arb15','Cyril','Gringore','direttore-di-gara');

INSERT INTO stadio VALUES('Camp Nou',10.00,99000,28000),
('Wembley Stadium',20.00,90000,23000),
('Croke Park',25.00,82000,27000),
('Twickenham Stadium',15.00,82000,12000),
('Signal Iduna Park',34.00,60000,19000),
('Stade de France',71.00,81000,9000),
('Stadio Santiago Bernabéu',23.00,81000,38000),
('Stadio Giuseppe Meazza',4.00,78000,6000),
('Stadio Diego Armando Maradona',14.00,55000,98000),
('Stadio San Paolo',20.00,55000,18000);

INSERT INTO formazione VALUES('for1','4-4-2',10),
('for2','4-3-3',15),
('for3','3-5-2',14),
('for4','4-4-2',17),
('for5','4-3-3',5),
('for6','3-4-3',10),
('for7','5-3-2',12),
('for8','4-4-2',20),
('for9','4-3-3',8),
('for10','4-3-3',16),
('for11','4-3-3',14);


INSERT INTO partita VALUES ('part1','eng1','eng2','2020-01-15',3,1,7,NULL,'arb1','Camp Nou','for8','for7'),
('part10','spa1','eng1','2020-01-18',5,4,NULL,3,'arb4','Stadio Giuseppe Meazza','for2','for5'),
('part11','ita8','ita7','2020-05-10',0,3,37,4,'arb6','Stadio San Paolo','for3','for6'),
('part14','eng3','eng1','2021-10-22',0,4,5,NULL,'arb8','Stade de France','for6','for4'),
('part15','ola1','ita3','2021-03-12',3,4,NULL,3,'arb9','Signal Iduna Park','for4','for5'),
('part8','ola1','ola2','2020-11-11',3,1,7,5,'arb3','Twickenham Stadium','for8','for9'),
('part9','ola2','ola3','2020-12-12',4,3,11,2,'arb2','Croke Park','for7','for11'),
('part16','ita1','ita2','2020-12-12',3,3,11,2,'arb2','Croke Park','for7','for11');


INSERT INTO allenatore VALUES ('aeng1','eng1','Bep','Guardiola',1100000.03),
('aeng2','eng2','Ole-Gunnar','Solskjær',1100000.22),
('aeng3','eng3','Jose','Mourinho',930000.9),
('aeng4','eng4','Frank','Lampard',1400000),
('aeng5','eng5','Jurgen','Klopp',800000),
('aeng6','eng6','David','Moyes',550000),
('afra1','fra1','Thomas','Tuchel',2000000),
('afra2','fra2','Patrick','Vieira',700000),
('afra3','fra3','Claude','Puel',250000),
('afra4','fra4','Niko','Kovač',900000),
('afra5','fra5','Rudi','Garcia',300000),
('afra6','fra6','André','Villas-Boas',250000),
('ager1','ger1','Hans-Dieter','Flick',1200000),
('ager2','ger2','Lucien','Favre',800000),
('ager3','ger3','Marco','Rose',400000),
('ager4','ger4','Peter','Bosz',400000),
('ager5','ger5','Julian','Nagelsmann',600000),
('aita1','ita1','Stefano','Pioli',1000000),
('aita2','ita2','Andrea','Pirlo',1200000),
('aita3','ita3','Gennaro','Gattuso',800000),
('aita4','ita4','Paulo','Fonseca',800000),
('aita5','ita5','Antonio','Conte',1000000),
('aita6','ita6','Cesare','Prandelli',600000),
('aita7','ita7','Claudio','Ranieri',500000),
('aita8','ita8','Filippo','Inzaghi',200000),
('aita9','ita9','Gianpiero','Gasperini',100000),
('aola1','ola1','Roger','Schmidt',300000),
('aola2','ola2','Dick','Advocaat',200000),
('aola3','ola3','Erik','ten-Hag',300000),
('aspa1','spa1','Zinedine','Zidane',2000000),
('aspa2','spa2','Ronald','Koeman',2000000),
('aspa3','spa3','Diego','Simeone',1000000),
('aspa4','spa4','Gaizka','Garitano',700000),
('aspa5','spa5','Javi','Gracia',700000),
('aspa6','spa6','Julen','Lopetegui',560000.5);

INSERT INTO dirigenza VALUES ('dir1','aeng1','Napoli','De Laurentis',180),
('dir7','ager5','Barcellona','Pochettino',365),
('dir2','aita7','Milan','Stanley Kroenke',1095),
('dir3','aita2','Cophenaghen','Philip Anschutz',730),
('dir6','aspa6','Parigi','Nasser-Al-Khelaifi',1825),
('dir4','aspa1','Chelsea','Roman Abramovich',3650),
('dir5','aola3','Torino','Andrea Agnelli',2190),
('dir8','aola1','Liverpool','Dietrich Mateschitz',1095),
('dir9','ager2','Real Sociedad','bin Zayd Al Nahyan',2555),
('dir10','afra3','Real Madrid','François Pinault',180);

INSERT INTO infortunio VALUES ('inf1','gita11','ginocchio','alta','Michele Pirro'),
('inf2','gger14','ginocchio','alta','Simona Grilletto'),
('inf3','gfra11','gomito','media','MarcoSpagnuolo'),
('inf4','geng29','caviglia','bassa','Michele Rossi'),
('inf5','geng37','testa','alta','Giovanni Di Girolamo'),
('inf6','gita18','crociato','alta','Mario Rossi'),
('inf7','gola15','adduttore','media','Giuseppe Polese'),
('inf8','gola18','spalla','bassa','Carmine Gravino'),
('inf9','gspa310','piede','bassa','Filomena Ferrucci'),
('inf10','svin1','cuore','alta','Annalisa De Bonis');
