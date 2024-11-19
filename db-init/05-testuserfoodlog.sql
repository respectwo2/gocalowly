SET @user_id = UNHEX(REPLACE('00000000-0000-0000-0000-000000000001', '-', ''));

INSERT INTO `user_food_log` (record_id, record_date, meal_type, food_name, calorie, user_id)
VALUES
-- 오늘 데이터
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE(), 'Breakfast', 'Eggs', 200, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE(), 'Lunch', 'Chicken Salad', 350, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE(), 'Dinner', 'Grilled Salmon', 500, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE(), 'Snack', 'Fruit', 100, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE(), 'Dessert', 'Cake', 300, @user_id),

-- 1일 전 데이터
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 1 DAY, 'Breakfast', 'Toast', 180, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 1 DAY, 'Lunch', 'Pasta', 400, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 1 DAY, 'Dinner', 'Beef Steak', 550, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 1 DAY, 'Snack', 'Yogurt', 120, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 1 DAY, 'Dessert', 'Brownie', 320, @user_id),

-- 2일 전 데이터
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 2 DAY, 'Breakfast', 'Pancakes', 250, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 2 DAY, 'Lunch', 'Burrito', 450, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 2 DAY, 'Dinner', 'Pizza', 600, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 2 DAY, 'Snack', 'Chips', 150, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 2 DAY, 'Dessert', 'Ice Cream', 280, @user_id),

-- 3일 전 데이터
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 3 DAY, 'Breakfast', 'Oatmeal', 220, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 3 DAY, 'Lunch', 'Sandwich', 390, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 3 DAY, 'Dinner', 'Pork Chops', 570, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 3 DAY, 'Snack', 'Granola Bar', 130, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 3 DAY, 'Dessert', 'Muffin', 260, @user_id),

-- 4일 전 데이터
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 4 DAY, 'Breakfast', 'Bagel', 230, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 4 DAY, 'Lunch', 'Soup', 340, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 4 DAY, 'Dinner', 'Roast Chicken', 520, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 4 DAY, 'Snack', 'Pretzels', 110, @user_id),
(UNHEX(REPLACE(UUID(), '-', '')), CURDATE() - INTERVAL 4 DAY, 'Dessert', 'Pudding', 290, @user_id);