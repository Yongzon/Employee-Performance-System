-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2025 at 12:54 PM
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
(16, 'Christian', 'Yongzon', 'cy@admin.com', 'Admin', 'admin', 'Active', '', 'What is your full name?', 'Christian', 'QeVlP8euuJQCbWu3stt/ZZArRUlF+o/WWmMnBHtSd/s=', 'QeVlP8euuJQCbWu3stt/ZZArRUlF+o/WWmMnBHtSd/s='),
(17, 'Miguel Zion', 'Yongzon', 'mig@emp.com', 'Employee', 'miguel', 'Active', 'src/userImages/test2.jpg', '', '', 'PAIDsy0gxpdtlTzjd7H8L4ZUZ8NvyK07KGe98txtSnc=', 'PAIDsy0gxpdtlTzjd7H8L4ZUZ8NvyK07KGe98txtSnc='),
(18, 'Angel Mae', 'Segismar', 'as@as.emp', 'Employee', 'angel', 'Active', 'src/userImages/test3.jpg', 'What is your favorite pet?', 'bird', 'ZRSXDF7UwusxK8G7eZR3y7jGFsinmKGiixdWgPc4opk=', 'ZRSXDF7UwusxK8G7eZR3y7jGFsinmKGiixdWgPc4opk='),
(20, 'Christian', 'Yongzon', 'cy@eval.com', 'Evaluator', 'yannie', 'Active', '', 'No stored security questions', 'No stored security answers', 'rJaJ4ickJwheNbnT4+i+2IyzQ0gotDuG/AWWytTG4nA=', 'rJaJ4ickJwheNbnT4+i+2IyzQ0gotDuG/AWWytTG4nA='),
(21, 'Christian', 'Yongzon', 'yannie@eval.com', 'Evaluator', 'Chan', 'Active', '', 'No stored security questions', 'No stored security answers', '3909n4h+AToWV3wdOnva01pkrVDryMlaKv6pXHxO0nE=', '3909n4h+AToWV3wdOnva01pkrVDryMlaKv6pXHxO0nE='),
(22, 'Ivan', 'Laluna', 'laluna@emp.com', 'Employee', 'laluna', 'Active', '', 'No stored security questions', 'No stored security answers', 'k36NX7tIvUlJU2zWW401xCa4DS+DDFwwjizexCKuIkQ=', 'k36NX7tIvUlJU2zWW401xCa4DS+DDFwwjizexCKuIkQ=');

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
(8, 17, 6, 'Data Analysiss'),
(9, 18, 6, 'test'),
(10, 22, 6, 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_evaluation`
--

CREATE TABLE `tbl_evaluation` (
  `evaluation_id` int(11) NOT NULL,
  `evaluation_tid` int(11) NOT NULL,
  `evaluation_revper` date NOT NULL,
  `evaluation_r1` int(11) NOT NULL,
  `evaluation_r2` int(11) NOT NULL,
  `evaluation_r3` int(11) NOT NULL,
  `evaluation_r4` int(11) NOT NULL,
  `evaluation_r5` int(11) NOT NULL,
  `evaluation_r6` int(11) NOT NULL,
  `evaluation_cm1` varchar(100) NOT NULL,
  `evaluation_cm2` varchar(100) NOT NULL,
  `evaluation_cm3` varchar(100) NOT NULL,
  `evaluation_cm4` varchar(100) NOT NULL,
  `evaluation_cm5` varchar(100) NOT NULL,
  `evaluation_cm6` varchar(100) NOT NULL,
  `evaluation_over1` int(11) NOT NULL,
  `evaluation_over2` int(11) NOT NULL,
  `evaluation_over3` int(11) NOT NULL,
  `evaluation_over4` int(11) NOT NULL,
  `evaluation_over5` int(11) NOT NULL,
  `evaluation_areaimprov` varchar(255) NOT NULL,
  `evaluation_status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_evaluation`
--

INSERT INTO `tbl_evaluation` (`evaluation_id`, `evaluation_tid`, `evaluation_revper`, `evaluation_r1`, `evaluation_r2`, `evaluation_r3`, `evaluation_r4`, `evaluation_r5`, `evaluation_r6`, `evaluation_cm1`, `evaluation_cm2`, `evaluation_cm3`, `evaluation_cm4`, `evaluation_cm5`, `evaluation_cm6`, `evaluation_over1`, `evaluation_over2`, `evaluation_over3`, `evaluation_over4`, `evaluation_over5`, `evaluation_areaimprov`, `evaluation_status`) VALUES
(3, 8, '2025-05-02', 5, 5, 5, 5, 5, 5, 'test', 'test', 'test', 'test', 'test', 'test', 0, 0, 0, 0, 5, 'test test test', 'Completed');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_evaluator`
--

CREATE TABLE `tbl_evaluator` (
  `eval_id` int(11) NOT NULL,
  `eval_userid` int(11) NOT NULL,
  `eval_depid` int(11) NOT NULL,
  `eval_position` varchar(200) NOT NULL,
  `eval_accesslvl` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_evaluator`
--

INSERT INTO `tbl_evaluator` (`eval_id`, `eval_userid`, `eval_depid`, `eval_position`, `eval_accesslvl`) VALUES
(1, 20, 6, 'Hr Manager', 'High'),
(2, 21, 6, 'IT Manager', 'High');

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
(22, 16, 'Updated a Employee: 8', '2025-03-31 17:29:11'),
(25, 18, 'User Login: Segismar', '2025-04-17 02:29:01'),
(26, 18, 'User Logout: Segismar', '2025-04-17 02:29:52'),
(27, 18, 'User Login: Segismar', '2025-04-17 02:43:03'),
(28, 18, 'User Logout: Segismar', '2025-04-17 02:43:39'),
(29, 18, 'User Login: Segismar', '2025-04-17 02:48:21'),
(30, 18, 'User Logout: Segismar', '2025-04-17 02:49:22'),
(31, 18, 'User Login: Segismar', '2025-04-17 16:52:39'),
(32, 18, 'User Logout: Segismar', '2025-04-17 16:52:57'),
(33, 18, 'User Login: Segismar', '2025-04-17 16:58:49'),
(34, 18, 'Create a user: yannie', '2025-04-17 17:00:43'),
(35, 18, 'User Login: Segismar', '2025-04-17 17:06:56'),
(36, 18, 'User Logout: Segismar', '2025-04-17 17:07:26'),
(37, 18, 'User Login: Segismar', '2025-04-17 17:08:42'),
(38, 18, 'User Login: Segismar', '2025-04-17 17:11:42'),
(39, 18, 'User Login: Segismar', '2025-04-17 17:13:03'),
(40, 18, 'Created a new Evaluator: 20', '2025-04-17 17:13:20'),
(41, 18, 'User Logout: Segismar', '2025-04-17 17:14:28'),
(42, 18, 'User Login: Segismar', '2025-04-17 17:17:45'),
(43, 18, 'User Login: Segismar', '2025-04-17 17:21:22'),
(44, 18, 'User Logout: Segismar', '2025-04-17 17:21:43'),
(45, 18, 'User Login: Segismar', '2025-04-17 17:22:57'),
(46, 18, 'Updated a Evaluator: 1', '2025-04-17 17:23:14'),
(47, 18, 'Updated a Evaluator: 1', '2025-04-17 17:23:42'),
(48, 18, 'User Logout: Segismar', '2025-04-17 17:23:53'),
(49, 18, 'User Login: Segismar', '2025-04-17 17:25:07'),
(50, 18, 'User Logout: Segismar', '2025-04-17 17:27:01'),
(51, 16, 'User Login: Yongzon', '2025-04-18 11:20:11'),
(52, 16, 'User Login: Yongzon', '2025-04-18 11:27:15'),
(53, 16, 'User Logout: Yongzon', '2025-04-18 11:27:53'),
(54, 16, 'User Login: Yongzon', '2025-04-18 11:30:57'),
(55, 16, 'Updated a user: miguel', '2025-04-18 11:32:25'),
(56, 16, 'User Logout: Yongzon', '2025-04-18 11:34:57'),
(57, 16, 'User Login: Yongzon', '2025-04-18 12:32:13'),
(58, 16, 'Deleted Employee: Angel Mae Segismar', '2025-04-18 12:33:50'),
(60, 16, 'User Login: Yongzon', '2025-04-18 12:38:56'),
(61, 16, 'User Logout: Yongzon', '2025-04-18 12:40:16'),
(62, 16, 'User Login: Yongzon', '2025-04-18 12:51:08'),
(63, 16, 'User Logout: Yongzon', '2025-04-18 12:52:50'),
(64, 16, 'User Login: Yongzon', '2025-04-18 12:54:15'),
(65, 16, 'User Login: Yongzon', '2025-04-18 13:00:21'),
(66, 16, 'User Logout: Yongzon', '2025-04-18 13:00:36'),
(68, 16, 'User Login: Yongzon', '2025-04-22 03:26:26'),
(69, 16, 'User Logout: Yongzon', '2025-04-22 03:26:59'),
(70, 16, 'User Login: Yongzon', '2025-04-22 03:29:12'),
(71, 16, 'User Logout: Yongzon', '2025-04-22 03:29:30'),
(72, 16, 'User Login: Yongzon', '2025-04-22 03:33:39'),
(73, 16, 'User Logout: Yongzon', '2025-04-22 03:34:03'),
(74, 16, 'User Login: Yongzon', '2025-04-22 03:35:13'),
(75, 16, 'User Login: Yongzon', '2025-04-22 03:36:53'),
(76, 16, 'User Login: Yongzon', '2025-04-22 04:24:39'),
(77, 16, 'User Logout: Yongzon', '2025-04-22 04:25:19'),
(78, 16, 'User Login: Yongzon', '2025-04-22 04:26:07'),
(79, 16, 'Created a new Task: Web test', '2025-04-22 04:26:48'),
(80, 16, 'User Logout: Yongzon', '2025-04-22 04:28:52'),
(81, 16, 'User Login: Yongzon', '2025-04-22 04:42:38'),
(82, 16, 'User Login: Yongzon', '2025-04-22 04:49:35'),
(83, 16, 'Deleted user ID: 5', '2025-04-22 04:49:50'),
(84, 16, 'Created a new Task: Simple Web', '2025-04-22 04:50:25'),
(85, 16, 'User Logout: Yongzon', '2025-04-22 04:50:44'),
(86, 16, 'User Login: Yongzon', '2025-04-22 04:51:23'),
(87, 16, 'User Logout: Yongzon', '2025-04-22 04:51:36'),
(88, 16, 'User Login: Yongzon', '2025-04-22 12:03:18'),
(89, 16, 'User Logout: Yongzon', '2025-04-22 12:06:03'),
(90, 16, 'User Login: Yongzon', '2025-04-22 12:17:46'),
(91, 16, 'User Logout: Yongzon', '2025-04-22 12:18:03'),
(92, 16, 'User Login: Yongzon', '2025-04-22 12:25:36'),
(93, 16, 'User Logout: Yongzon', '2025-04-22 12:25:48'),
(94, 16, 'User Login: Yongzon', '2025-04-22 12:26:34'),
(95, 16, 'User Logout: Yongzon', '2025-04-22 12:27:03'),
(96, 16, 'User Login: Yongzon', '2025-04-22 12:45:27'),
(97, 16, 'Updated a Task: Simple Web', '2025-04-22 12:45:44'),
(98, 16, 'User Logout: Yongzon', '2025-04-22 12:46:28'),
(99, 16, 'User Login: Yongzon', '2025-04-22 14:43:01'),
(100, 16, 'User Logout: Yongzon', '2025-04-22 14:43:06'),
(101, 16, 'User Login: Yongzon', '2025-04-22 15:59:47'),
(102, 16, 'Created a new Employee: 18', '2025-04-22 16:00:45'),
(103, 16, 'Created a new Task: App test', '2025-04-22 16:01:08'),
(104, 16, 'User Logout: Yongzon', '2025-04-22 16:01:16'),
(105, 18, 'Updated a task: App test', '2025-04-22 16:24:23'),
(106, 18, 'User Logout: Segismar', '2025-04-22 16:24:34'),
(107, 18, 'Updated a task: App test', '2025-04-22 16:31:13'),
(108, 16, 'User Login: Yongzon', '2025-04-24 13:09:02'),
(109, 16, 'User Logout: Yongzon', '2025-04-24 13:10:21'),
(110, 18, 'Updated task: App test (Status: Overdue)', '2025-04-28 04:19:19'),
(111, 18, 'Updated task: App test (Status: Completed)', '2025-04-28 04:19:46'),
(112, 18, 'Updated task: App test (Status: Overdue)', '2025-04-28 04:23:26'),
(113, 18, 'Updated task: App test (Status: Completed) - Completed after deadline', '2025-04-28 04:23:34'),
(114, 18, 'Updated task: App test (Status: Completed - Overdue)', '2025-04-28 04:27:19'),
(115, 18, 'Updated task: App test (Status: Completed - Overdue)', '2025-04-28 04:28:03'),
(116, 16, 'User Login: Yongzon', '2025-04-28 16:06:53'),
(117, 16, 'Create a user: Chan', '2025-04-28 16:08:12'),
(118, 16, 'Created a new Evaluator: 21', '2025-04-28 16:08:57'),
(119, 16, 'Updated a Evaluator: 2', '2025-04-28 16:09:14'),
(120, 16, 'User Logout: Yongzon', '2025-04-28 16:09:21'),
(121, 21, 'User Login: Yongzon', '2025-04-28 16:16:29'),
(122, 21, 'User Login: Yongzon', '2025-04-28 16:21:07'),
(123, 21, 'User Login: Yongzon', '2025-04-28 16:26:56'),
(124, 21, 'User Login: Yongzon', '2025-04-28 16:29:11'),
(125, 21, 'User Login: Yongzon', '2025-04-28 16:32:20'),
(126, 21, 'User Login: Yongzon', '2025-04-28 17:02:08'),
(127, 21, 'User Login: Yongzon', '2025-04-28 17:04:35'),
(128, 21, 'User Login: Yongzon', '2025-04-28 17:06:30'),
(129, 21, 'User Login: Yongzon', '2025-04-28 17:07:18'),
(130, 21, 'User Login: Yongzon', '2025-04-28 18:04:06'),
(131, 21, 'User Login: Yongzon', '2025-04-28 18:13:55'),
(132, 21, 'User Login: Yongzon', '2025-04-28 18:16:09'),
(133, 21, 'User Login: Yongzon', '2025-04-28 18:19:55'),
(134, 21, 'User Login: Yongzon', '2025-04-28 18:44:42'),
(135, 21, 'User Login: Yongzon', '2025-04-28 18:55:08'),
(136, 21, 'User Login: Yongzon', '2025-04-29 19:19:59'),
(137, 21, 'User Login: Yongzon', '2025-04-29 19:20:38'),
(138, 21, 'User Login: Yongzon', '2025-04-29 19:31:16'),
(139, 21, 'User Login: Yongzon', '2025-04-29 19:36:13'),
(140, 21, 'User Login: Yongzon', '2025-04-29 19:37:19'),
(141, 16, 'User Login: Yongzon', '2025-04-29 20:37:45'),
(142, 16, 'User Logout: Yongzon', '2025-04-29 20:38:11'),
(143, 21, 'User Login: Yongzon', '2025-04-29 21:17:58'),
(144, 21, 'User Login: Yongzon', '2025-04-29 21:20:57'),
(145, 21, 'User Login: Yongzon', '2025-04-29 21:22:20'),
(146, 16, 'User Login: Yongzon', '2025-04-30 08:29:22'),
(147, 16, 'Create a user: laluna', '2025-04-30 08:30:45'),
(148, 16, 'Created a new Employee: 22', '2025-04-30 08:31:02'),
(149, 16, 'User Logout: Yongzon', '2025-04-30 08:31:55'),
(150, 16, 'User Login: Yongzon', '2025-04-30 08:33:55'),
(151, 16, 'User Logout: Yongzon', '2025-04-30 08:34:29'),
(152, 16, 'User Login: Yongzon', '2025-04-30 08:35:40'),
(153, 16, 'Created a new Task: Test', '2025-04-30 08:35:58'),
(154, 16, 'User Logout: Yongzon', '2025-04-30 08:36:08');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logsemployee`
--

CREATE TABLE `tbl_logsemployee` (
  `log_id` int(11) NOT NULL,
  `log_userid` int(11) NOT NULL,
  `log_action` varchar(255) NOT NULL,
  `log_timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logsemployee`
--

INSERT INTO `tbl_logsemployee` (`log_id`, `log_userid`, `log_action`, `log_timestamp`) VALUES
(1, 22, 'User Login: Laluna', '2025-05-01 06:48:43'),
(2, 22, 'Updated task: Test (Status: Late)', '2025-05-01 06:49:04'),
(3, 22, 'Updated task: Test (Status: Completed - Overdue)', '2025-05-01 06:51:28'),
(4, 22, 'Evaluation Requested: Laluna', '2025-05-01 06:53:51'),
(5, 22, 'User Logout: Laluna', '2025-05-01 06:54:51'),
(6, 22, 'User Login: Laluna', '2025-05-01 06:58:40'),
(7, 22, 'User Logout: Laluna', '2025-05-01 06:59:32'),
(8, 22, 'User Login: Laluna', '2025-05-01 07:27:15'),
(9, 22, 'User Logout: Laluna', '2025-05-01 07:28:14'),
(10, 22, 'User Login: Laluna', '2025-05-01 07:32:02'),
(11, 22, 'User Logout: Laluna', '2025-05-01 07:32:32'),
(12, 22, 'User Login: Laluna', '2025-05-01 07:37:56'),
(13, 22, 'User Logout: Laluna', '2025-05-01 07:44:54'),
(14, 22, 'User Login: Laluna', '2025-05-02 04:57:34'),
(15, 22, 'User Login: Laluna', '2025-05-02 05:23:17'),
(16, 22, 'User Logout: Laluna', '2025-05-02 05:24:23'),
(17, 22, 'User Login: Laluna', '2025-05-02 05:27:00'),
(18, 22, 'User Logout: Laluna', '2025-05-02 05:27:28'),
(19, 22, 'User Login: Laluna', '2025-05-02 05:29:17'),
(20, 22, 'User Logout: Laluna', '2025-05-02 05:29:35'),
(21, 22, 'User Login: Laluna', '2025-05-02 06:17:14'),
(22, 22, 'User Logout: Laluna', '2025-05-02 06:19:51'),
(23, 22, 'User Login: Laluna', '2025-05-02 07:00:24'),
(24, 22, 'Updated task: Test (Status: Completed - Overdue)', '2025-05-02 07:01:09'),
(25, 22, 'User Logout: Laluna', '2025-05-02 07:02:04'),
(26, 22, 'User Login: Laluna', '2025-05-02 07:13:51'),
(27, 22, 'Updated task: Test (Status: Completed - Overdue)', '2025-05-02 07:14:17'),
(28, 22, 'User Logout: Laluna', '2025-05-02 07:14:32'),
(29, 22, 'User Login: Laluna', '2025-05-02 07:15:29'),
(30, 22, 'User Logout: Laluna', '2025-05-02 07:15:38'),
(31, 22, 'User Login: Laluna', '2025-05-02 07:17:32'),
(32, 22, 'User Logout: Laluna', '2025-05-02 07:17:48'),
(33, 22, 'User Login: Laluna', '2025-05-02 07:24:08'),
(34, 22, 'User Login: Laluna', '2025-05-02 07:26:28'),
(35, 22, 'Evaluation Requested: Laluna', '2025-05-02 07:26:49'),
(36, 22, 'User Logout: Laluna', '2025-05-02 07:27:27'),
(37, 22, 'User Login: Laluna', '2025-05-02 07:33:21'),
(38, 22, 'User Logout: Laluna', '2025-05-02 07:33:42'),
(39, 22, 'User Login: Laluna', '2025-05-02 07:55:50'),
(40, 22, 'User Logout: Laluna', '2025-05-02 07:56:04'),
(41, 22, 'User Login: Laluna', '2025-05-02 07:56:45'),
(42, 22, 'Updated task: Test (Status: Completed - Overdue)', '2025-05-02 07:56:58'),
(43, 22, 'User Logout: Laluna', '2025-05-02 07:57:26'),
(44, 22, 'User Login: Laluna', '2025-05-02 07:58:23'),
(45, 22, 'User Logout: Laluna', '2025-05-02 07:58:33'),
(46, 22, 'User Login: Laluna', '2025-05-02 08:01:46'),
(47, 22, 'User Logout: Laluna', '2025-05-02 08:01:56'),
(48, 22, 'User Login: Laluna', '2025-05-02 08:10:32'),
(49, 22, 'Evaluation Requested: Laluna', '2025-05-02 08:11:10'),
(50, 22, 'User Login: Laluna', '2025-05-02 08:22:49'),
(51, 22, 'Updated task: Test (Status: Completed - Overdue)', '2025-05-02 08:23:02'),
(52, 22, 'User Logout: Laluna', '2025-05-02 08:23:24'),
(53, 22, 'User Login: Laluna', '2025-05-02 08:24:55'),
(54, 22, 'Evaluation Requested: Laluna', '2025-05-02 08:25:07'),
(55, 22, 'User Login: Laluna', '2025-05-02 09:06:39'),
(56, 22, 'Evaluation Requested: Laluna', '2025-05-02 09:06:53'),
(57, 22, 'User Logout: Laluna', '2025-05-02 09:07:09'),
(58, 22, 'User Login: Laluna', '2025-05-02 09:18:14'),
(59, 22, 'User Logout: Laluna', '2025-05-02 09:18:33'),
(60, 22, 'User Login: Laluna', '2025-05-02 09:24:12'),
(61, 22, 'User Logout: Laluna', '2025-05-02 09:27:59'),
(62, 22, 'User Login: Laluna', '2025-05-02 10:34:45'),
(63, 22, 'User Logout: Laluna', '2025-05-02 10:35:39');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logsevaluator`
--

CREATE TABLE `tbl_logsevaluator` (
  `log_id` int(11) NOT NULL,
  `log_userid` int(11) NOT NULL,
  `log_action` varchar(255) NOT NULL,
  `log_timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logsevaluator`
--

INSERT INTO `tbl_logsevaluator` (`log_id`, `log_userid`, `log_action`, `log_timestamp`) VALUES
(1, 21, 'User Login: Yongzon', '2025-05-01 06:54:59'),
(2, 21, 'User Logout: Yongzon', '2025-05-01 06:56:04'),
(3, 21, 'User Login: Yongzon', '2025-05-02 05:01:01'),
(4, 21, 'User Logout: Yongzon', '2025-05-02 05:03:27'),
(5, 21, 'User Login: Yongzon', '2025-05-02 05:55:14'),
(6, 21, 'User Logout: Yongzon', '2025-05-02 05:55:39'),
(7, 21, 'User Login: Yongzon', '2025-05-02 06:04:15'),
(8, 21, 'User Logout: Yongzon', '2025-05-02 06:04:27'),
(9, 21, 'User Login: Yongzon', '2025-05-02 06:06:50'),
(10, 21, 'User Login: Yongzon', '2025-05-02 06:09:41'),
(11, 21, 'Rejected Evaluation Request: 7', '2025-05-02 06:10:04'),
(12, 21, 'User Logout: Yongzon', '2025-05-02 06:10:37'),
(13, 21, 'User Login: Yongzon', '2025-05-02 06:11:50'),
(14, 21, 'User Logout: Yongzon', '2025-05-02 06:12:00'),
(15, 21, 'User Login: Yongzon', '2025-05-02 06:14:47'),
(16, 21, 'User Logout: Yongzon', '2025-05-02 06:15:13'),
(17, 21, 'User Login: Yongzon', '2025-05-02 06:16:04'),
(18, 21, 'Rejected Evaluation Request: 8', '2025-05-02 06:16:40'),
(19, 21, 'User Logout: Yongzon', '2025-05-02 06:16:54'),
(20, 21, 'User Login: Yongzon', '2025-05-02 06:31:45'),
(21, 21, 'User Logout: Yongzon', '2025-05-02 06:31:58'),
(22, 21, 'User Login: Yongzon', '2025-05-02 06:32:44'),
(23, 21, 'User Logout: Yongzon', '2025-05-02 06:33:45'),
(24, 21, 'User Login: Yongzon', '2025-05-02 06:40:27'),
(25, 21, 'User Logout: Yongzon', '2025-05-02 06:41:05'),
(26, 21, 'User Login: Yongzon', '2025-05-02 06:44:20'),
(27, 21, 'Accepted Evaluation Request: 8', '2025-05-02 06:44:41'),
(28, 21, 'User Logout: Yongzon', '2025-05-02 06:46:41'),
(29, 21, 'User Login: Yongzon', '2025-05-02 06:53:39'),
(30, 21, 'User Logout: Yongzon', '2025-05-02 06:53:52'),
(31, 21, 'User Login: Yongzon', '2025-05-02 06:55:01'),
(32, 21, 'User Logout: Yongzon', '2025-05-02 06:55:33'),
(33, 21, 'User Login: Yongzon', '2025-05-02 07:27:34'),
(34, 21, 'User Logout: Yongzon', '2025-05-02 07:27:55'),
(35, 21, 'User Login: Yongzon', '2025-05-02 07:32:32'),
(36, 21, 'User Logout: Yongzon', '2025-05-02 07:33:13'),
(37, 21, 'User Login: Yongzon', '2025-05-02 08:37:38'),
(38, 21, 'User Logout: Yongzon', '2025-05-02 08:44:25'),
(39, 21, 'User Login: Yongzon', '2025-05-02 09:07:15'),
(40, 21, 'User Logout: Yongzon', '2025-05-02 09:07:42'),
(41, 21, 'User Login: Yongzon', '2025-05-02 09:10:27'),
(42, 21, 'User Logout: Yongzon', '2025-05-02 09:10:45'),
(43, 21, 'User Login: Yongzon', '2025-05-02 09:17:38'),
(44, 21, 'Accepted Evaluation Request: 8', '2025-05-02 09:17:44'),
(45, 21, 'User Logout: Yongzon', '2025-05-02 09:18:07'),
(46, 21, 'User Login: Yongzon', '2025-05-02 09:18:39'),
(47, 21, 'Created Evaluation to Ivan Laluna', '2025-05-02 09:19:37'),
(48, 21, 'User Logout: Yongzon', '2025-05-02 09:19:42'),
(49, 21, 'User Login: Yongzon', '2025-05-02 09:22:31'),
(50, 21, 'Created Evaluation to Ivan Laluna', '2025-05-02 09:23:44'),
(51, 21, 'User Logout: Yongzon', '2025-05-02 09:24:01'),
(52, 21, 'User Login: Yongzon', '2025-05-02 09:58:55'),
(53, 21, 'User Logout: Yongzon', '2025-05-02 10:00:15'),
(54, 21, 'User Login: Yongzon', '2025-05-02 10:06:02'),
(55, 21, 'User Logout: Yongzon', '2025-05-02 10:07:23'),
(56, 21, 'User Login: Yongzon', '2025-05-02 10:19:02'),
(57, 21, 'Created Evaluation to Ivan Laluna', '2025-05-02 10:19:54'),
(58, 21, 'User Logout: Yongzon', '2025-05-02 10:20:29'),
(59, 21, 'User Login: Yongzon', '2025-05-02 10:24:44'),
(60, 21, 'Created Evaluation to Ivan Laluna', '2025-05-02 10:25:22'),
(61, 21, 'User Login: Yongzon', '2025-05-02 10:28:13'),
(62, 21, 'Created Evaluation to Ivan Laluna', '2025-05-02 10:28:59'),
(63, 21, 'User Login: Yongzon', '2025-05-02 10:32:26'),
(64, 21, 'Created Evaluation to Ivan Laluna', '2025-05-02 10:33:35'),
(65, 21, 'User Logout: Yongzon', '2025-05-02 10:34:34'),
(66, 21, 'User Login: Yongzon', '2025-05-02 10:35:46'),
(67, 21, 'User Logout: Yongzon', '2025-05-02 10:36:57'),
(68, 21, 'User Login: Yongzon', '2025-05-02 10:46:58'),
(69, 21, 'User Logout: Yongzon', '2025-05-02 10:48:34');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_task`
--

CREATE TABLE `tbl_task` (
  `t_id` int(11) NOT NULL,
  `t_empid` int(11) NOT NULL,
  `t_name` varchar(50) NOT NULL,
  `t_description` varchar(255) NOT NULL,
  `t_deadline` date NOT NULL,
  `t_prlevel` varchar(50) NOT NULL,
  `t_status` varchar(255) NOT NULL,
  `t_progress` int(11) NOT NULL,
  `t_file` varchar(255) NOT NULL,
  `t_evalstatus` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_task`
--

INSERT INTO `tbl_task` (`t_id`, `t_empid`, `t_name`, `t_description`, `t_deadline`, `t_prlevel`, `t_status`, `t_progress`, `t_file`, `t_evalstatus`) VALUES
(6, 8, 'Simple Web', 'make a simple webiste using html', '2025-04-23', 'Low', 'Pending', 0, '', ''),
(7, 9, 'App test', 'test', '2025-04-24', 'Low', 'Completed - Overdue', 100, 'src/userDocuments/test2.txt', 'Rejected'),
(8, 10, 'Test', 'test again', '2025-04-30', 'Low', 'Completed - Overdue', 100, 'src/userDocuments/ss.txt', 'Accepted');

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
-- Indexes for table `tbl_evaluation`
--
ALTER TABLE `tbl_evaluation`
  ADD PRIMARY KEY (`evaluation_id`),
  ADD KEY `evaluation_tid` (`evaluation_tid`);

--
-- Indexes for table `tbl_evaluator`
--
ALTER TABLE `tbl_evaluator`
  ADD PRIMARY KEY (`eval_id`),
  ADD KEY `eval_userid` (`eval_userid`),
  ADD KEY `eval_depid` (`eval_depid`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`user_id`);

--
-- Indexes for table `tbl_logsemployee`
--
ALTER TABLE `tbl_logsemployee`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `log_userid` (`log_userid`);

--
-- Indexes for table `tbl_logsevaluator`
--
ALTER TABLE `tbl_logsevaluator`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `log_userid` (`log_userid`);

--
-- Indexes for table `tbl_task`
--
ALTER TABLE `tbl_task`
  ADD PRIMARY KEY (`t_id`),
  ADD KEY `t_empid` (`t_empid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `tbl_department`
--
ALTER TABLE `tbl_department`
  MODIFY `dep_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbl_evaluation`
--
ALTER TABLE `tbl_evaluation`
  MODIFY `evaluation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_evaluator`
--
ALTER TABLE `tbl_evaluator`
  MODIFY `eval_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=155;

--
-- AUTO_INCREMENT for table `tbl_logsemployee`
--
ALTER TABLE `tbl_logsemployee`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `tbl_logsevaluator`
--
ALTER TABLE `tbl_logsevaluator`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `tbl_task`
--
ALTER TABLE `tbl_task`
  MODIFY `t_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_department`
--
ALTER TABLE `tbl_department`
  ADD CONSTRAINT `tbl_department_ibfk_1` FOREIGN KEY (`dep_userid`) REFERENCES `tbl_admin` (`u_id`);

--
-- Constraints for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
  ADD CONSTRAINT `tbl_employee_ibfk_1` FOREIGN KEY (`emp_userid`) REFERENCES `tbl_admin` (`u_id`),
  ADD CONSTRAINT `tbl_employee_ibfk_2` FOREIGN KEY (`emp_depid`) REFERENCES `tbl_department` (`dep_id`);

--
-- Constraints for table `tbl_evaluation`
--
ALTER TABLE `tbl_evaluation`
  ADD CONSTRAINT `tbl_evaluation_ibfk_1` FOREIGN KEY (`evaluation_tid`) REFERENCES `tbl_task` (`t_id`);

--
-- Constraints for table `tbl_evaluator`
--
ALTER TABLE `tbl_evaluator`
  ADD CONSTRAINT `tbl_evaluator_ibfk_1` FOREIGN KEY (`eval_userid`) REFERENCES `tbl_admin` (`u_id`),
  ADD CONSTRAINT `tbl_evaluator_ibfk_2` FOREIGN KEY (`eval_depid`) REFERENCES `tbl_department` (`dep_id`);

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `tbl_logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_admin` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_logsemployee`
--
ALTER TABLE `tbl_logsemployee`
  ADD CONSTRAINT `tbl_logsemployee_ibfk_1` FOREIGN KEY (`log_userid`) REFERENCES `tbl_admin` (`u_id`);

--
-- Constraints for table `tbl_logsevaluator`
--
ALTER TABLE `tbl_logsevaluator`
  ADD CONSTRAINT `tbl_logsevaluator_ibfk_1` FOREIGN KEY (`log_userid`) REFERENCES `tbl_admin` (`u_id`);

--
-- Constraints for table `tbl_task`
--
ALTER TABLE `tbl_task`
  ADD CONSTRAINT `tbl_task_ibfk_2` FOREIGN KEY (`t_empid`) REFERENCES `tbl_employee` (`emp_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
