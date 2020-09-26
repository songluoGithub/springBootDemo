package com.example.proj;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/26 9:08   部门表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private int id;
    private String departmentName;
}
