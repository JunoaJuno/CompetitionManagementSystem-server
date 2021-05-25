package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.model.CompetitionResult;
import com.juno.competitionmanagementsystemserver.mapper.CompetitionResultMapper;
@Service
public class CompetitionResultService extends ServiceImpl<CompetitionResultMapper, CompetitionResult> {

}
