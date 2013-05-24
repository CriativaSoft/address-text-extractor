package br.com.criativasoft.addressextractor;

import java.io.IOException;
import java.util.List;


/**
 * @author Ricardo JL Rufino
 */
public interface Extractor {
    public List<AddressInfo> extract(String url) throws IOException;
    
    public boolean accept(String url);
}
