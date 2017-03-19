package com.javarush.test.level36.lesson04.home01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykhailo on 27.11.2016.
 */
public class Model {

    Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }
}
