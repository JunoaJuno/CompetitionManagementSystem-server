package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.ManagerInfoMapper;
import com.juno.competitionmanagementsystemserver.model.ManagerInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerInfoService extends ServiceImpl<ManagerInfoMapper, ManagerInfo> {

}
