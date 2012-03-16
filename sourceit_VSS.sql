-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 15, 2012 at 07:34 PM
-- Server version: 5.1.61
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sourceit_VSS`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` text,
  `store number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `location`, `store number`) VALUES
(1, '830 Industrial Avenue, Ottawa, ON K1G 4B8', 32),
(2, '3658 east 33nd lane', 556),
(3, '18108 Farlinger Crt, Cornwall, ON K6H 5R5', 15),
(4, '2359 east 29th court', 442),
(5, '748 Bath Rd, Kingston, ON K7M 4Y2', 18),
(6, '12569 north 18th street', 69),
(7, '516 Bryne Drive, Barrie, ON L4N 9P6', 25),
(8, '5655 west 25th court', 65),
(9, '263 Queen Street East,Brampton, ON L6W 4K6', 21),
(10, '22585 northeast 21st lane', 10),
(11, '350 Princess Street, Kingston, ON K7L 1B6', 1321),
(12, '3252 south 22nd place', 98),
(13, '720 Burnhamthorpe Rd. W, Unit 29 - 30,\r\nMississauga, ONL5C 3G1', 21),
(14, '1125 Colonel By Drive, Ottawa, ON K1S 5B6', 891),
(15, '382 Rideau St ,Ottawa, ON K1N 5Y8', 33);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `phoneNumber` bigint(10) DEFAULT NULL,
  `address` text,
  `email` text,
  `status` set('active','on holiday','inactive') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `phoneNumber`, `address`, `email`, `status`) VALUES
(1, 'John Wilson', 6138486259, '98 Woodridge Crescent', 'johnw@companyemail.com', 'on holiday'),
(2, 'Henry Wilcox', 6132526898, '1000 Castle Hill Crescent', 'henryw@companyemail.com', 'on holiday'),
(3, 'Jason Emerich', 3021569985, '55241 northwest 1st lane', 'jasone@companyemail.com', 'inactive'),
(4, 'John Tanning', 4500236998, '965 east 90th avenue', 'johnt@companyemail.com', 'active'),
(5, 'Charles Tate', 2563250001, '434 east 25th court', 'charlest@companyemail.com', 'active'),
(6, 'Shane Jackson', 8195198457, '10 Deerfield Drive', 'shanej@companyemail.com', 'active'),
(7, 'Emily Wright', 4205698659, '2415 west 22nd avenue', 'emilyw@companyemail.com', 'active'),
(8, 'Joanne Summers', 9059956536, '2700 Aquitaine Avenue', 'Joannes@companyemail.com', 'inactive'),
(9, 'Rachel Winters', 9053567896, '1229 Marlborough Court ', 'rachelw@companyemail.com', 'inactive'),
(10, 'Jake Lazars', 2203612036, '112 north 20th road', 'jakel@companyemail.com', 'on holiday'),
(11, 'Johnny Dewmont', 2301269854, '2214 east 55th lane', 'johnnyd@companyemail.com', 'inactive'),
(12, 'Christian Latoya', 6478583695, '177 Jameson Avenue', 'christianl@companyemail.com', 'active'),
(13, 'Angeline Brown', 4168523698, '150 Roehampton Avenue', 'angieb@companyemail.com', 'active'),
(14, 'Raymond Jackson', 9998542019, '44854 south 33rd lane', 'rayj@companyemail.com', 'on holiday'),
(15, 'Marry Steiner', 6477523698, '2700 Aquitaine Avenue', 'marrys@companyemail.com', 'on holiday'),
(16, 'Joshua Mason', 3200259684, '3325 west 54th street', 'joshm@companyemail.com', 'active'),
(17, 'Emile Augustine', 4163257894, '61 Yorkville Avenue', 'emilea@companyemail.com', 'active'),
(18, 'Christopher Rodriguez', 2147483647, '3891 northwest 7th road', 'chrisr@companyemail.com', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
CREATE TABLE IF NOT EXISTS `games` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text,
  `rating` text NOT NULL,
  `category` text NOT NULL,
  `developer` text NOT NULL,
  `publisher` text NOT NULL,
  `system` set('PS3','Xbox 360') NOT NULL,
  `noOfCopies` int(11) NOT NULL,
  `rentalPrice` int(11) NOT NULL DEFAULT '6',
  `purchasePrice` int(11) NOT NULL DEFAULT '45',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`id`, `title`, `rating`, `category`, `developer`, `publisher`, `system`, `noOfCopies`, `rentalPrice`, `purchasePrice`) VALUES
(1, 'The Elder Scrolls V: Skyrim', 'M', 'Role-Playing', 'Bethesda Game Studios', '2K Games', 'PS3,Xbox 360', 10, 6, 17),
(2, 'The Elder Scrolls IV: Oblivion', 'M', 'Role-playing', 'Bethesda Game Studios', '2k Games', 'PS3,Xbox 360', 10, 6, 17),
(3, 'Halo 3', 'M', 'First-person Shooter', 'Bungie', 'Microsoft Studios', 'Xbox 360', 10, 6, 17),
(4, 'Halo: Reach', 'M', 'First-person shooter', 'Bungie', 'Microsoft Studios', 'Xbox 360', 10, 6, 17),
(5, 'Halo 3: ODST', 'M', 'First-person shooter', 'Bungie', 'Microsoft Studios', 'Xbox 360', 10, 6, 17),
(6, 'Shadows of the Damned', 'M', 'Third-person shooter', 'Grasshopper Manufacture', 'Electronic Arts', 'PS3,Xbox 360', 10, 6, 17),
(7, 'Michael Jackson: The Experience', 'E10+', 'Dance', 'Ubisoft Montreal ', 'Ubisoft', 'PS3,Xbox 360', 10, 6, 17),
(8, 'Duke Nukem Forever', 'M', 'First-person shooter', 'Gearbox Software', '2K Games', 'PS3,Xbox 360', 10, 6, 17),
(9, 'Deus Ex: Human Revolution', 'M', 'Action role-playing', 'Eidos Montreal', 'Square Enix', 'PS3,Xbox 360', 10, 6, 17),
(10, 'Gears of War 3', 'M', 'Third-person shooter', 'Epic Games', 'Microsoft Studios', 'Xbox 360', 10, 6, 17),
(11, 'Gears of War 2', 'M', 'Third-person shooter', 'Epic Games', 'Microsoft Studios', 'Xbox 360', 10, 6, 17),
(12, 'Gears of War', 'M', 'Third-person shooter', 'Epic Games', 'Microsoft Studios', 'Xbox 360', 10, 6, 17),
(13, 'Bulletstorm', 'M', 'First-person shooter', 'People Can Fly', 'Electronic Arts', 'PS3,Xbox 360', 10, 6, 17),
(14, 'L.A. Noire', 'M', 'Open-world', 'Team Bondi', 'Rockstar Games', 'PS3,Xbox 360', 10, 6, 17),
(15, 'Call of Duty: Modern Warfare 3', 'M', 'First-person shooter', 'Sledgehammer Games', 'Activision', 'PS3,Xbox 360', 10, 6, 17),
(16, 'Call of Duty: Modern Warfare 2', 'M', 'First-person shooter', 'Infinity Ward', 'Activision', 'PS3,Xbox 360', 10, 6, 17),
(17, 'Call of Duty 4: Modern Warfare', 'M', 'First-person shooter', 'Infinity Ward', 'Activision', 'PS3,Xbox 360', 10, 6, 17),
(18, 'Call of Duty: Black Ops', 'M', 'First-person shooter', 'Treyarch', 'Activision', 'PS3,Xbox 360', 10, 6, 17),
(19, 'Call of Duty: World at War', 'M', 'First-person shooter', 'Treyarch', 'Activision', 'PS3,Xbox 360', 10, 6, 17),
(20, 'Infamous 2', 'T', 'Open-world', 'Sucker Punch Productions', 'Sony Computer Entertainment', 'PS3', 10, 6, 17),
(21, 'Grand Theft Auto IV', 'M', 'Open-world', 'Rosckstar North', 'Rockstar', 'PS3,Xbox 360', 10, 6, 17),
(22, 'Killzone 3', 'M', 'First-person shooter', 'Guerrilla Games', 'Sony Computer Entertainment', 'PS3', 10, 6, 17),
(23, 'Assassin''s Creed: Revelations', 'M', 'Stealth', 'Ubisoft Montreal', 'Ubisoft', 'PS3,Xbox 360', 10, 6, 17),
(24, 'Assassin''s Creed: Brotherhood', 'M', 'Stealth', 'Ubisoft Montreal', 'Ubisoft', 'PS3,Xbox 360', 10, 6, 17),
(25, 'Tom Clancy''s Splinter Cell: Conviction', 'M', 'Stealth', 'Ubisoft Montreal', 'Ubisoft', 'PS3,Xbox 360', 10, 6, 17);

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
CREATE TABLE IF NOT EXISTS `members` (
  `MemberID` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `email` text NOT NULL,
  `FirstName` text NOT NULL,
  `LastName` text NOT NULL,
  `Address` text NOT NULL,
  `PhoneNumber` bigint(10) NOT NULL,
  `currentItems` text NOT NULL,
  `pastItems` text NOT NULL,
  `reservations` text NOT NULL,
  PRIMARY KEY (`MemberID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`MemberID`, `email`, `FirstName`, `LastName`, `Address`, `PhoneNumber`, `currentItems`, `pastItems`, `reservations`) VALUES
