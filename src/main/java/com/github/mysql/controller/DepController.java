package com.github.mysql.controller;


import com.github.mysql.pojo.table.DepDO;
import com.github.mysql.repository.IDepRepository;
import com.github.mysql.repository.IEmpRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 创建时间为 00:35 2019-07-04
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class DepController {

    private final IDepRepository depRepository;

    private final IEmpRepository empRepository;

    public DepController(IDepRepository depRepository, IEmpRepository empRepository) {
        this.depRepository = depRepository;
        this.empRepository = empRepository;
    }

    @GetMapping("/deps")
    public List<DepDO> findAll() {
        return depRepository.findAll();
    }

    @GetMapping("/dep/{id}")
    public DepDO getDep(@PathVariable("id") DepDO depDO) {
        return depDO;
    }

    @PostMapping("/dep")
    public DepDO create(@RequestBody DepDO dep) {
        return depRepository.save(dep);
    }

    @PutMapping("/dep")
    public DepDO update(@RequestBody DepDO dep) {
        return depRepository.save(dep);
    }

    @DeleteMapping("/dep/{id}")
    public void deleteById(@PathVariable Long id) {
        depRepository.deleteById(id);
    }

    @DeleteMapping("/dep/emp/{depId}/{empId}")
    public DepDO deleteEmpById(@PathVariable Long depId, @PathVariable Long empId) {
        Optional<DepDO> optionalDep = depRepository.findById(depId);
        optionalDep.ifPresent(depDO -> depDO.getEmps().remove(empId));
       return optionalDep.get();
    }


}
