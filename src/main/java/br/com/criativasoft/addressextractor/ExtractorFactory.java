package br.com.criativasoft.addressextractor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ricardo JL Rufino
 */
public class ExtractorFactory {
    
    private ExtractorFactory(){
    }
    
    private static final List<Extractor> EXTRACTORS = new LinkedList<Extractor>();
    
    static{
        
        EXTRACTORS.add(new ApontadorExtractorV1());
        
    }
    
    public static Extractor create(String url){
        for (Extractor extractor : EXTRACTORS) {
            if(extractor.accept(url)){
                return extractor;
            }
        }
        
        return null;
    }
      
    
}
