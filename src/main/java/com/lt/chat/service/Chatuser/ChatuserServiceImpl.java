package com.lt.chat.service.Chatuser;

import com.lt.chat.entity.Chatuser.Chatuser;
import com.lt.chat.mapper.Chatuser.ChatuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ChatuserServiceImpl implements IChatuserService {


    private ChatuserMapper chatuserMapper;

    @Autowired(required = false)
    public void setChatuserMapper (ChatuserMapper chatuserMapper) {
        this.chatuserMapper = chatuserMapper;
    }


    /**
     * 通过id选取
     * @return Chatuser
     */
    @Override
    public Chatuser selectChatuserById(String id) {
        return chatuserMapper.selectChatuserById(id);
    }
    /**
     * 通过查询参数获取信息
     * @return List<Chatuser>
     */
    @Override
    public List<Chatuser> selectChatuserByParam(Map paramMap) {
        return chatuserMapper.selectChatuserByParam(paramMap);
    }

    /**
     * 更新
     * @return int
     */
    @Override
    @Transactional
    public int updateChatuser(Chatuser chatuser) {
        return chatuserMapper.updateChatuser(chatuser);
    }
    /**
     * 添加
     * @return int
     */
    @Override
    @Transactional
    public int addChatuser(Chatuser chatuser) {
        return chatuserMapper.addChatuser(chatuser);
    }
    /**
     * 批量添加
     * @return int
     */
    @Override
    @Transactional
    public int muladdChatuser(List<Chatuser> list) {
        return chatuserMapper.muladdChatuser(list);
    }
    /**
     * 删除
     * @return int
     */
    @Override
    public int deleteChatuser(String id) {
        return chatuserMapper.deleteChatuser(id);
    }
}