(00001, 'johndoe@email.com', 'John', 'Doe', '311 Bell Street South', 6138514405, 'Halo 3', 'Gears of War 3, Gears of War 2', 'Halo: Reach'),
(00002, 'janesmith@email.com', 'Jane', 'Smith', '5685 West 24th Court', 1245412547, 'The Elder Scrolls V: Skyrim', 'Hanna, Duke Nukem Forever', 'Bulletstorm, Infamous 2, Inception'),
(00003, 'jackysaint@email.com', 'Jack', 'Santana', '180 Lees Avenue', 612527894, 'Fight Club, Inception', 'L.A. Noire, Duke Nukem Forever', 'X-Men: First Class, Halo 3'),
(00004, 'jennyar@email.com', 'Jenny', 'Ardak', '369 east 8th avenue', 1645416565, 'WALL·E, L.A. Noire', 'Halo 3, Halo: ODST', 'Duke Nukem Forever'),
(00005, 'artmick@email.com', 'Arthur', 'McKinley', '6521 south 6th lane', 6525849658, 'Shadows of the Damned', 'Gears of War, Bulletstorm, Se7en', 'Fight Club, Inception'),
(00006, 'mickeystant@email.com', 'Michael', 'Stanford', '150 Queen Elizabeth Drive', 6135654123, 'Inception, Pulp Fiction, The Matrix', 'Deus Ex: Human Revolution', 'Shadows of the Damned, Inception'),
(00007, 'pattyo@email.com', 'Patrick', 'O''Dwight', '1401 Prince of Wales Drive', 6132696541, 'The Dark Knight, Midnight In Paris', 'I Saw The Devil, Toy Story 3', 'The Departed, Call of Duty: Black Ops'),
(00008, 'carlossevara@email.com', 'Carlos', 'Sevara', '66589 south 9th lane', 4512369525, 'Duke Nukem Forever', 'Hobo With A Shotgun, The Descendants', 'The Elder Scrolls V: Skyrim, The Elder Scrolls IV: Oblivion'),
(00009, 'tonykovik@email.com', 'Anthony', 'Kovik', '241 west 12th avenue', 4152369852, 'Gears of War, Bulletstorm', 'Gears of War 2, The Shawshank Redemption', 'Gears of War 3'),
(00010, 'micht@email.com', 'Michelle', 'Taleela', '2600 Draper Avenue', 8193659874, 'The Departed', 'The Dark Knight', 'Shadows of the Damned, WALL·E'),
(00011, 'borisrasnov@email.com', 'Boris', 'Rasnov', '658 east 6th court', 1125966574, 'Toy Story 3, Infamous 2', 'Midnight In Paris', 'Michael Jackson: The Experience'),
(00012, 'harrietj@email.com', 'Harriet', 'Jameson', '6695 west 44th street', 5120321059, 'Deus Ex: Human Revolution, I Saw The Devil', 'The Descendants', 'Pulp Fiction'),
(00013, 'natfarrow@email.com', 'Natalie', 'Farrow', '1720 Baseline Road', 4163259632, 'Michael Jackson: The Experience', 'Fast Five, Infamous 2', 'Call of Duty: Black Ops'),
(00014, 'jenstanton@email.com', 'Jennifer', 'Stanton', '521 west 49th street', 3021578664, 'Call of Duty: Black Ops', 'Call of Duty: Modern Warfare 2', 'Call of Duty: Modern Warfare 3'),
(00015, 'melporter@email.com', 'Melissa', 'Porter', '320 Croydon Avenue', 9059973658, 'X-Men: First Class, Bridesmaids', 'Gears of War, Gears of War 2, Gears of War 3', 'Inception, The Matrix'),
(00016, 'jamescart@email.com', 'James', 'Cartwright', '8857 west 77th street', 1102369558, 'The Elder Scrolls IV: Oblivion, Halo: Reach', 'Fight Club, Bulletstorm', 'Deus Ex: Human Revolution, I Saw The Devil'),
(00017, 'christianw@email.com', 'Christian', 'Wellow', '2969 Fairlea Crescent', 4163524568, 'Saving Private Ryan, Se7en', 'The Matrix, Shadows of the Damned', 'The Dark Knight, Midnight In Paris');

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
CREATE TABLE IF NOT EXISTS `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` text NOT NULL,
  `Actors` text,
  `Director` text,
  `Rating` text,
  `Runtime` text,
  `Category` text,
  `Medium` set('BluRay','DVD') DEFAULT NULL,
  `noOfCopies` int(11) NOT NULL DEFAULT '10',
  `rentalPrice` int(11) DEFAULT '5',
  `purchasePrice` int(11) DEFAULT '35',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `Title`, `Actors`, `Director`, `Rating`, `Runtime`, `Category`, `Medium`, `noOfCopies`, `rentalPrice`, `purchasePrice`) VALUES
