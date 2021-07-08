package com.myspace.githook_1;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class DataAudit {
	
	private List<AuditDataChange> dataChangelist;
	private String ruleName;
	private String matchingRule;
	private String ruleId;
	
	@Override
	public String toString() {
		return "DataAudit [dataChangelist=" + dataChangelist + ", ruleName=" + ruleName + ", matchingRule="
				+ matchingRule + ", ruleId=" + ruleId + "]";
	}

	public List<AuditDataChange> getDataChangelist() {
		return dataChangelist;
	}

	public void setDataChangelist(List<AuditDataChange> dataChangelist) {
		this.dataChangelist = dataChangelist;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getMatchingRule() {
		return matchingRule;
	}

	public void setMatchingRule(String matchingRule) {
		this.matchingRule = matchingRule;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	
	
	
	
}
