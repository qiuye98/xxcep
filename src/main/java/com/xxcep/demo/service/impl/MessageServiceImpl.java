package com.xxcep.demo.service.impl;

import com.xxcep.demo.entity.Message;
import com.xxcep.demo.mapper.MessageMapper;
import com.xxcep.demo.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
