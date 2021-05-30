package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.AuthorityInfoMapper;
import com.juno.competitionmanagementsystemserver.model.AuthorityInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorityInfoService extends ServiceImpl<AuthorityInfoMapper, AuthorityInfo> {

}
