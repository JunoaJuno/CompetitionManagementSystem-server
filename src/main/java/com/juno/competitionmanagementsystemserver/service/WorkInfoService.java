package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.WorkInfoMapper;
import com.juno.competitionmanagementsystemserver.model.WorkInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkInfoService extends ServiceImpl<WorkInfoMapper, WorkInfo> {

}
