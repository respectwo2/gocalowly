INSERT INTO `group` (`group_no`, `calorie_goal`, `headcount`, `group_name`)
VALUES
(1, 1600, 10, 'Group A'),
(2, 1800, 15, 'Group B'),
(3, 2000, 20, 'Group C'),
(4, 2200, 25, 'Group D'),
(5, 2400, 30, 'Group E');

INSERT INTO `usergroup` VALUES 
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000001', '-', '')), 3),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000002', '-', '')), 2),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000003', '-', '')), 1);
