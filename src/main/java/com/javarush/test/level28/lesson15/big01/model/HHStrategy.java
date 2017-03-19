package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykhailo on 21.08.2016.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";//&only_with_salary=true
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36";
    private static final String REFERRER = "https://www.google.com.ua";
    private static final String SITE_NAME = "http://hh.ua/";

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent(USER_AGENT).referrer(REFERRER).get();
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 0;
        try {
            while (true) {
                Document doc = getDocument(searchString, page++);
                Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");

                if (elements.isEmpty() || elements == null) break;

                for (Element element : elements) {
                    Elements title = element.select("[data-qa=vacancy-serp__vacancy-title]");
                    String url = title.attr("abs:href");
                    Elements salary = element.select("[data-qa=vacancy-serp__vacancy-compensation]");
                    Elements city = element.select("[data-qa=vacancy-serp__vacancy-address]");
                    Elements companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]");
                    Elements date = element.select("[data-qa=vacancy-serp__vacancy-date]");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title.text());
                    vacancy.setSalary(salary.text());
                    vacancy.setCity(city.text());
                    vacancy.setCompanyName(companyName.text());
                    vacancy.setSiteName(SITE_NAME);
                    vacancy.setUrl(url);
                    vacancy.setDate(date.text());
                    vacancies.add(vacancy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vacancies;
    }
}
