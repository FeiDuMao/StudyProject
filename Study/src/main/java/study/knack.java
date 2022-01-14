package study;

import Entity.Person;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class knack {


    /**
     * 1 2 3 4 5 6 7 8  9
     * 0 1 1 2 3 5 8 13 21
     */
    //Fibonacci数列递归法：效率低
    public int Fibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //非递归
    public int getFibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        //pre:前一个数，cur：后一个数，tmp：暂存下一个数
        int pre = 0, cur = 1, tmp;
        for (int i = 2; i < n; i++) {
            tmp = pre + cur;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }

    /**
     * LocalDate与Date互相转换
     * ##以毫秒数为介质进行转换：
     */
    public void LocalDateConverter() {
        long currentMill = 1642989642345L;

        //通过currentMill得到Date
        Date date = new Date(currentMill);
        //通过currentMill得到LocalDateTime
        LocalDateTime localDateTime = LocalDateTime
                .ofInstant(Instant.ofEpochMilli(currentMill), ZoneId.systemDefault());
        //通过currentMill得到localDate
        LocalDate localDate = LocalDate
                .ofInstant(Instant.ofEpochMilli(currentMill), ZoneId.systemDefault());

        //通过Date得到currentMill
        long currentMill1 = date.toInstant().toEpochMilli();
        //通过LocalDate得到currentMill
        long currentMill2 = localDate.atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();
        //通过LocalDate得到currentMill
        long currentMill3 = localDateTime.atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();

        System.out.println(currentMill);
        System.out.println(currentMill1);
        System.out.println(currentMill2);
        System.out.println(currentMill3);

        System.out.println(date);
        System.out.println(localDateTime);
        System.out.println(localDate);

    }

    /**
     * stream流：map:对其中的数据进行处理并且返回一个结果，如果要保存下来，需要用Collectors收集起来
     */
    public void StreamConverter() {
        List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<String, Integer> collect = integers.stream()
                .filter(i -> i >= 3)//boolean
                .map(i -> ++i)//对list中的每个item进行处理，并返回一个结果
                //.forEach(System.out::println)  对list中的每个item进行处理，没有返回结果
                .collect(Collectors.toMap(
                        Object::toString,
                        i -> i
                ));


        //求和
        int sum = collect.values().stream().mapToInt(Integer::intValue).sum();
        OptionalInt max = collect.values().stream().mapToInt(Integer::intValue).max();
        OptionalInt min = collect.values().stream().mapToInt(Integer::intValue).min();
        if (max.isPresent()) {
            System.out.println(max.getAsInt());
        }


    }


    @Test
    public void test() {
        StreamConverter();
    }


}
