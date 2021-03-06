package org.jenkinsci.plugins.gwt;

import java.util.Map;

public class GenericTriggerResults {

  private final Map<String, String> resolvedVariables;
  private final String regexpFilterText;
  private final String regexpFilterExpression;
  private final String searchUrl;
  private final String url;
  private final long id;
  private final boolean triggered;
  private final String searchName;

  public GenericTriggerResults(
      hudson.model.Queue.Item item,
      Map<String, String> resolvedVariables,
      String regexpFilterText,
      String regexpFilterExpression) {
    if (item != null) {
      this.url = item.getUrl();
      this.id = item.getId();
      this.triggered = true;
    } else {
      this.url = null;
      this.id = 0;
      this.triggered = false;
    }

    if (item != null && item.getApi() != null) {
      this.searchUrl = item.getApi().getSearchUrl();
      this.searchName = item.getApi().getSearchName();
    } else {
      this.searchUrl = null;
      this.searchName = null;
    }

    this.resolvedVariables = resolvedVariables;
    this.regexpFilterText = regexpFilterText;
    this.regexpFilterExpression = regexpFilterExpression;
  }

  public boolean isTriggered() {
    return triggered;
  }

  public long getId() {
    return id;
  }

  public String getSearchUrl() {
    return searchUrl;
  }

  public String getUrl() {
    return url;
  }

  public String getRegexpFilterExpression() {
    return regexpFilterExpression;
  }

  public String getRegexpFilterText() {
    return regexpFilterText;
  }

  public Map<String, String> getResolvedVariables() {
    return resolvedVariables;
  }

  public String getSearchName() {
    return searchName;
  }
}
