package com.zeusyohaan.SearchEngine;
import com.zeusyohaan.Data.SqlData;
import com.zeusyohaan.Data.vegData;
import com.zeusyohaan.DependencyInjector.Injector;
import java.util.*;
public class searchEngine {
    SqlData sqlData = Injector.buildVegDataSQL();
    public List<String> searchItem(List<vegData> dataList, String item){
        List<String> results = new ArrayList<>();
        for(vegData element : dataList){
            String elements = element.getTitle();
            if(elements.toLowerCase().contains(item.toLowerCase())){
                results.add(elements);
            }
        }
        return results;
    }
    public HashMap<String, List<String>> getItemsFromDB(String item){
        List<vegData> jiomart_total_data = sqlData.getVegDataDB("jiomart");
        List<vegData> flipkart_total_data = sqlData.getVegDataDB("flipkart");

        List<String> jiomart_results = searchItem(jiomart_total_data, item);
        List<String> flipkart_results = searchItem(flipkart_total_data, item);
        System.out.println(jiomart_results);
        HashMap<String, List<String>> results = new HashMap<>();
        results.put("JioMart", jiomart_results);
        results.put("Flipkart", flipkart_results);
        return results;
    }

    public static void main(String[] args) {
        searchEngine searchEngine = new searchEngine();
        searchEngine.getItemsFromDB("orange");
    }
}
