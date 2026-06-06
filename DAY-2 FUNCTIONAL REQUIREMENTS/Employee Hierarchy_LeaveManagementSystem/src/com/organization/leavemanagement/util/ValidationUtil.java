package com.organization.leavemanagement.util;

import com.organization.leavemanagement.exception.InvalidLeaveRequestException;

public class ValidationUtil {

    public static void validateString(String value,
                                      String fieldName) {

        if (value == null || value.trim().isEmpty()) {

            throw new InvalidLeaveRequestException(
                    fieldName + " cannot be blank");
        }
    }

    public static void validateDays(int days) {

        if (days <= 0) {

            throw new InvalidLeaveRequestException(
                    "Leave days must be greater than 0");
        }
    }
}