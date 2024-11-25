INSERT INTO `user` (user_id, user_nickname, user_password, user_name, user_phonenumber, complete_count, user_targetcalorie, group_no)
VALUES
(0x7E82E158657E460D91610F48E3357261, '3대500우성문', '9de3e8a7e746d9325e243380082d44ab65d37226a7056883ad97a41103a5a586', 'Jane Smith', '010-5678-1234', 0, 1800, 3),
(0xE62734BF09E849E48BAF0808A73A7DA2, 'dietKing', 'ca8d2d2c880ba2d75a3bb7acc77c0596f8c78729c288ad5c50b727e4ce7b9338', 'Bob Brown', '010-8765-4321', 0, 2200, 7);

INSERT INTO `user_salt` (user_id, salt)
VALUES
(0x7E82E158657E460D91610F48E3357261, 'bb1c3f6a11ac73f67c31fa851be4fe51d16ef54c'),
(0xE62734BF09E849E48BAF0808A73A7DA2, '463da701243b269a3308f537445a1e1357484470');

-- 원래 password는 pass456, kingDiet123