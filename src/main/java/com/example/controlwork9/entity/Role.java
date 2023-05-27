package com.example.controlwork9.entity;

public enum Role {
        MANAGER("Manager"),
        DEVELOPER("Developer");

        private final String displayName;

        Role(String displayName) {
                this.displayName = displayName;
        }

        public String getDisplayName() {
                return displayName;
        }
}
