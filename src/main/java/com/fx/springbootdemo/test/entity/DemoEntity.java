package com.fx.springbootdemo.test.entity;


import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 *
 * @author fxiao
 * @date 2019/1/3 21:06
 */
public class DemoEntity {
    @NotEmpty
    private String id;
    private List<LittleEntity> littleEntities;

    public DemoEntity(@NotEmpty String id, List<LittleEntity> littleEntities) {
        this.id = id;
        this.littleEntities = littleEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<LittleEntity> getLittleEntities() {
        return littleEntities;
    }

    public void setLittleEntities(List<LittleEntity> littleEntities) {
        this.littleEntities = littleEntities;
    }
}
