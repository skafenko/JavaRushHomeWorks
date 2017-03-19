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
 * Created by Mykhailo on 24.08.2016.
 */
public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36";
    private static final String REFERRER = "https://www.google.com.ua";
    private static final String SITE_NAME = "http://moikrug.ru/";

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
                Elements elements = doc.getElementsByClass("job");

                if (elements.isEmpty() || elements == null) break;

                for (Element element : elements) {
                    Element titleElememt = element.getElementsByClass("title").first();
                    String title = "";
                    if (titleElememt != null) {
                        title = titleElememt.text();
                    }

                    Element salaryElement = element.getElementsByClass("salary").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }
                    Element cityElement = element.getElementsByClass("location").first();
                    String city = "";
                    if (cityElement != null) {
                        city = cityElement.text();
                    }

                    Element companyNameElement = element.getElementsByClass("company_name").first();
                    String companyName = "";
                    if (cityElement != null) {
                        companyName = companyNameElement.text();
                    }

                    Element dateElement = element.getElementsByClass("date").first();
                    String date = "";
                    if (dateElement != null) {
                        date = dateElement.text();
                    }

                    String url = titleElememt.getElementsByTag("a").attr("abs:href");


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
