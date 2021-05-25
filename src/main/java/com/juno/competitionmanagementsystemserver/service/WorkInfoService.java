package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.WorkInfoMapper;
import com.juno.competitionmanagementsystemserver.model.WorkInfo;
@Service
public class WorkInfoService extends ServiceImpl<WorkInfoMapper, WorkInfo> {

}
