package br.com.criativasoft.addressextractor;

import java.util.List;

/**
 *
 * @author Ricardo JL Rufino
 */
public interface ResultBuilder {
    
    public String getResult(List<AddressInfo> addressInfos);
    
}
