package com.powernode.xml.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;

public class ParseXMLByDOM4jTest {
    @Test
    public void testParseMyBatisConfigXML() throws Exception {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //获取输入流
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        //读XML文件，返回document对象。document对象是文档对象，代表了整个XML文件
        Document document = reader.read(is);

        //获取default默认的环境id
        //xpath是做标签路径匹配的。能够让我们快速定位xml文件中的元素
        //一下阿德xpath代表了：从根下开始找configuration标签，然后找configuration标签下的子标签environments
        String xpath = "/configuration/environments";
        Element environments = (Element) document.selectSingleNode(xpath);//Element是node类的子类，方法更多，使用更便捷
        //获取属性的值
        String defaultEnvironmentId = environments.attributeValue("default");
        //System.out.println(defaultEnvironmentId);
        //获取具体的环境environment
        xpath = "/configuration/environment/environment[@id='"+defaultEnvironmentId+"']";
        System.out.println(xpath);
        Element environment = (Element) document.selectSingleNode(xpath);
    }
}
