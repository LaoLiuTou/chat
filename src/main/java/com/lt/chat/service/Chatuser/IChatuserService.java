package com.lt.chat.service.Chatuser;


import com.lt.chat.entity.Chatuser.Chatuser;

import java.util.List;
import java.util.Map;

public interface IChatuserService {

    /**
     * 通过id选取
     */
    Chatuser selectChatuserById(String id);

    /**
     * 通过查询参数获取信息
     */
    List<Chatuser> selectChatuserByParam(Map paramMap);

    /**
     * 更新
     */
    int updateChatuser(Chatuser chatuser);

    /**
     * 添加
     */
    int addChatuser(Chatuser chatuser);

    /**
     * 批量添加
     */
    int muladdChatuser(List<Chatuser> list);

    /**
     * 删除
     */
    int deleteChatuser(String id);
}
