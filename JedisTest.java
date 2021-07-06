package com.icis.Jedispg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    private Jedis jedis;
    @Before
    public void initJedis(){
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
       
        JedisPool jedisPool=new JedisPool(config,"127.0.0.1",6379);
        jedis=jedisPool.getResource();
        //jedis.auth("123456");
    }
    @Test
    public void setStringKey(){
        jedis.set("hah1","baba");
    }
    @Test
    public void getStringKey(){
        jedis.get("hah1");
        System.out.println(jedis.get("hah1"));
    }
    @Test
    public void setHash(){
        jedis.hset("user","name","狗东西");
        jedis.hset("user","age","23");
        jedis.hset("user","hobby","游泳");
    }
    @Test
    public void getHash(){
        Map<String, String> map = jedis.hgetAll("user");
        System.out.println(map);
    }
    @Test
    public void setList(){
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");
    }
    @Test
    public void getList(){
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
    }
    @Test
    public void setSet(){
        jedis.sadd("myset","java","c#","c++");
    }
    @Test
    public void getSet(){
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
    }
    //有序set
    @Test
    public void setSortedSet(){
        jedis.zadd("mysortedset",1,"亚索");
        jedis.zadd("mysortedset",4,"后裔");
        jedis.zadd("mysortedset",3,"炸弹猫");
    }
    @Test
    public void getSortedSet(){
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);
    }
    @After
    public void close(){
        this.jedis.close();
    }
    @Test
    public void loop(){
        String str="";
        System.out.println(str.split(",").length);
        String classFile = "com.jd.". replaceAll(".", "/") + "MyClass.class";
        System.out.println(classFile);
        String s=null;
        if ((s==null)||(s.length()==0)){
            System.out.println(1);
        }
    }
    @Test
    public void aVoid(){
        int x=10;
        while (x){

        }
    }


}
