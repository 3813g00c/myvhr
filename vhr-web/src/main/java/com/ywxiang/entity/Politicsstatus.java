package com.ywxiang.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 政治面貌实体类
 *
 * @author ywxiang
 */
public class Politicsstatus implements Serializable {
    private static final long serialVersionUID = -3106297589021903434L;
    private Integer id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        com.ywxiang.entity.Politicsstatus that = (com.ywxiang.entity.Politicsstatus) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public Politicsstatus() {

    }

    public Politicsstatus(String name) {

        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}