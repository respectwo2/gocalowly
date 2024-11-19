-- group_mission 더미 데이터 생성
INSERT INTO `group_mission` (`mission_no`, `mission_name`, `group_no`)
VALUES
(1, 'Drink 2L of water', 5),
(2, 'Exercise for 30 minutes', 5),
(3, 'No sugar intake', 5),
(4, 'Drink 2L of water', 10),
(5, 'Exercise for 30 minutes', 10),
(6, 'No sugar intake', 10);

-- user_group_mission 더미 데이터 생성
INSERT INTO `user_group_mission` (`user_id`, `mission_no`, `is_mission_complete`)
VALUES
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000001', '-', '')), 1, TRUE),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000001', '-', '')), 2, FALSE),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000001', '-', '')), 3, TRUE),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000002', '-', '')), 4, FALSE),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000002', '-', '')), 5, TRUE),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000002', '-', '')), 6, TRUE);