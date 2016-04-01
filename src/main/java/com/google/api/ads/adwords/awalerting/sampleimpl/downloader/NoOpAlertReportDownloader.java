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

package com.google.api.ads.adwords.awalerting.sampleimpl.downloader;

import com.google.api.ads.adwords.awalerting.AlertReportDownloader;
import com.google.api.ads.adwords.awalerting.report.ReportData;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A dummy alert action implementation that doesn't download any report.
 * Note that it must have a constructor that takes an AdWordsSession and a JsonObject parameters.
 *
 * <p>The JSON config should look like:
 * <pre>
 * {
 *   "ClassName": "NoOpAlertReportDownloader"
 * }
 * </pre>
 */
public class NoOpAlertReportDownloader extends AlertReportDownloader {
  /**
   * @param session the adwords session
   * @param config the JsonObject for this alert report downloader configuration
   */
  public NoOpAlertReportDownloader(AdWordsSession session, JsonObject config) {
    super(session, config);
  }

  @Override
  public List<ReportData> downloadReports(Set<Long> accountIds) {
    return new ArrayList<ReportData>();
  }
}
