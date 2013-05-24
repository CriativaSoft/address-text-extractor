package br.com.criativasoft.addressextractor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Ricardo JL Rufino
 */
public class ApontadorExtractorV1 implements Extractor {

    public List<AddressInfo> extract(String url) throws IOException {

        List<AddressInfo> addressList = new LinkedList<AddressInfo>();

        Document doc = Jsoup.connect(url).get();
        Elements results = doc.select("#search_result .result");

        for (Element divResult : results) {

            Elements select = divResult.select("h2.item a");
            String name = select.text();

            select = divResult.select("span.street-address");
            String address = select.text();

            select = divResult.select("span.locality");
            String city = select.text();

            select = divResult.select("span.tel");
            String phone = select.text();

            AddressInfo addressInfo = new AddressInfo();
            addressInfo.setName(name);
            addressInfo.setAddress(address);
            addressInfo.setPhone(phone);
            addressInfo.setCity(city);


            addressList.add(addressInfo);

        }

        return addressList;
    }

    public boolean accept(String url) {
        return url.contains("apontador.com.br");
    }
    
    
}
