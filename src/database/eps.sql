-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2025 at 06:04 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eps`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `u_id` int(20) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `u_image` varchar(100) NOT NULL,
  `u_questions` varchar(50) NOT NULL,
  `u_answers` varchar(50) NOT NULL,
  `u_password` varchar(50) NOT NULL,
  `u_cpassword` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_type`, `u_username`, `u_status`, `u_image`, `u_questions`, `u_answers`, `u_password`, `u_cpassword`) VALUES
(16, 'Christian', 'Yongzon', 'cy@admin.com', 'Admin', 'admin', 'Active', '', 'What is your full name?', 'Christian', 'rJaJ4ickJwheNbnT4+i+2IyzQ0gotDuG/AWWytTG4nA=', 'rJaJ4ickJwheNbnT4+i+2IyzQ0gotDuG/AWWytTG4nA='),
(17, 'Miguel Zion', 'Yongzon', 'mig@emp.com', 'Employee', 'miguel', 'Pending', 'src/userImages/test2.jpg', '', '', 'PAIDsy0gxpdtlTzjd7H8L4ZUZ8NvyK07KGe98txtSnc=', 'PAIDsy0gxpdtlTzjd7H8L4ZUZ8NvyK07KGe98txtSnc='),
(18, 'Angel Mae', 'Segismar', 'as@as.emp', 'Employee', 'angel', 'Active', 'src/userImages/test3.jpg', 'What is your favorite pet?', 'bird', 'ZRSXDF7UwusxK8G7eZR3y7jGFsinmKGiixdWgPc4opk=', 'ZRSXDF7UwusxK8G7eZR3y7jGFsinmKGiixdWgPc4opk=');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `log_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `log_action` varchar(255) NOT NULL,
  `log_timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logs`
--

INSERT INTO `tbl_logs` (`log_id`, `user_id`, `log_action`, `log_timestamp`) VALUES
(1, 16, 'Updated user: miguel', '2025-03-27 15:25:59'),
(2, 16, 'Updated a user: miguel', '2025-03-27 15:37:33'),
(3, 16, 'Create a user: test', '2025-03-27 15:38:37'),
(4, 16, 'Updated a user: test', '2025-03-27 15:42:02'),
(6, 16, 'Deleted user ID: 19', '2025-03-27 16:16:14'),
(7, 16, 'Logged out', '2025-03-27 16:57:41');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`u_id`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `tbl_logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_admin` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
