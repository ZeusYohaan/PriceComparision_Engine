package com.zeusyohaan.SearchEngine;
import com.zeusyohaan.Data.SqlData;
import com.zeusyohaan.Data.vegData;
import com.zeusyohaan.DependencyInjector.Injector;
import java.util.*;
public class searchEngine {
    SqlData sqlData = Injector.buildVegDataSQL();
    public HashMap<String, String> searchItem(List<vegData> dataList, String item){
        HashMap<String, String> results = new HashMap<>();
        for(vegData element : dataList){
            String elementTitle = element.getTitle();
            String elementId = element.getDataId();
            if(elementTitle.toLowerCase().contains(item.toLowerCase())){
                results.put(elementId, elementTitle);
            }
        }
        return results;
    }
    public HashMap<String, HashMap<String, String>> getItemsFromDB(String item){
        List<vegData> jiomart_total_data = sqlData.getVegDataDB("jiomart");
        List<vegData> flipkart_total_data = sqlData.getVegDataDB("flipkart");

        HashMap<String, String> jiomart_results = searchItem(jiomart_total_data, item);
        HashMap<String, String> flipkart_results = searchItem(flipkart_total_data, item);
        System.out.println("Flipkart:"+flipkart_results);
        System.out.println("Jiomart:"+jiomart_results);
        HashMap<String, HashMap<String, String>> results = new HashMap<>();
        results.put("JioMart", jiomart_results);
        results.put("Flipkart", flipkart_results);
        return results;
    }

    public static void main(String[] args) {
        searchEngine searchEngine = new searchEngine();
        searchEngine.getItemsFromDB("orange");
    }
}
