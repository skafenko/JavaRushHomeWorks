package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

/**
 * Created by Mykhailo on 23.08.2016.
 */
public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";


    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            String updatedFile = getUpdatedFileContent(vacancies);
            updateFile(updatedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("junior");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    protected Document getDocument() throws IOException {
        Document document = Jsoup.parse(new File(filePath), "UTF-8");
        return document;
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        try {
            Document document = getDocument();
            Elements template = document.select(".template");

            Elements templateCopy = template.clone();
            templateCopy.removeAttr("style");
            templateCopy.removeClass("template");

            Elements vacancyRemove = document.select(".vacancy").not(".template");
            vacancyRemove.remove();

            for (Vacancy vacancy : vacancies) {
                Elements vacancyHtml = templateCopy.clone();
                vacancyHtml.select(".city").html(vacancy.getCity());
                vacancyHtml.select(".companyName").html(vacancy.getCompanyName());
                vacancyHtml.select(".salary").html(vacancy.getSalary());
                vacancyHtml.select("a").html(vacancy.getTitle()).attr("href", vacancy.getUrl());
                vacancyHtml.select(".date").html(vacancy.getDate());


                template.before(vacancyHtml.outerHtml());
            }
            return document.html();
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(file);
        }
    }


}
