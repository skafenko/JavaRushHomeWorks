package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykhailo on 12.11.2016.
 */
@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    @XmlElement(name = "names")
    @XmlElementWrapper(name = "goods", nillable = true)
    public List<String> goods = new ArrayList<>();

    public int count;

    public double profit;

    @XmlElement(name = "secretData")
    public List<String> secretData;


    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + secretData +
                '}';
    }
}
