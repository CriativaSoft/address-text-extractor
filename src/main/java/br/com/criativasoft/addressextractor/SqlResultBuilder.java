package br.com.criativasoft.addressextractor;

import java.util.List;

/**
 *
 * @author Ricardo JL Rufino
 */
public class SqlResultBuilder implements ResultBuilder{
    private static final String BR = "<br/>";
    
    public String getResult(List<AddressInfo> addressInfos) {
       
        StringBuilder sb = new StringBuilder();
        
        for (AddressInfo addressInfo : addressInfos) {
            
            sb.append("INSERT INTO Table values (");
            sb.append("\""+addressInfo.getName()+"\",");
            sb.append("\""+addressInfo.getAddress()+"\",");
            sb.append("\""+addressInfo.getPhone()+"\",");
            sb.append("\""+addressInfo.getCity()+"\"");
            sb.append(");");
            sb.append(BR);
            
        }
            
        return sb.toString();
        
    }
    
    
}
