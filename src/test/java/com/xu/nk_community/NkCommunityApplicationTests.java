package com.xu.nk_community;

import com.xu.nk_community.dao.DiscussPostMapper;
import com.xu.nk_community.dao.UserMapper;
import com.xu.nk_community.pojo.DiscussPost;
import com.xu.nk_community.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;


@SpringBootTest
@ContextConfiguration(classes = NkCommunityApplication.class)
class NkCommunityApplicationTests implements ApplicationContextAware {
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private UserMapper userMapper;

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;//将容器记录下来
    }
    @Test
    public void testApplication(){
        System.out.println(applicationContext);
    }
//    测试usermapper功能
    @Test
    public void testUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testDiscuss(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost.toString());
        }
//        int i = discussPostMapper.selectDiscussPostRows(0);
//        System.out.println(i);
    }
}
