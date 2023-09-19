package com.xiaojin.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaojin.dao.JyBaseGroupMapper;
import com.xiaojin.domain.JyBaseGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/group")
public class JyBaseGroupController {
    @Autowired
    private JyBaseGroupMapper jyBaseGroupMapper;

    @PostMapping("selectByGroupCategory")
    public List<JyBaseGroup> selectByGroupCategory(@RequestParam(name = "groupCategory") String groupCategory) {
        //这里用一行代码可以写完你也可以构造LamdaQuery去写
        return jyBaseGroupMapper.selectList(Wrappers.<JyBaseGroup>lambdaQuery().eq(JyBaseGroup::getGroupCategory, groupCategory));
    }

}
