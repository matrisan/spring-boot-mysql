package com.github.mysql.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author 石少东
 * @date 2020-11-29 22:32
 * @since 1.0
 */

@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressBO implements Serializable {

    private static final long serialVersionUID = 8330351916838251803L;

    private String name;

    private String path;

}
