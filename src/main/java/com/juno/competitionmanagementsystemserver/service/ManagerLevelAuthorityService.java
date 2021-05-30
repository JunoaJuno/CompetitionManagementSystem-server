package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.ManagerLevelAuthorityMapper;
import com.juno.competitionmanagementsystemserver.model.ManagerLevelAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerLevelAuthorityService extends ServiceImpl<ManagerLevelAuthorityMapper, ManagerLevelAuthority> {

}
