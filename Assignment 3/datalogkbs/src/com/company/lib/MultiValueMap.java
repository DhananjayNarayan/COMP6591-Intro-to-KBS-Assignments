package com.company.lib;

import java.util.HashMap;

public class MultiValueMap extends HashMap<String, Object> {
    public MultiValueMap() {
        super();
    }
    public MultiValueMap(HashMap<String, Object> m) {
        super(m);
    }
    public static MultiValueMap parse(String text) {
        return parse(text, false);
    }
    public static MultiValueMap parse(String text, boolean numbers) {
        MultiValueMap result = new MultiValueMap();
        for (String pair: text.split("&")) {
            String nv[] = pair.split("=");
            if(nv.length != 2) {
                throw new RuntimeException("Invalid name value pair: " + pair);
            }
            if(numbers) {
                try {
                    result.put(nv[0], Integer.parseInt(nv[1]));
                    continue;
                }
                catch(Exception e){
                }
                try {
                    result.put(nv[0], Double.parseDouble(nv[1]));
                    continue;
                }
                catch(Exception e2){
                }
            }
            result.put(nv[0], nv[1]);
        }
        return result;
    }
}
