package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.AuthorityInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthorityInfoMapper extends BaseMapper<AuthorityInfo> {
    int updateBatch(List<AuthorityInfo> list);

    int updateBatchSelective(List<AuthorityInfo> list);

    int batchInsert(@Param("list") List<AuthorityInfo> list);

    int insertOrUpdate(AuthorityInfo record);

    int insertOrUpdateSelective(AuthorityInfo record);
}