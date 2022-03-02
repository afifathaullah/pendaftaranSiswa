    package com.example.pendaftaran_siswa;

    public class User {

        private int id;
        private String username;
        private String password;
        private int level;



        public void User() {
        }

        public void User(String username, String password, Integer level) {
            this.username = username;
            this.password = password;
            this.level = level;
        }

        public void User(int id, String username, String password, Integer level) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.level = level;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

    }
