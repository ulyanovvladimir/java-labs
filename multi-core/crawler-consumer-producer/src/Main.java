import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static Logger log = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        //todo удалить, это же просто демонстрация работы библиотеки парсинга по сети
        demo();



        //todo Создать блокирующую очередь для URL (???Queue<String>)
        //todo Создать множество обработанных ссылок (Set<String>)
        //todo Создать блокирующую очередь для документов ( ???Queue<Document>)

        //Добавить в очередь для URL адрес домена для скачивания, например, http://isu.ru

        /* Producer
        todo Запустить n потоков-производителей, которые будут брать URL из очереди, скачивать и класть Document в очередь документов.
        todo По завершении добавлять обработанный URL в множество обработанных ссылок.
        todo Занести обработанный URL в журнал (вывести на консоль)
        */

        /* Consumer
        todo Запустить m потоков-потребителей, которые будут брать Document из очереди, получать список URL из него.
        todo Отфильтровывать только те, что начинаются с указанного домена и не входят в множество обработанных гиперссылок
        todo Добавить полученный отфильтрованный список URL в очередь
        */
    }


    public static void demo() {
        try {
            String domain = "http://isu.ru";
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
