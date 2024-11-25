-- group_mission 더미 데이터 생성
INSERT INTO `group_mission` (`mission_no`, `mission_name`, `group_no`)
VALUES
(1, '물 2L 마시기', 5),
(2, '운동 30분 하기', 5),
(3, '스트레칭 동영상 따라하기', 5),
(4, '물 2L 마시기', 10),
(5, '운동 30분 하기', 10),
(6, '스트레칭 동영상 따라하기', 10);

-- user_group_mission 더미 데이터 생성
INSERT INTO `user_group_mission` (`user_id`, `mission_no`, `is_mission_complete`)
VALUES
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000001', '-', '')), 1, TRUE),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000001', '-', '')), 2, FALSE),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000001', '-', '')), 3, TRUE),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000002', '-', '')), 4, FALSE),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000002', '-', '')), 5, TRUE),
(UNHEX(REPLACE('00000000-0000-0000-0000-000000000002', '-', '')), 6, TRUE);
