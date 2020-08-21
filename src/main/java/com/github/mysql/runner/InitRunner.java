package com.github.mysql.runner;

import com.github.mysql.pojo.table.DepDO;
import com.github.mysql.pojo.table.EmpDO;
import com.github.mysql.repository.IDepRepository;
import com.github.mysql.repository.IEmpRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午11:16 2019/9/11
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
public class InitRunner implements CommandLineRunner {

    @Resource
    private IDepRepository depRepository;

    @Resource
    private IEmpRepository empRepository;

    @Override
    public void run(String... args) throws Exception {

        DepDO dep = DepDO.builder().depName("TestDep").build();
        dep = depRepository.save(dep);
        log.info("保存 dep - {}", dep.toString());
        for (int i = 0; i < 13; i++) {
            EmpDO emp = EmpDO.builder().empName("TestEmp:" + i).dep(dep).build();
            empRepository.save(emp);
            log.info("保存 emp - {}", i);
        }


    }

}
