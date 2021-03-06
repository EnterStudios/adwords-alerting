// Copyright 2015 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.awalerting.report;

import java.util.List;
import java.util.Map;

/**
 * Report entry corresponding to each row of the report.
 */
public class ReportRow {
  private final List<String> values;
  private final Map<String, Integer> mapping;

  /**
   * @param values the list of field values
   * @param mapping the "field name" -> index mapping
   */
  public ReportRow(List<String> values, Map<String, Integer> mapping) {
    this.values = values;
    this.mapping = mapping;
  }

  /**
   * Get the value of the specified field name.
   *
   * @param fieldName the field name
   * @return value of the specified field name, null if that field is not in report
   */
  public String getFieldValue(String fieldName) {
    if (mapping.containsKey(fieldName)) {
      return values.get(mapping.get(fieldName).intValue());
    }
    return null;
  }

  /**
   * Set the value of the specified field name.
   *
   * @param fieldName the field name
   * @param fieldValue the field value to set
   */
  public void setFieldValue(String fieldName, String fieldValue) {
    if (mapping.containsKey(fieldName)) {
      values.set(mapping.get(fieldName).intValue(), fieldValue);
    }
  }

  /**
   * Append value of a new field. Caller should add the column header beforehand.
   *
   * @param fieldValue the field value to append
   */
  public void appendFieldValue(String fieldValue) {
    values.add(fieldValue);
  }

  /**
   * Append values of new fields. Caller should add the column headers beforehand.
   *
   * @param fieldValues the field values to append
   */
  public void appendFieldValues(List<String> fieldValues) {
    values.addAll(fieldValues);
  }
}
