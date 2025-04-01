-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2025 at 01:41 AM
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
-- Table structure for table `tbl_department`
--

CREATE TABLE `tbl_department` (
  `dep_id` int(11) NOT NULL,
  `dep_userid` int(11) NOT NULL,
  `dep_name` varchar(20) NOT NULL,
  `dep_totalemp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_department`
--

INSERT INTO `tbl_department` (`dep_id`, `dep_userid`, `dep_name`, `dep_totalemp`) VALUES
(6, 18, 'PC Tech', 20),
(7, 17, 'Admin', 12);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_employee`
--

CREATE TABLE `tbl_employee` (
  `emp_id` int(11) NOT NULL,
  `emp_userid` int(11) NOT NULL,
  `emp_depid` int(11) NOT NULL,
  `emp_position` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_employee`
--

INSERT INTO `tbl_employee` (`emp_id`, `emp_userid`, `emp_depid`, `emp_position`) VALUES
(7, 18, 7, 'HR Manager'),
(8, 17, 6, 'Data Analysiss');

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
(13, 16, 'Deleted Employee: 3', '2025-03-31 07:28:55'),
(14, 16, 'Deleted Employee: 4', '2025-03-31 07:29:02'),
(15, 16, 'Updated a user: angel', '2025-03-31 15:42:19'),
(16, 16, 'Deleted Department: 5', '2025-03-31 17:08:07'),
(17, 16, 'Deleted Department: PC Tech', '2025-03-31 17:13:03'),
(18, 16, 'Created a Departmen: PC Tech', '2025-03-31 17:25:39'),
(19, 16, 'Created a Departmen: Admin', '2025-03-31 17:26:00'),
(20, 16, 'Created a new Employee: 18', '2025-03-31 17:26:24'),
(21, 16, 'Created a new Employee: 17', '2025-03-31 17:26:58'),
(22, 16, 'Updated a Employee: 8', '2025-03-31 17:29:11');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_task`
--

CREATE TABLE `tbl_task` (
  `t_id` int(11) NOT NULL,
  `t_depid` int(11) NOT NULL,
  `t_empid` int(11) NOT NULL,
  `t_name` varchar(50) NOT NULL,
  `t_description` varchar(255) NOT NULL,
  `t_deadline` date NOT NULL,
  `t_status` varchar(10) NOT NULL,
  `t_progress` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`u_id`);

--
-- Indexes for table `tbl_department`
--
ALTER TABLE `tbl_department`
  ADD PRIMARY KEY (`dep_id`),
  ADD KEY `dep_userid` (`dep_userid`);

--
-- Indexes for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
  ADD PRIMARY KEY (`emp_id`),
  ADD KEY `emp_userid` (`emp_userid`),
  ADD KEY `emp_depid` (`emp_depid`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`user_id`);

--
-- Indexes for table `tbl_task`
--
ALTER TABLE `tbl_task`
  ADD PRIMARY KEY (`t_id`),
  ADD KEY `t_depid` (`t_depid`),
  ADD KEY `t_empid` (`t_empid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tbl_department`
--
ALTER TABLE `tbl_department`
  MODIFY `dep_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `tbl_task`
--
ALTER TABLE `tbl_task`
  MODIFY `t_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_department`
--
ALTER TABLE `tbl_department`
  ADD CONSTRAINT `tbl_department_ibfk_1` FOREIGN KEY (`dep_userid`) REFERENCES `tbl_admin` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
  ADD CONSTRAINT `tbl_employee_ibfk_1` FOREIGN KEY (`emp_userid`) REFERENCES `tbl_admin` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_employee_ibfk_2` FOREIGN KEY (`emp_depid`) REFERENCES `tbl_department` (`dep_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `tbl_logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_admin` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_task`
--
ALTER TABLE `tbl_task`
  ADD CONSTRAINT `tbl_task_ibfk_1` FOREIGN KEY (`t_depid`) REFERENCES `tbl_department` (`dep_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_task_ibfk_2` FOREIGN KEY (`t_empid`) REFERENCES `tbl_employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
