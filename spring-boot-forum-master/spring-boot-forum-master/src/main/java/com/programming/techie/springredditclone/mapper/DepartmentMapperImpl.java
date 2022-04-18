package com.programming.techie.springredditclone.mapper;

import com.programming.techie.springredditclone.dto.DepartmentDto;
import com.programming.techie.springredditclone.dto.DepartmentDto.DepartmentDtoBuilder;
import com.programming.techie.springredditclone.model.Department;
import com.programming.techie.springredditclone.model.Department.DepartmentBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-14T17:36:32+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto mapDepartmentToDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDtoBuilder departmentDto = DepartmentDto.builder();

        departmentDto.id( department.getId() );
        departmentDto.name( department.getName() );
        departmentDto.description( department.getDescription() );

        departmentDto.numberOfPosts( mapPosts(department.getPosts()) );

        return departmentDto.build();
    }

    @Override
    public Department mapDtoToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        DepartmentBuilder department = Department.builder();

        department.id( departmentDto.getId() );
        department.name( departmentDto.getName() );
        department.description( departmentDto.getDescription() );

        return department.build();
    }
}
