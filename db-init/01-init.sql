USE SSAFY;

CREATE TABLE `Food` (
	`food_data_code`	varchar(20)	NOT NULL,
	`food_data_name`	varchar(20)	NULL,
	`food_data_calorie`	int	NULL
);

CREATE TABLE `Group` (
	`group_id`	int	NOT NULL,
	`calorie_goal`	int	NULL,
	`headcount`	int	NULL,
	`group_name`	varchar(30)	NULL
);

CREATE TABLE `UserGroup` (
	`user_id`	int	NOT NULL,
	`group_id`	int	NOT NULL
);

CREATE TABLE `GroupMission` (
	`mission_id`	int	NOT NULL,
	`misson_name`	varchar(30)	NULL,
	`group_id`	int	NOT NULL
);

CREATE TABLE `ChatMessage` (
	`chat_id`	int	NOT NULL,
	`user_name`	varchar(50)	NULL,
	`chat_date`	date	NULL,
	`content`	varchar(100)	NULL,
	`group_id`	int	NOT NULL
);

CREATE TABLE `UserFoodLog` (
	`recode_id`	int	NOT NULL,
	`recode_date`	date	NULL,
	`meal_type`	varchar(10)	NULL,
	`food_name`	varchar(50)	NULL,
	`calorie`	int	NULL,
	`user_id`	int	NOT NULL
);

CREATE TABLE `UserSalt` (
	`user_id`	int	NOT NULL,
	`salt`	varchar(200)	NULL
);

CREATE TABLE `UserGroupMission` (
	`user_id`	int	NOT NULL,
	`mission_id`	int	NOT NULL,
	`is_complete`	boolean	NULL
);

CREATE TABLE `User` (
	`user_id`	int	NOT NULL,
	`user_password`	varchar(100)	NULL,
	`user_name`	varchar(50)	NULL,
	`user_phonenumber`	varchar(50)	NULL,
	`user_nickname`	varchar(50)	NULL
);

ALTER TABLE `Food` ADD CONSTRAINT `PK_FOOD` PRIMARY KEY (
	`food_data_code`
);

ALTER TABLE `Group` ADD CONSTRAINT `PK_GROUP` PRIMARY KEY (
	`group_id`
);

ALTER TABLE `UserGroup` ADD CONSTRAINT `PK_USERGROUP` PRIMARY KEY (
	`user_id`,
	`group_id`
);

ALTER TABLE `GroupMission` ADD CONSTRAINT `PK_GROUPMISSION` PRIMARY KEY (
	`mission_id`
);

ALTER TABLE `ChatMessage` ADD CONSTRAINT `PK_CHATMESSAGE` PRIMARY KEY (
	`chat_id`
);

ALTER TABLE `UserFoodLog` ADD CONSTRAINT `PK_USERFOODLOG` PRIMARY KEY (
	`recode_id`
);

ALTER TABLE `UserSalt` ADD CONSTRAINT `PK_USERSALT` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `UserGroupMission` ADD CONSTRAINT `PK_USERGROUPMISSION` PRIMARY KEY (
	`user_id`,
	`mission_id`
);

ALTER TABLE `User` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `UserGroup` ADD CONSTRAINT `FK_User_TO_UserGroup_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `User` (
	`user_id`
);

ALTER TABLE `UserGroup` ADD CONSTRAINT `FK_Group_TO_UserGroup_1` FOREIGN KEY (
	`group_id`
)
REFERENCES `Group` (
	`group_id`
);

ALTER TABLE `UserSalt` ADD CONSTRAINT `FK_User_TO_UserSalt_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `User` (
	`user_id`
);

ALTER TABLE `UserGroupMission` ADD CONSTRAINT `FK_User_TO_UserGroupMission_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `User` (
	`user_id`
);

ALTER TABLE `UserGroupMission` ADD CONSTRAINT `FK_GroupMission_TO_UserGroupMission_1` FOREIGN KEY (
	`mission_id`
)
REFERENCES `GroupMission` (
	`mission_id`
);
