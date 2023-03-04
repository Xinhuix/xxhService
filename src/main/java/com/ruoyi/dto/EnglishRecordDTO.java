package com.ruoyi.dto;

import com.google.common.collect.Lists;
import com.ruoyi.common.utils.StringUtils;
import lombok.Data;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class EnglishRecordDTO {

    private String recordDate;
    private List<EnglishInfo> englishList = Lists.newArrayList();


    public void setEnglishListModel(List<String> list) {
        for (String s : list) {
            String character = matchBetweenTwoCharacter(s);

            if (StringUtils.isNotEmpty(character)) {
                EnglishInfo englishInfo = new EnglishInfo();
                englishInfo.setChinese(character);
                int i = s.indexOf("=");
                if (i > 1) {
                    englishInfo.setEnglish(s.substring(0, i).trim());
                }
                englishList.add(englishInfo);
            }
        }
    }

    public static void main(String[] args) {
        String str = " dream\t==梦== dream\n";
        int i = str.indexOf("=");
        if (i > 1) {
            String substring = str.substring(0, i);
            System.out.println(substring);
        }
        System.out.println(i);
    }


    private static final Pattern PATTERN_BETWEEN_TWO_CHARACTER = Pattern.compile("(?<===).*(?===)");

    public static String matchBetweenTwoCharacter(String input) {
        Matcher matcher = PATTERN_BETWEEN_TWO_CHARACTER.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }


    @Data
    public static class EnglishInfo {
        private String english;
        private String chinese;
    }
}
