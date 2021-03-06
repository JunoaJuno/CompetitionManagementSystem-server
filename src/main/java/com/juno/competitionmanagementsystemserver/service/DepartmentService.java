package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.dto.DepartmentDto;
import com.juno.competitionmanagementsystemserver.mapper.DepartmentMapper;
import com.juno.competitionmanagementsystemserver.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class DepartmentService extends ServiceImpl<DepartmentMapper, Department> {

    public boolean updateById(Integer id, DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(id);
        department.setName(departmentDto.getName());
        department.setNumber(departmentDto.getNumber());
        return updateById(department);
    }

    public boolean saveBatch(List<DepartmentDto> departmentDtoList) {
        List<Department> departmentList = new LinkedList<>();
        for (DepartmentDto departmentDto : departmentDtoList) {
            Department department = new Department();
            department.setNumber(departmentDto.getNumber());
            department.setName(departmentDto.getName());
            departmentList.add(department);
        }
        return saveBatch(departmentList);
    }
}
