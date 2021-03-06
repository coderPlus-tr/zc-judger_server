package edu.zc.oj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author keep-looking
 * @date 2021/3/5 - 17:47
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Run {
    /**
     * Run entity members
     */
    private String command;
    private String seccompRule;
    private String[] env;

}