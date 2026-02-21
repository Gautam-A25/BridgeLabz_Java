package designpattern;

import java.util.ArrayList;
import java.util.List;

interface NewsObserver {
    void update(String news);
}

class NewsAgency {

    private List<NewsObserver> observers = new ArrayList<>();

    public void addObserver(NewsObserver observer) {
        observers.add(observer);
    }

    public void publishNews(String news) {
        for (NewsObserver observer : observers) {
            observer.update(news);
        }
    }
}

class NewsChannel implements NewsObserver {

    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {

        NewsAgency agency = new NewsAgency();

        NewsObserver channel1 = new NewsChannel("Channel 1");
        NewsObserver channel2 = new NewsChannel("Channel 2");

        agency.addObserver(channel1);
        agency.addObserver(channel2);

        agency.publishNews("Design Patterns are important!");
    }
}