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
 * Created by Mykhailo on 01.09.2016.
 */
public class RobotaStrategy implements Strategy {
    private static final String URL_FORMAT = "http://rabota.ua/jobsearch/vacancy_list?keyWords=java+%s&pg=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36";
    private static final String REFERRER = "https://www.google.com.ua";
    private static final String SITE_NAME = "http://rabota.ua/";

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent(USER_AGENT).referrer(REFERRER).get();
    }
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 1;
        try {
            while (true) {
                Document doc = getDocument(searchString, page++);
                Elements elements = doc.getElementsByClass("v");

                if (elements.isEmpty() || elements == null) break;

                for (Element element : elements) {
                    Element titleElememt = element.getElementsByClass("t").first();
                    String title = "";
                    String url = "";
                    String city = "";
                    String date = "";
                    if (titleElememt != null) {
                        title = titleElememt.text();
                        url = titleElememt.attr("abs:href");
                        Document document = Jsoup.connect(url).get();
                        Element cityElement = document.select("[itemprop=addressLocality]").first();
                        if (cityElement != null) {
                            city = cityElement.text();
                        }

                        Element dateElement = document.select("[itemprop=datePosted]").first();
                        if (dateElement != null) {
                            date = dateElement.text();
                        }
                    }

                    Element salaryElement = element.select(".s b").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }


                    Element companyNameElement = element.select(".s a").first();
                    String companyName = "";
                    if (companyNameElement != null) {
                        companyName = companyNameElement.text();
                    }

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(SITE_NAME);
                    vacancy.setUrl(url);
                    vacancy.setDate(date);
                    vacancies.add(vacancy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vacancies;
    }
}
