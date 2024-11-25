SET @user_id = UNHEX(REPLACE('00000000-0000-0000-0000-000000000001', '-', ''));

INSERT INTO `user_food_log` (record_id, record_date, meal_type, food_name, calorie, user_id)
VALUES
-- 오늘 데이터
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE(), '아침', '계란', 200, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE(), '점심', '김치찌개', 450, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE(), '저녁', '불고기', 500, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE(), '간식', '바나나', 90, @user_id),

-- 1일 전 데이터
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 1 DAY, '아침', '토스트', 180, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 1 DAY, '점심', '비빔밥', 500, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 1 DAY, '저녁', '삼겹살', 600, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 1 DAY, '간식', '요거트', 120, @user_id),

-- 2일 전 데이터
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 2 DAY, '아침', '미역국', 120, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 2 DAY, '점심', '떡볶이', 400, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 2 DAY, '저녁', '된장찌개', 450, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 2 DAY, '간식', '오징어 땅콩', 200, @user_id),

-- 3일 전 데이터
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 3 DAY, '아침', '죽', 180, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 3 DAY, '점심', '칼국수', 350, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 3 DAY, '저녁', '닭갈비', 600, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 3 DAY, '간식', '군밤', 120, @user_id),

-- 4일 전 데이터
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 4 DAY, '아침', '김밥', 250, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 4 DAY, '점심', '갈비탕', 500, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 4 DAY, '저녁', '제육볶음', 550, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 4 DAY, '간식', '찐 감자', 150, @user_id),
