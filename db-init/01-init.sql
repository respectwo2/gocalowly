CREATE TABLE `food` (
	`food_data_code`	varchar(20)	NOT NULL,
	`food_data_name`	varchar(20)	NULL,
	`food_data_calorie`	int	NULL
);

CREATE TABLE `group` (
	`group_no`	int	NOT NULL,
	`calorie_goal`	int	NULL,
	`headcount`	int	NULL,
	`group_name`	varchar(30)	NULL
);

CREATE TABLE `user_group` (
	`user_id`	binary(16)	NOT NULL,
	`group_no`	int	NOT NULL
);

CREATE TABLE `group_mission` (
	`mission_no`	int	NOT NULL,
	`misson_name`	varchar(30)	NULL,
	`group_no`	int	NOT NULL
);

CREATE TABLE `chat_message` (
	`chat_no`	int	NOT NULL,
	`user_name`	varchar(50)	NULL,
	`chat_date`	datetime	NULL,
	`content`	varchar(100)	NULL,
	`group_no`	int	NOT NULL
);

CREATE TABLE `user_food_log` (
	`record_id`	binary(16)	NOT NULL,
	`record_date`	datetime	NULL,
	`meal_type`	varchar(10)	NULL,
	`food_name`	varchar(50)	NULL,
	`calorie`	int	NULL,
	`user_id`	binary(16)	NOT NULL
);

CREATE TABLE `user_salt` (
	`user_id`	binary(16)	NOT NULL,
	`salt`	varchar(200)	NULL
);

CREATE TABLE `user_group_mission` (
	`user_id`	binary(16)	NOT NULL,
	`mission_no`	int	NOT NULL,
	`is_mission_complete`	boolean	NULL
);

CREATE TABLE `user` (
	`user_id`	binary(16)	NOT NULL,
	`user_nickname`	varchar(50)	NULL,
	`user_password`	varchar(100)	NULL,
	`user_name`	varchar(50)	NULL,
	`user_phonenumber`	varchar(50)	NULL,
	`complete_count`	int	NULL,
	`user_targetcalorie`	int	NULL
);

CREATE TABLE `user_goal` (
	`user_goal_no`	int	NOT NULL,
	`user_goal_date`	datetime	NOT NULL,
	`is_goal_complete`	boolean	NULL,
	`user_id`	binary(16)	NOT NULL
);

ALTER TABLE `food` ADD CONSTRAINT `PK_FOOD` PRIMARY KEY (
	`food_data_code`
);

ALTER TABLE `group` ADD CONSTRAINT `PK_GROUP` PRIMARY KEY (
	`group_no`
);

ALTER TABLE `user_group` ADD CONSTRAINT `PK_USER_GROUP` PRIMARY KEY (
	`user_id`,
	`group_no`
);

ALTER TABLE `group_mission` ADD CONSTRAINT `PK_GROUP_MISSION` PRIMARY KEY (
	`mission_no`
);

ALTER TABLE `chat_message` ADD CONSTRAINT `PK_CHAT_MESSAGE` PRIMARY KEY (
	`chat_no`
);

ALTER TABLE `user_food_log` ADD CONSTRAINT `PK_USER_FOOD_LOG` PRIMARY KEY (
	`record_id`
);

ALTER TABLE `user_salt` ADD CONSTRAINT `PK_USER_SALT` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `user_group_mission` ADD CONSTRAINT `PK_USER_GROUP_MISSION` PRIMARY KEY (
	`user_id`,
	`mission_no`
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `user_goal` ADD CONSTRAINT `PK_USER_GOAL` PRIMARY KEY (
	`user_goal_no`
);

ALTER TABLE `user_group` ADD CONSTRAINT `FK_user_TO_user_group_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`user_id`
);

ALTER TABLE `user_group` ADD CONSTRAINT `FK_group_TO_user_group_1` FOREIGN KEY (
	`group_no`
)
REFERENCES `group` (
	`group_no`
);

ALTER TABLE `user_salt` ADD CONSTRAINT `FK_user_TO_user_salt_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`user_id`
);

ALTER TABLE `user_group_mission` ADD CONSTRAINT `FK_user_TO_user_group_mission_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`user_id`
);

ALTER TABLE `user_group_mission` ADD CONSTRAINT `FK_group_mission_TO_user_group_mission_1` FOREIGN KEY (
	`mission_no`
)
REFERENCES `group_mission` (
	`mission_no`
);

