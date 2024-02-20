package com.example.appdo;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.appdo.entity.CustDataDto;
import com.example.appdo.entity.User;
import com.example.appdo.entity.UserInfo;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest
class AppDoApplicationTests {

    @Test
    void contextLoads() throws ParseException {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
//        map.computeIfAbsent("apple1", k -> 6);
        map.computeIfPresent("apple",(k,v)-> v + 3);
        System.out.println(map);

        for (int i = 0; i < 10; i++) {
            map.put("banana", 2);
        }
    }

    @Test
    void test12(){
        int page = 1;
        List<Map<String,Integer>> lista = new ArrayList<>();
        List<Map<String,String>> model = new ArrayList<>();
        /*
        List<Map<String,Integer>> list = new ArrayList<>();
        while (true){
            if (page < 3){
                Map<String,Integer> map1 = new HashMap<>();
                map1.put("page",page);
                list.add(map1);
                System.out.println("第几次："+page);
            }else {
                break;
            }
            page++;
        }

        Map<String, Integer> result = list.stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey()+entry.getValue());
        }*/
        List<String> list = Arrays.asList("1", "2", "3");
        JSONArray data = new JSONArray();
        CustDataDto dto = new CustDataDto();
        dto.setCUST_NO("1");
        dto.setQTY(11);
        dto.setITEM_TYPE(1);
        dto.setMODEL("TY1");
        CustDataDto dto1 = new CustDataDto();
        dto1.setCUST_NO("2");
        dto1.setQTY(12);
        dto1.setITEM_TYPE(1);
        dto1.setMODEL("TY2");
        CustDataDto dto2 = new CustDataDto();
        dto2.setCUST_NO("3");
        dto2.setQTY(13);
        dto2.setITEM_TYPE(1);
        dto2.setMODEL("TY3");
        CustDataDto dto3 = new CustDataDto();
        dto3.setCUST_NO("4");
        dto3.setQTY(14);
        dto3.setITEM_TYPE(1);
        dto3.setMODEL("TY4");

        CustDataDto dto5 = new CustDataDto();
        dto5.setCUST_NO("1");
        dto5.setQTY(20);
        dto5.setITEM_TYPE(1);
        dto5.setMODEL("TY4");

        data.add(dto);
        data.add(dto1);
        data.add(dto2);
        data.add(dto3);
        data.add(dto5);

        List<CustDataDto> dtos = new ArrayList<>();
        while (true){
            if (page < 3){
                if (data != null){

                    //经销商月实际量
                    Map<String,Integer> custRealNumMap = new HashMap<>();
                    for (String custCode : list) {
                        //实际车型
                        Set<String> oneVehicleRealNum = new HashSet<>();
                        Map<String,String> modelMap = new HashMap<>();
                        int oneCustRealNum = 0;
                        for (int i = 0; i < data.size(); i++) {
                            //成车数据
                            if (1 == data.getJSONObject(i).getInteger("ITEM_TYPE") && custCode.equals(data.getJSONObject(i).getString("CUST_NO"))){
                                oneCustRealNum += data.getJSONObject(i).getInteger("QTY");
//                                oneVehicleRealNum.add(data.getJSONObject(i).getString("MODEL"));//经销商整月的实际车型
//                                modelMap.put(data.getJSONObject(i).getString("MODEL"),custCode);
                                CustDataDto dataDto = new CustDataDto();
                                dataDto.setCUST_NO(custCode);
                                dataDto.setMODEL(data.getJSONObject(i).getString("MODEL"));
                                dtos.add(dataDto);
                            }
                        }
                        custRealNumMap.put(custCode,oneCustRealNum);
//                        custRealNumMap.put("realVehicleNum",oneVehicleRealNum.size());
//                        model.add(modelMap);
                    }
                    lista.add(custRealNumMap);
                }
            }else {
                break;
            }
            page++;
        }

//        System.out.println("所有的车型:"+JSON.toJSONString(dtos));
        List<CustDataDto> collect = dtos.stream().distinct().collect(Collectors.toList());
        System.out.println("去除重复对象后的数据："+JSON.toJSONString(collect));
        Map<String, List<CustDataDto>> listMap = collect.stream().collect(Collectors.groupingBy(CustDataDto::getCUST_NO));
        System.out.println("分组后的数据"+listMap);
        //计算
        Map<String, Integer> result = lista.stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
    @Test
    void test11() throws UnsupportedEncodingException {
        String areaCode = "1,2,3,4,5";
        List<String> collect = Arrays.stream(areaCode.split(",")).collect(Collectors.toList());
        List<String> arr = new ArrayList<>();
        for (String s : collect) {
            if ("5".equals(s) || "2".equals(s)){
                arr.add(0,s);
            }else {
                arr.add(s);
            }
        }
        System.out.println(arr);
       /* Integer realNum = 25;
        Integer planNum = 10;
        //实际量<=计划量
        if (planNum > 0 && realNum <= planNum){
            System.out.println("121132");
            System.out.println(new BigDecimal(realNum).divide(new BigDecimal(planNum),2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).toString());
        }

        //实际量>计划量
        if (realNum > 0 && realNum > planNum){
            System.out.println(new BigDecimal(planNum).divide(new BigDecimal(realNum),2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).toString());
        }*/

//        return new BigDecimal(0).setScale(2).toString();
//        List<Map<String,Integer>> list = new ArrayList<>();
//        Map<String,Integer> map1 = new HashMap<>();
//        map1.put("101",22);
//        map1.put("102",10);
//        map1.put("103",1);
//        Map<String,Integer> map2 = new HashMap<>();
//        map2.put("101",20);
//        map2.put("102",16);
//        map2.put("104",1);
//        map2.put("pageIndex",0);
////        totalMap.add(map1);
//        list.add(map2);
//
//        Map<String,Integer> total = new HashMap<>();
//        //计算key相同的求和
//        Map<String, Integer> result = list.stream() .flatMap(map -> map.entrySet().stream()) .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));
//        System.out.println(result);

    }
    /**
     * @throws ParseException
     */
    @Test
    void test() throws Exception {
        BigDecimal planAccuracy = new BigDecimal(0).setScale(2);
        int planNum = 10;
        int realNum = 0;
//        BigDecimal cha = new BigDecimal(planNum - realNum).abs();
//        cha = cha.divide(new BigDecimal(planNum), 2, RoundingMode.HALF_UP);
//        planAccuracy = new BigDecimal(1).subtract(cha).multiply(new BigDecimal(100));
//
//        BigDecimal deliveryReachRate = new BigDecimal(realNum).divide(new BigDecimal(planNum),2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));

        int dayOfMonth = LocalDate.now().getDayOfMonth();
        System.out.println("本月第__天"+dayOfMonth);
        System.out.println(planAccuracy.toString()+"%");

        BigDecimal value = new BigDecimal(36).divide(new BigDecimal(111),2,BigDecimal.ROUND_HALF_UP);
        System.out.println(value);
        BigDecimal decimal = new BigDecimal("0.3");
        System.out.println("decimal"+decimal);
        if (value.compareTo(decimal) < 0){
            System.out.println("小于0.3");
        }

    }
    @Test
    void test1() throws Exception {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
       /* for (Integer integer : list) {
            sb.append(integer+",");
        }*/
//        System.out.println("sb:"+sb);
//        System.out.println("sb:"+sb.substring(0, sb.length()-1));
//        System.out.println("sb.length():"+sb.length());
        //字符串逗号拼接
//        System.out.println(StringUtils.join(list,","));
//        System.out.println(DesensitizedUtil.mobilePhone("18860389461"));
//        System.out.println(DesensitizedUtil.idCardNum("410782199208139635",4,2));
        //当天最大时间点2023-10-30T23:59:59.999999999
        LocalDateTime max = LocalDateTime.of(LocalDate.now().minusDays(7), LocalTime.MIN);
//        LocalDate date = LocalDate.now().minusDays(7);
        String format = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 将日期设置为当月的第一天
        Date firstDay = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); // 将日期设置为当月的最后一天
        Date lastDay = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = dateFormat.format(firstDay);
        System.out.println("String => LocalDate: " + format1);

    }

