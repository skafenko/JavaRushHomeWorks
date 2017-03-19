package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by Mykhailo on 21.08.2016.
 */
public class Aggregator {
    public static void main(String[] args) {
        Provider hhProvider = new Provider(new HHStrategy());
        Provider moikrugProvider = new Provider(new MoikrugStrategy());
        Provider robotaProvider = new Provider(new RobotaStrategy());

        HtmlView view = new HtmlView();

        Model model = new Model(view, hhProvider);
//        Model model = new Model(view, robotaProvider, moikrugProvider, hhProvider);

        Controller controller = new Controller(model);

        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
