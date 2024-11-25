package com.example.gocalowly.domain.user.entity;

import com.example.gocalowly.domain.food.entity.FoodLogEntity;
import com.example.gocalowly.domain.group.entity.GroupEntity;
import com.example.gocalowly.domain.groupmission.entity.GroupMissionEntity;
import com.example.gocalowly.domain.groupmission.entity.UserGroupMissionEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID userId;

    private String userPassword;
    private String userName;
    private String userPhonenumber;
    private String userNickname; //실제 로그인 시 사용되는 아이디 unique
    private int completeCount; // 이번달 칼로리 지킨 날 수
    private int userTargetcalorie;

    public UserEntity() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_no")
    private GroupEntity group;

    @OneToMany(mappedBy = "user")
    private final List<UserGroupMissionEntity> userGroupMissions = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private final List<FoodLogEntity> foodlogs = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private final List<UserGoalEntity> userGoals = new ArrayList<>();

    public UserEntity(String userPassword, String userName, String userPhonenumber, String userNickname,
                      int userTargetcalorie) {
        super();
        setUserPassword(userPassword);
        setUserName(userName);
        setUserPhonenumber(userPhonenumber);
        setUserNickname(userNickname);
        setUserTargetcalorie(userTargetcalorie);
    }


    public UUID getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public int getCompleteCount() {
        return completeCount;
    }

    public int getUserTargetcalorie() {
        return userTargetcalorie;
    }

    public void updateTargetCalorie(int newTargetCalorie) {
        if (newTargetCalorie <= 0) {
            // 여기서 예외 처리!!
        }
        this.userTargetcalorie = newTargetCalorie;
    }

    public void changePassword(String encryptedPassword) {
        this.userPassword = encryptedPassword;
    }

    private void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }

    private void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    private void setUserTargetcalorie(int userTargetcalorie) {
        this.userTargetcalorie = userTargetcalorie;
    }

    // 음식 기록 관련
    public void addFoodLog(FoodLogEntity foodLogEntity) {
        if (foodlogs.contains(foodLogEntity)) {
            // 여기서 중복 처리!!
        }

        foodlogs.add(foodLogEntity);
    }

    public List<FoodLogEntity> getFoodLogs() {
        return foodlogs;
    }

    // 그룹 관련
    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        if (this.group != null) {
            this.group.deleteUser(this);
        }
        group.addUser(this);
        this.group = group;
    }

    // 그룹 미션 관련
    public List<UserGroupMissionEntity> getUserMissions() {
        return userGroupMissions;
    }

    public void setGroupMissions(List<GroupMissionEntity> groupMissions) {
        userGroupMissions.clear();

        groupMissions.stream().forEach(groupMissionEntity -> {
            UserGroupMissionEntity userGroupMissionEntity = new UserGroupMissionEntity();
            userGroupMissionEntity.setUser(this);
            userGroupMissionEntity.setGroupMission(groupMissionEntity);
            groupMissionEntity.addUserGroupMission(userGroupMissionEntity);

            userGroupMissions.add(userGroupMissionEntity);
        });
    }

    // 유저 월간 목표 달성 현황 관련
    public List<UserGoalEntity> getUserGoals() {
        return userGoals;
    }

    public void addUserGoal(UserGoalEntity userGoalEntity) {
        if (userGoals.contains(userGoalEntity)) {
            // 중복 에러 처리
        }

        userGoalEntity.setUser(this);
        userGoals.contains(userGoalEntity);

        if (userGoalEntity.isGoalComplete()) {
            completeCount += 1;
        }
    }

    public void clearUserGoals() {
        userGoals.clear();
        completeCount = 0;
    }

    @Override
    public String toString() {
        return "UserEntity [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
                + ", userPhonenumber=" + userPhonenumber + ", userNickname=" + userNickname + ", completeCount="
                + completeCount + ", userTargetcalorie=" + userTargetcalorie + ", group=" + group
                + ", userGroupMissions=" + userGroupMissions + ", foodlogs=" + foodlogs + ", userGoals=" + userGoals
                + "]";
    }


}
