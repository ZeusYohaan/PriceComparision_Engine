package com.zeusyohaan.Manager;
import com.zeusyohaan.Data.vegData;
import com.zeusyohaan.DependencyInjector.Injector;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.HashMap;
import java.util.List;

public class productManager {
    public HashMap<String, Integer> getPlotData(String tableName, String dataID){
        HashMap<String, Integer> plotData = new HashMap<>();
        List<vegData> vegDataList = Injector.buildVegDataSQL().getVegDataQueryDB(tableName, dataID);
        for(vegData items : vegDataList){
            String price = items.getPrice().substring(1);
            plotData.put(items.getDate(), Integer.parseInt(price));
        }
        System.out.println(plotData);
        return plotData;
    }

    public CategoryDataset createDataset(HashMap<String, Integer> plotData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (HashMap.Entry<String, Integer> entry : plotData.entrySet()) {
            dataset.addValue(entry.getValue(), "Data", entry.getKey());
        }

        return dataset;
    }

    public JFreeChart createPlot(CategoryDataset dataset, String title) {
        return ChartFactory.createBarChart(
                title,
                "X Axis",
                "Y Axis",
                dataset
        );
    }

    public static void main(String[] args) {
        productManager productManager = new productManager();
        System.out.println(productManager.getPlotData("flipkart", "FRTFFHGPTXHU8GAJ"));
    }
}
