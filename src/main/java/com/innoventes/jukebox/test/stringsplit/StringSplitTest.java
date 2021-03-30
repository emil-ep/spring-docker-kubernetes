package com.innoventes.jukebox.test.stringsplit;

import org.apache.commons.lang3.StringUtils;

public class StringSplitTest {


    public static void main(String[] args) {

        String key = "SO3T0Z1AR2AG10";
        String[] keySplit = key.split("AR") ;
        String[] finalSplit = keySplit[1].split("AG");
        String ruleId = finalSplit[0];
        String ruleGroupId = finalSplit[1];
//        System.out.println("RuleId : " + ruleId);
//        System.out.println("RuleGroupId : " + ruleGroupId);

        String ruleIdSubString = StringUtils.substringBetween(key, "AR", "AG");
        System.out.println(ruleIdSubString);
        String groupIdSubString =  StringUtils.substringAfter(key, "AG");
        System.out.println(groupIdSubString);



        String alertGroupKey = "SO3AG243AP1S128AT1";
        String alertGroupKeyInfo = StringUtils.substringBetween(alertGroupKey, "AG", "AP");
        System.out.println(alertGroupKeyInfo);
    }
}