    @Test
    void test2(){
        ArrayList<User> list = new ArrayList<>();
        User user1 = User.builder().userId("100").name("小花").age(10).build();
        User user2 = User.builder().userId("101").name("小ming").age(16).build();
        User user3 = User.builder().userId("102").name("航航").age(19).build();
        User user4 = User.builder().userId("103").name("航2航").age(19).build();
        User user5 = User.builder().userId("105").name("航3航").age(19).build();
        User user6 = User.builder().userId("106").name("航4航").age(19).build();
        list.add(user1);
        list.add(user2);
//        list.add(user3);
//        list.add(user4);
//        list.add(user5);
//        list.add(user6);
        System.out.println(JSON.toJSONString(list));
//        //list集合对象转map
//        Map<String, User> map = list.stream().collect(Collectors.toMap(User::getUserId, Function.identity()));
//        System.out.println(JSON.toJSONString(map));
//        //打乱顺序随机选取几个元素
//        Collections.shuffle(list);
//        List<User> users = list.subList(0, 5);
//        System.out.println(users);
    }
    @Test
    void test3() throws UnsupportedEncodingException {
        List<Integer> list1 = Arrays.asList(1, 2, 3,4);
        List<Integer> list2 = Arrays.asList(3, 4);

        List<Integer> difference = new ArrayList<>();

        for (Integer element : list1) {
            boolean found = false;
            for (Integer compareElement : list2) {
                if (element.equals(compareElement)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                difference.add(element);
            }
        }

        System.out.println("差集为：" + difference);

    }
}
