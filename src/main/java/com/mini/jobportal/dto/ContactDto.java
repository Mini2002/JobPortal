package com.mini.jobportal.dto;

import java.io.Serializable;

public record ContactDto(String email, String message, String name, String subject,
                         String userType) implements Serializable {
}
