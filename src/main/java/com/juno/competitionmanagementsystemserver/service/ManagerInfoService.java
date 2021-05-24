package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.ManagerInfoMapper;
import com.juno.competitionmanagementsystemserver.model.ManagerInfo;
@Service
public class ManagerInfoService extends ServiceImpl<ManagerInfoMapper, ManagerInfo> {

}