(1, 'Fast Five', 'Vin Diesel, Paul Walker, Jordana Brewster, Dwayne Johnson, Tyrese Gibson, Ludacris, Tego Calderón, Don Omar, Gal Gadot, Elsa Pataky', 'Justin Lin', '7.3', '130', 'Action', 'BluRay,DVD', 10, 5, 35),
(2, 'The Descendants', 'George Clooney, Shailene Woodley, Robert Forster, Judy Greer, Amara Miller, Beau Bridges, Matthew Lillard, Nick Krause', 'Alexander Payne', '8.0', '115', 'Comedy', 'BluRay,DVD', 6, 5, 35),
(3, 'Hobo With A Shotgun', 'Rutger Hauer, Molly Dunsworth, Brian Downey, Gregory Smith, Robb Wells', 'Jason Eisener', '6.3', '86', 'Thriller', 'BluRay,DVD', 10, 5, 35),
(4, 'Crazy, Stupid, Love', 'Steve Carell, Ryan Gosling, Julianne Moore, Emma Stone, Marisa Tomei, Analeigh Tipton, Jonah Bobo, Kevin Bacon', 'Glenn Ficcara and John Requa', '7.5', '118', 'Romance', 'BluRay,DVD', 5, 5, 35),
(5, 'Bridesmaids', 'Kristen Wiig, Maya Rudolph, Rose Byrne, Ellie Kemper, Melissa McCarthy, Jon Hamm, Wendi McLendon-Covey ', 'Paul Feig', '7.0', '125', 'Romance', 'BluRay,DVD', 8, 5, 35),
(6, 'Midnight In Paris', 'Owen Wilson, Rachel MacAdams, Michael Sheen, Marion Cotillard, Corey Stoll, Alison Pill, Tom Hiddleston, Kathy Bates, Adrien Brody, Lea Seydoux', 'Woody Allen', '7.8', '94', 'Comedy', 'BluRay,DVD', 10, 5, 35),
(7, 'Hanna', 'Saoirse Ronan, Eric Bana, Cate Blanchett, Jessica Barden, Olivia Williams, Jason Flemyng', 'Joe Wright', '6.9', '111', 'action', 'BluRay,DVD', 7, 5, 35),
(8, 'X-Men: First Class', 'James McAvoy, Michael Fassbender, Rose Byrne, Jennifer Lawrence, January Jones, Kevin Bacon, Nicholas Hoult, Lucas Till, Zoe Kravitz, Oliver Platt', 'Matthew Vaughn', '7.9', '132', 'Action', 'BluRay,DVD', 12, 5, 35),
(9, 'The Shawshank Redemption', 'Tim Robbins, Morgan Freeman, Bob Gunton, William Sadler', 'Frank Darabont', '9.2', '142', 'Drama', 'BluRay,DVD', 8, 5, 35),
(10, 'I Saw The Devil', 'Byung-hun Lee, Min-sik Choi, Gook-hwan Jeon, Ho-jin Jeon', 'Jee-woon Kim', '7.8', '141', 'Crime', 'BluRay,DVD', 6, 5, 35),
(11, 'Pulp Fiction', 'John Travolta, Uma Thurman, Samuel L. Jackson, Bruce Willis', 'Quentin Tarantino', '9.0', '168', 'Thriller', 'BluRay,DVD', 8, 5, 35),
(12, 'The Dark Knight', 'Christian Bale, Heath Ledger, Aaron Eckhart, Michael Caine', 'Christopher Nolan', '8.9', '152', 'Action', 'BluRay,DVD', 10, 5, 35),
(13, 'Fight Club', 'Brad Pitt, Edward Norton, Helena Bonham Carter, Meat Loaf', 'David Fincher', '8.8', '139', 'Drama', 'BluRay,DVD', 7, 5, 35),
(14, 'Inception', 'Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page, Ken Watanabe', 'Christopher Nolan', '8.9', '148', 'Thriller', 'BluRay,DVD', 5, 5, 35),
(15, 'The Matrix', 'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving', 'Andy Wachowski, Lana Wachowski', '8.7', '136', 'Sci-Fi', 'BluRay,DVD', 10, 5, 35),
(16, 'Se7en', 'Morgan Freeman, Brad Pitt, Kevin Spacey, Gwyneth Paltrow', 'David Fincher', '8.7', '127', 'Crime', 'BluRay,DVD', 8, 5, 35),
(17, 'Toy Story 3', 'Tom Hanks, Tim Allen, Joan Cusack, Ned Beatty', 'Lee Unkrich', '8.6', '103', 'Animation', 'BluRay,DVD', 12, 5, 35),
(18, 'Saving Private Ryan', 'Tom Hanks, Matt Damon, Tom Sizemore, Edward Burns', 'Steven Spielberg', '8.5', '169', 'War', 'BluRay,DVD', 10, 5, 35),
(19, 'WALL·E', 'Ben Burtt, Elissa Knight, Jeff Garlin, Fred Willard', 'Andrew Stanton', '8.5', '98', 'Animation', 'BluRay,DVD', 10, 5, 35),
(20, 'The Departed', 'Leonardo DiCaprio, Matt Damon, Jack Nicholson, Mark Wahlberg', 'Martin Scorsese', '8.5', '151', 'Crime', 'BluRay,DVD', 5, 5, 35),
(21, 'Men In Black', 'Tommy Lee Jones, Will Smith, Linda Fiorentino, Vincent D''Onofrio', 'Barry Sonnenfeld', '7.1', '98', 'Sci-Fi', 'BluRay,DVD', 8, 5, 35),
(22, 'Men In Black II', 'Tommy Lee Jones, Will Smith, Rip Torn, Lara Flynn Boyle', 'Barry Sonnenfeld', '5.7', '88', 'Sci-Fi', 'BluRay,DVD', 6, 5, 35),
(23, 'Back To The Future', 'Michael J. Fox, Christopher Lloyd, Lea Thompson, Crispin Glover', 'Robert Zemeckis', '8.4', '116', 'Sci-Fi', 'BluRay,DVD', 8, 5, 35),
(24, 'Back To The Future Part II', 'Michael J. Fox, Christopher Lloyd, Lea Thompson, Thomas F. Wilson', 'Robert Zemeckis', '7.6', '108', 'Sci-Fi', 'BluRay,DVD', 9, 5, 35),
(25, 'Back To The Future part III', 'Michael J. Fox, Christopher Lloyd, Mary Steenburgen, Thomas F. Wilson', 'Robert Zemeckis', '7.2', '118', 'Western', 'BluRay,DVD', 12, 5, 35);

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
CREATE TABLE IF NOT EXISTS `reservations` (
  `itemNo` int(11) NOT NULL AUTO_INCREMENT,
  `reservationDate` date DEFAULT NULL,
  `pickUp Date` date DEFAULT NULL,
  `MemberID` int(5) unsigned zerofill DEFAULT '00000',
  PRIMARY KEY (`itemNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`itemNo`, `reservationDate`, `pickUp Date`, `MemberID`) VALUES
(1, '2012-02-07', '2012-03-06', 00002),
(2, '2012-02-07', '2012-03-01', 00006),
(3, '2012-02-16', '2012-03-19', 00015),
(4, '2012-02-17', '2012-03-08', 00007),
(5, '2012-02-21', '2012-03-19', 00009),
(6, '2012-02-13', '2012-03-28', 00005),
(7, '2012-02-09', '2012-03-20', 00008),
(8, '2012-02-15', '2012-03-01', 00012),
(9, '2012-02-12', '2012-03-22', 00011),
(10, '2012-01-20', '2012-02-29', 00016),
(11, '2012-02-23', '2012-03-06', 00013),
(12, '2012-02-26', '2012-02-29', 00003),
(13, '2012-02-22', '2012-03-04', 00001),
(14, '2012-02-19', '2012-03-16', 00017),
(15, '2012-02-22', '2012-03-02', 00010),
(16, '2012-02-07', '2012-03-25', 00004),
(17, '2012-02-01', '2012-02-07', 00014);

-- --------------------------------------------------------

--
-- Table structure for table `searchdata`
--

DROP TABLE IF EXISTS `searchdata`;
CREATE TABLE IF NOT EXISTS `searchdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `searchdata`
--

INSERT INTO `searchdata` (`id`, `title`) VALUES
(1, 'Female Roleplaying Name Generator'),
(2, 'Ultimate FPS Name Generator'),
(3, 'The Superhero Name Generator'),
(4, 'The MMO Naminator');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `email` varchar(64) NOT NULL,
  `phone_number` varchar(16) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  `confirmcode` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `name`, `email`, `phone_number`, `username`, `password`, `confirmcode`) VALUES
(1, 'Ahmed', 'service_2006@hotmail.com', '', 'ahmed123', '296ab79bb0e6b305a21f964bd2ac8531', '8f1696292702387578be1fc805451634'),
(2, 'Ahmed123', 'ahmed1221_rashid@hotmail.com', '', 'ahmed1234', '93f17a6084f59242c9b41d23a3fbb3c7', 'y'),
(3, 'SALAM Group', 'ahmed123_rashid@hotmail.com', '', 'uzone', '37964f4140bc8bd6905b02e37dfe8c92', 'y'),
(4, 'Aniekan Akai', 'aeakai@yahoo.com', '', 'aeakai', '6da0d1237dc3551f881227ecd551aa91', 'y'),
(5, 'temp d', 'tullytv@hotmail.com', '', 'temp', 'b895772d1398a9f5022dd6718288c677', 'y');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
