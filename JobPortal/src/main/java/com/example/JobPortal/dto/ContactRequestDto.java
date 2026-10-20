package com.example.JobPortal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ContactRequestDto(
        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Invalid Email address")
        String email,
        @NotBlank(message = "Message cannot be empty")
        @Size(min=5,max=500,message = "Message must be between 5 and 500 Characters")
        String message,
        @NotBlank(message = "Name cannot be empty")
        @Size(min=5,max=30,message = "Name must be between 5 and 30 Characters")
        String name,
        @NotBlank(message = "Subject cannot be empty")
        @Size(min=5,max=150,message = "Subject must be between 5 and 150 Characters")
        String subject,
        @NotBlank(message = "User type cannot be empty")
        @Pattern(regexp = "Job Seeker|Employer|Other", message = "User Type must be either one of: Job Seeker, Employer, Other")
        String userType) {
}
