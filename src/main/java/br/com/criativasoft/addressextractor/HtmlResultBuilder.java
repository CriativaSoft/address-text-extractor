package br.com.criativasoft.addressextractor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo JL Rufino
 */
public class HtmlResultBuilder implements ResultBuilder{
    
    private static final String BR = "<br/>";

    public String getResult(List<AddressInfo> addressInfos) {
       
        StringBuilder sb = new StringBuilder();
        
        for (AddressInfo addressInfo : addressInfos) {
            
            sb.append("<b>"+addressInfo.getName()+"</b>  ");
            googleLink(addressInfo, sb);
            sb.append(BR);
            sb.append(addressInfo.getAddress());
            sb.append(BR);
            sb.append(addressInfo.getPhone());
            sb.append(BR);
            sb.append(addressInfo.getCity());
            sb.append(BR);
            sb.append("============================");
            sb.append(BR);
            
        }
            
        return sb.toString();
        
    }
    
    private void googleLink(AddressInfo addressInfo,StringBuilder sb){
        try {
            sb.append("<a href=\"https://www.google.com.br/search?q=");
            String encode = URLEncoder.encode(addressInfo.getName() +" - " + addressInfo.getCity(), Charset.defaultCharset().name());
            sb.append(encode);
            sb.append("\">(google)</a>");
//            sb.append("<img src=\"https://www.google.com.br/images/google_favicon_128.png\" width=\"18\" height=\"18\" />");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HtmlResultBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
