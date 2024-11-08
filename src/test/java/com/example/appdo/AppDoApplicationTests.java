package com.example.appdo;

import com.example.appdo.entity.Demo;
import com.example.appdo.entity.MyRunnable;
import com.example.appdo.entity.User;
import com.example.appdo.utils.RedisIdWorker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@SpringBootTest
class AppDoApplicationTests {

    @Test
    void contextLoads() {

        DecimalFormat decimalFormat = new DecimalFormat("0000");  //代表四位数
        String maxSerialNumber = decimalFormat.format(Integer.valueOf("0201") + 1);  //转为String之后的结果是0002而不是2
        System.out.println(maxSerialNumber);
        System.out.println(Integer.valueOf("0201"));
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // CountDownLatch减数机制,countDown触发await,达到同时执行的目的
        CountDownLatch latch = new CountDownLatch(1);

        List<String> threadNameList = Arrays.asList("A", "B", "C");
        for (int i = 0; i < 3; i++) {
            executorService.execute(new MyRunnable(threadNameList.get(i), latch));
        }

        latch.countDown();
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // 等待所有线程执行完成
        }
        System.exit(0);
    }
    @Test
    void test4(){
        List<Demo> result = new ArrayList<>();
        Demo demo = new Demo();
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("1");
        User user1 = new User();
        user1.setName("你卡省的");
        list.add(user);
        list.add(user1);
        demo.setUsers(list);
        result.add(demo);

//        List<User> collect = result.stream().flatMap(Collection::stream).collect(Collectors.toList());
        List<User> collect = result.stream().flatMap(pjSubmitCartReq -> pjSubmitCartReq.getUsers().stream()).collect(Collectors.toList());
        System.out.println(collect);

    }

    /**
     * 自增序号
     * @throws NoSuchAlgorithmException
     */
    @Test
    void test12() throws NoSuchAlgorithmException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("小米");
        user.setAge(10);
        User user1 = new User();
        user1.setName("小米");
        user1.setAge(12);

        User user2 = new User();
        user2.setAge(14);
        user2.setName("你的");
        User user3 = new User();
        user3.setAge(18);
        user3.setName("你的");

        User user4 = new User();
        user4.setName("小华");
        user4.setAge(30);

        list.add(user4);
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        //有序
        Map<String, List<User>> map = list.stream().collect(Collectors.groupingBy(User::getName, LinkedHashMap::new, Collectors.toList()));
        Map<String, List<User>> map1 = list.stream().collect(Collectors.groupingBy(User::getName));
        for (Map.Entry<String, List<User>> entry : map.entrySet()) {
            List<User> value = entry.getValue();
            List<User> newList = value.stream().peek(ur -> ur.setAge(atomicInteger.incrementAndGet())).collect(Collectors.toList());
            System.out.println(newList);
        }

//        List<User> collect = list.stream().peek(u -> u.setAge(atomicInteger.incrementAndGet())).collect(Collectors.toList());
        System.out.println(map1);
    }

    @Autowired
    private RedisIdWorker redisIdWorker;

    /**
     * 关于countdownlatch
     *
     * countdownlatch名为信号枪：主要的作用是同步协调在多线程的等待于唤醒问题
     *
     * 我们如果没有CountDownLatch ，那么由于程序是异步的，当异步程序没有执行完时，主线程就已经执行完了，然后我们期望的是分线程全部走完之后，主线程再走，所以我们此时需要使用到CountDownLatch
     *
     * CountDownLatch 中有两个最重要的方法
     *
     * 1、countDown
     *
     * 2、await
     *
     * await 方法 是阻塞方法，我们担心分线程没有执行完时，main线程就先执行，所以使用await可以让main线程阻塞，那么什么时候main线程不再阻塞呢？当CountDownLatch 内部维护的 变量变为0时，就不再阻塞，直接放行，那么什么时候CountDownLatch 维护的变量变为0 呢，我们只需要调用一次countDown ，内部变量就减少1，我们让分线程和变量绑定， 执行完一个分线程就减少一个变量，当分线程全部走完，CountDownLatch 维护的变量就是0，此时await就不再阻塞，统计出来的时间也就是所有分线程执行完后的时间。
     *
     * @throws InterruptedException
     */
    @Test
    void test10() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(300);
        Runnable task = () -> {
            for (int i = 0; i < 1; i++) {
                long id = redisIdWorker.nextId("order");
                System.out.println("id = " + id);
            }
            latch.countDown();
        };
        ExecutorService es = Executors.newFixedThreadPool(100); //线程池，把任务提交，然后分配任务
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 300; i++) {
            es.submit(task);
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - begin));
    }

    @Test
    void test20(){
        HashMap<Object, Object> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
//        System.out.println(collect);
    }
    @Test
    void test13() {
        List<User> saleBomList = new ArrayList<>();
        List<User> downs = new ArrayList<>();
        User user = new User();
        user.setName("11");
        user.setAge(21);
        User user1 = new User();
        user1.setName("11");
        user1.setAge(21);
        User user2 = new User();
        user2.setName("12");
        user2.setAge(22);

        User user3 = new User();
        user3.setName("12");
        user3.setAge(22);
        saleBomList.add(user);
        saleBomList.add(user1);
        saleBomList.add(user2);
        downs.add(user3);

        saleBomList.forEach(ur -> ur.setAge(120));
        System.out.println(saleBomList);
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
