package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.CompetitionResultMapper;
import com.juno.competitionmanagementsystemserver.model.CompetitionResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompetitionResultService extends ServiceImpl<CompetitionResultMapper, CompetitionResult> {

}
