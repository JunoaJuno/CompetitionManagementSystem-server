package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.model.TeamTea;
import com.juno.competitionmanagementsystemserver.mapper.TeamTeaMapper;
@Service
public class TeamTeaService extends ServiceImpl<TeamTeaMapper, TeamTea> {

}
