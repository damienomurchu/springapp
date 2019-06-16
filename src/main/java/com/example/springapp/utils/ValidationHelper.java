package com.example.springapp.utils;

/**
 * Helper method class for validating input
 */
public class ValidationHelper {

  /**
   * Checks if a string is null or an empty string
   *
   * @param string string to be validated
   * @return true if valid, false if invalid
   */
  static public boolean isValidString(String string) {
    if (string == null || string.equals("")) {
      return false;
    }
    return true;
  }

  static public boolean isValidIdValue(Long longInput) {
    if (longInput < 1 || longInput == null) {
      return false;
    }
    return true;
  }

}
