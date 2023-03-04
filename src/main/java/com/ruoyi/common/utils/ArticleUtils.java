package com.ruoyi.common.utils;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.common.collect.Lists;
import com.ruoyi.dto.EnglishRecordDTO;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleUtils {

    private static String str = "@[TOC](导航)\n" +
            "# 2023年02月25日\n" +
            "1. dream\t==梦== dream\n" +
            "1. reserve\t==保留、预定== reserve\n" +
            "1.  prove\t===证明== prove\n" +
            "1.  brief\t==摘要== brief\n" +
            "1. subtle\t==微妙、敏锐== subtle\n" +
            "1. unlovable\t==不让人喜欢的== unlovable\n" +
            "1. go in for\t==参加、从事== go in for\n" +
            "1. extinction\t==灭绝 extinct+ion== extinction extinction extinction extinction extinction\n" +
            "1. member\t==用户、成员==member member member \n" +
            "# 2023年02月26日\n" +
            "1. pacific\t==太平洋==pacific pacific\n" +
            "1. proud\t==自豪的== proud  proud\n" +
            "1. movie\t==电影== movi\n" +
            "emovie\n" +
            "1. nominee\t==候选人== nominee\n" +
            "\n" +
            "1. resolve \t==解决== resolve resolve 解决 resolve\n" +
            "1. maintenance\t==维修== maintenance maintenance maintenance 维修 maintenance\n" +
            "1. iran\t==伊朗== iran iran 伊朗\tiran\n" +
            "1. graduate\t==毕业生== graduate graduate graduate graduate 毕业生 graduate graduate\n" +
            "1. in between\t==在..什么之间== between in between in between in between\n" +
            "1. serve as\t==可用作，可当...使== serve as serve as  serve as serve as serve as 可用作，当做\n" +
            "# 2023年02月28日\n" +
            "1. be unaware of==不知道，没有察觉== be unaware of be unaware of be unaware of be unaware of \n" +
            "1. country ==国家== country\n" +
            "1. excuse ==借口== excuse excuse\n" +
            "1. gate ==大门== gate gate gate 大门 gate\n" +
            "1. baby-sitter ==临时保姆==  baby-sitter 临时保姆\n" +
            "1. entity ==实体，存在== entity entity\n" +
            "1. all the same ==任然，相同==all the same\n" +
            "1. expose to ==面临，暴露== expose to expose to expose to expose to expose to expose to \n" +
            "1. dorm ==宿舍== dorm dorm dorm dorm dorm\n" +
            "1. creativity ==创造力== creativity creativity creativity \n" +
            "1. hydrogen ==氢气== hydrogen hydro水+gen产生 hydrogen hydrogen hydrogen hydrogen\n" +
            "# 2023年03月01日\n" +
            "1. incomplete ==不完全的==in不+com共同+plete满 incomplete incompleteincomplete incomplete \n" +
            "1. spray ==喷雾== spray spray spray spray spray\n" +
            "1. request ==要求，请求==request\n" +
            "1. partial ==偏心，偏袒==partial part部分+ial形容词后缀 partial\n" +
            "1. sweden ==瑞典== sweden sweden sweden sweden  sweden sweden \n" +
            "1. reasoning ==推理；论证== reasoning reasoning reasoning\n" +
            "1. potential ==潜力；潜能== potential potential potential potent能力+ial 的 potential potential potential\n" +
            "1. predict ==语言；预告== predict predict predict predict pre前的+dict说 预先说 predict\n" +
            "1. official ==官员== official official offic官方的+ial属于 official official official\n" +
            "1. daughter ==女儿== daughter daugther daughter daughter\n" +
            "1. sentinel ==哨兵；守卫== sentinel sentinel sentinel sentinel sentinel \n" +
            "# 2023年3月2日\n" +
            "1. economist ==经济学家== economist eco+no+mist economist economist\n" +
            "1. coat ==外套== coat\n" +
            "1. in reality ==实际上；真实== in reality in reality reality in reality\n" +
            "1. combine with ==与……结合== combine with combine combine combine with\n" +
            "1. achieve ==完成；达到== achieve achieve achieve achieve achieve\n" +
            "1. keep up ==赶上== keep up\n" +
            "1. thythm ==节奏；格律== thythm thythm thythm thythm thythm thythm thythm thythm rhythm rhythm rhythm rhythm\n" +
            "1. offspring ==子女；后代== offspring offspring offspring offspring offspring offspring\n" +
            "1. polaris ==北极星== polaris polaris polaris polaris polaris polaris polaris\n" +
            "1. pass ==通过；批准== pass pass pass pass pass \n" +
            "\n";

    public static void main(String[] args) {

    }
//       String regex = "\\?ut=([\\S]*?)&";\\字符串的开头是？ut=，中间的内容是任意字符，结尾是&


}
