package com.github.mysql.pojo.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author 石少东
 * @date 2020-11-18 23:37
 * @since 1.0
 */

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ItemDO {

    private String itemName;

    private Integer price;

}
