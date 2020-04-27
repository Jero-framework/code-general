package com.jero.general.online.vo;

import com.jero.general.online.entity.CodeBaseInfoEO;
import com.jero.general.online.entity.CodeDatabaseInfoEO;
import com.jero.general.online.entity.CodeHtmlInfoEO;
import com.jero.general.online.entity.CodeIndexInfoEO;

import java.util.List;

/**
 * @Description code全部数据的VO
 * @Author lixuetao
 * @Date 2020/4/26
 **/
public class CodeAllInfoVO {

    private CodeBaseInfoEO baseInfoEO;

    private List<CodeDatabaseInfoEO> databaseInfoEOS;

    private List<CodeHtmlInfoEO> htmlInfoEOS;

    private List<CodeIndexInfoEO> indexInfoEOS;

    public CodeBaseInfoEO getBaseInfoEO() {
        return baseInfoEO;
    }

    public void setBaseInfoEO(CodeBaseInfoEO baseInfoEO) {
        this.baseInfoEO = baseInfoEO;
    }

    public List<CodeDatabaseInfoEO> getDatabaseInfoEOS() {
        return databaseInfoEOS;
    }

    public void setDatabaseInfoEOS(List<CodeDatabaseInfoEO> databaseInfoEOS) {
        this.databaseInfoEOS = databaseInfoEOS;
    }

    public List<CodeHtmlInfoEO> getHtmlInfoEOS() {
        return htmlInfoEOS;
    }

    public void setHtmlInfoEOS(List<CodeHtmlInfoEO> htmlInfoEOS) {
        this.htmlInfoEOS = htmlInfoEOS;
    }

    public List<CodeIndexInfoEO> getIndexInfoEOS() {
        return indexInfoEOS;
    }

    public void setIndexInfoEOS(List<CodeIndexInfoEO> indexInfoEOS) {
        this.indexInfoEOS = indexInfoEOS;
    }
}
