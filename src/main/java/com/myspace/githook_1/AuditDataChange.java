package com.myspace.githook_1;

import lombok.Getter;
import lombok.Setter;

public class AuditDataChange {
	
	private String property;
	private String oldData;
	private String newData;
	private String ruleName;
	private String ruleId;
	private String matchingRule;
	@Override
	public String toString() {
		return "AuditDataChange [property=" + property + ", oldData=" + oldData + ", newData=" + newData + ", ruleName="
				+ ruleName + ", ruleId=" + ruleId + ", matchingRule=" + matchingRule + "]";
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getOldData() {
		return oldData;
	}
	public void setOldData(String oldData) {
		this.oldData = oldData;
	}
	public String getNewData() {
		return newData;
	}
	public void setNewData(String newData) {
		this.newData = newData;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public String getMatchingRule() {
		return matchingRule;
	}
	public void setMatchingRule(String matchingRule) {
		this.matchingRule = matchingRule;
	}
	
	
	
	
	
}
