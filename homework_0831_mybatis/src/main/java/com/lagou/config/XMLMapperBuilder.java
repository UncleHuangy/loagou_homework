package com.lagou.config;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration =configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {

        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        String namespace = rootElement.attributeValue("namespace");

        List<Element> selectList = rootElement.selectNodes("//select");
        if (!selectList.isEmpty()){
            for (Element element : selectList) {
                String id = element.attributeValue("id");
                String resultType = element.attributeValue("resultType");
                String paramterType = element.attributeValue("paramterType");
                String sqlText = element.getTextTrim();
                MappedStatement mappedStatement = new MappedStatement();
                mappedStatement.setId(id);
                mappedStatement.setResultType(resultType);
                mappedStatement.setParamterType(paramterType);
                mappedStatement.setSql(sqlText);
                String key = namespace+"."+id;
                configuration.getMappedStatementMap().put(key,mappedStatement);

            }
        }

        List<Element> updateList = rootElement.selectNodes("//update");
        if (!updateList.isEmpty()){
            for (Element element : updateList) {
                String id = element.attributeValue("id");
                String paramterType = element.attributeValue("paramterType");
                String sqlText = element.getTextTrim();
                MappedStatement mappedStatement2 = new MappedStatement();
                mappedStatement2.setId(id);
                mappedStatement2.setParamterType(paramterType);
                mappedStatement2.setSql(sqlText);
                String key = namespace+"."+id;
                configuration.getMappedStatementMap().put(key,mappedStatement2);
            }
        }

    }


}
