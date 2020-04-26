package com.jero.general.online.vo;

import com.jero.general.online.entity.CodeBaseInfoEO;
import com.jero.general.online.entity.CodeDatabaseInfoEO;
import com.jero.general.online.entity.CodeHtmlInfoEO;
import com.jero.general.online.entity.CodeIndexInfoEO;

/**
 * @Description code全部数据的VO
 * @Author lixuetao
 * @Date 2020/4/26
 **/
public class CodeAllInfoVO {

    private CodeBaseInfoEO baseInfoEO;

    private CodeDatabaseInfoEO databaseInfoEO;

    private CodeHtmlInfoEO htmlInfoEO;

    private CodeIndexInfoEO indexInfoEO;

    public CodeBaseInfoEO getBaseInfoEO() {
        return baseInfoEO;
    }

    public void setBaseInfoEO(CodeBaseInfoEO baseInfoEO) {
        this.baseInfoEO = baseInfoEO;
    }

    public CodeDatabaseInfoEO getDatabaseInfoEO() {
        return databaseInfoEO;
    }

    public void setDatabaseInfoEO(CodeDatabaseInfoEO databaseInfoEO) {
        this.databaseInfoEO = databaseInfoEO;
    }

    public CodeHtmlInfoEO getHtmlInfoEO() {
        return htmlInfoEO;
    }

    public void setHtmlInfoEO(CodeHtmlInfoEO htmlInfoEO) {
        this.htmlInfoEO = htmlInfoEO;
    }

    public CodeIndexInfoEO getIndexInfoEO() {
        return indexInfoEO;
    }

    public void setIndexInfoEO(CodeIndexInfoEO indexInfoEO) {
        this.indexInfoEO = indexInfoEO;
    }
}
