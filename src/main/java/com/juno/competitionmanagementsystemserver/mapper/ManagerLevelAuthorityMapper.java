package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.ManagerLevelAuthority;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerLevelAuthorityMapper extends BaseMapper<ManagerLevelAuthority> {
    int updateBatch(List<ManagerLevelAuthority> list);

    int updateBatchSelective(List<ManagerLevelAuthority> list);

    int batchInsert(@Param("list") List<ManagerLevelAuthority> list);

    int insertOrUpdate(ManagerLevelAuthority record);

    int insertOrUpdateSelective(ManagerLevelAuthority record);
}