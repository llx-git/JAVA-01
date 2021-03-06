package com.geek.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.geek.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-03-02
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {
    void loadData(@Param("filePath") String filePath);
}
