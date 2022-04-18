package com.programming.techie.springredditclone.mapper;

import com.programming.techie.springredditclone.dto.DepartmentDto;
import com.programming.techie.springredditclone.model.Post;
import com.programming.techie.springredditclone.model.Department;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(Department.getPosts()))")
    DepartmentDto mapDepartmentToDto(Department Department);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Department mapDtoToDepartment(DepartmentDto DepartmentDto);
}
