import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.logging.Logger;

public class Main {
    public static Logger log = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        //todo удалить, это же просто демонстрация работы библиотеки парсинга по сети
        demo("http://avacar38.com");


        //todo Создать блокирующую очередь для URL (???Queue<String>)
        BlockingQueue<String> urls = new ArrayBlockingQueue<String>(100);
        //todo Создать множество обработанных ссылок (Set<String>)
        Set<String> done = new ConcurrentSkipListSet<String>();
        //todo Создать блокирующую очередь для документов ( ???Queue<Document>)
        BlockingQueue<Document> docs = new ArrayBlockingQueue<Document>(100);
        //Добавить в очередь для URL адрес домена для скачивания, например, http://isu.ru
        String domain = "http://avacar38.com";
        try {
            urls.put(domain);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* Producer
        todo Запустить n потоков-производителей, которые будут брать URL из очереди, скачивать и класть Document в очередь документов.
        todo По завершении добавлять обработанный URL в множество обработанных ссылок.
        todo Занести обработанный URL в журнал (вывести на консоль)
        */
        DownloaderThread[] producers = new DownloaderThread[10];
        for (int i = 0; i < 10; i++) {
            producers[i] = new DownloaderThread(urls, docs, done);
            producers[i].start();
        }

        /* Consumer
        todo Запустить m потоков-потребителей, которые будут брать Document из очереди, получать список URL из него.
        todo Отфильтровывать только те, что начинаются с указанного домена и не входят в множество обработанных гиперссылок
        todo Добавить полученный отфильтрованный список URL в очередь
        */

        ExtractorThread[] consumers = new ExtractorThread[10];
        for (int i = 0; i < 10; i++) {
            consumers[i] = new ExtractorThread(docs, urls, done, domain);
            consumers[i].start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(!docs.isEmpty() || !urls.isEmpty()){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (ExtractorThread consumer : consumers) {
            System.out.println(consumer.getState());
        }
        for (DownloaderThread thread : producers) {
            System.out.println(thread.getState());
        }

    }


    public static void demo(String domain) {
        try {
            //produce: получаем документ по URL
            Document doc = download(domain);
            //consume: получаем ссылки из документа
            List<String> links = extractLinks(doc);
            for (String link : links) {
                log.info(link);
            }
        } catch (IOException e) {
            log.severe("Can not download url+ " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    /* Producer
        todo будут брать URL из очереди, скачивать и класть Document в очередь документов.
        todo По завершении добавлять обработанный URL в множество обработанных ссылок.
        todo Занести обработанный URL в журнал (вывести на консоль)
        */
    static class DownloaderThread extends Thread {
        private final BlockingQueue<String> urls;
        private final BlockingQueue<Document> docs;
        private final Set<String> done;

        public DownloaderThread(BlockingQueue<String> urls, BlockingQueue<Document> docs, Set<String> done) {
            this.urls = urls;
            this.docs = docs;
            this.done = done;
        }

        @Override
        public void run() {
            while (true) {
                String url = null;
                try {
                    url = urls.take();
                    Document doc = download(url);
                    docs.put(doc);
                    done.add(url);
                    log.info("Done: " + url);
                } catch (InterruptedException e) {
                    log.severe("Downloader thread interrupted " + e.getLocalizedMessage());
                    e.printStackTrace();
                } catch (IOException e) {
                    log.severe("Can not download "+url);
                    e.printStackTrace();
                }
            }
        }
    }

    static class ExtractorThread extends Thread {
        private final BlockingQueue<Document> docs;
        private final BlockingQueue<String> urls;
        private final Set<String> done;
        private final String domain;

        public ExtractorThread(BlockingQueue<Document> docs, BlockingQueue<String> urls, Set<String> done, String domain) {
            this.docs = docs;
            this.urls = urls;
            this.done = done;
            this.domain = domain;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Document doc = docs.take();
                    List<String> links = extractLinks(doc);
                    for (String link : links) {
                        if (!done.contains(link) && link.startsWith(domain)) {
                            urls.put(link);
                        }
                    }

                } catch (InterruptedException e) {
                    log.severe("extructor thread interrupted " + e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }
    }


    public static Document download(String url) throws IOException {
        Document doc;
        Connection connect = Jsoup.connect(url);
        //todo прописать прокси-сервер, если выполняем в ISU
        //connect.proxy("http://proxy.isu.ru",3128);
        doc = connect.get();
        return doc;
    }

    public static List<String> extractLinks(Document doc) {
        //Список элементов, содержащих гиперссылки (тэги <a> с атрибутом href)
        Elements els = doc.select("a[href]");
        List<String> ret = new ArrayList<String>();
        for (Element el : els) {
            //Получаем значение атрибута href. Опция abs:href возвращает абослютный путь
            ret.add(el.attr("abs:href"));
        }
        return ret;
    }
}
