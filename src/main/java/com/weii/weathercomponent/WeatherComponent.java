/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weii.weathercomponent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weii.weathercomponent.weather.WeatherInfoModel;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Patryk
 */
public class WeatherComponent extends javax.swing.JPanel {

    private boolean blackThemeEnabled;
    private PropertyChangeSupport propertyChangeSupport;
    /**
     * Creates new form WeatherComponent
     */
    public WeatherComponent() {
        initComponents();
        propertyChangeSupport=new PropertyChangeSupport(this);
        initListModel();
        initListView();
        initSearchMechanism();
        initClearButton();
        initSaveButton();
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener l) {
        
        if(l==null)
            return;
//        propertyChangeSupport.addPropertyChangeListener(l);
    }
    
    /**
     * 
     * Method which enable black theme on the component
     * @param blackThemeEnabled defines wether black theme is enabled or disabled
     */
    public void setBlackThemeEnabled(boolean blackThemeEnabled){
        propertyChangeSupport.firePropertyChange("direction", this.blackThemeEnabled, blackThemeEnabled);
        this.blackThemeEnabled = blackThemeEnabled;       
        if(blackThemeEnabled){
            this.cityLabel.setBackground(Color.BLACK);
            this.coordsLabel.setBackground(Color.BLACK);
            this.clearButton.setBackground(Color.BLACK);
            this.saveButton.setBackground(Color.BLACK);
            this.humLabel.setBackground(Color.BLACK);
            this.jList2.setBackground(Color.BLACK);
            this.historyList.setBackground(Color.BLACK);
            this.jPanel1.setBackground(Color.BLACK);
            this.jScrollPane2.setBackground(Color.BLACK);
            this.jScrollPane3.setBackground(Color.BLACK);
            this.jScrollPane3.setBackground(Color.BLACK);
            this.pressLabel.setBackground(Color.BLACK);
            this.searchField.setBackground(Color.BLACK);
            this.sunLabel.setBackground(Color.BLACK);
            this.tempLabel.setBackground(Color.BLACK);
            this.cityLabel.setForeground(Color.WHITE);
            this.coordsLabel.setForeground(Color.WHITE);
            this.clearButton.setForeground(Color.WHITE);
            this.saveButton.setForeground(Color.WHITE);
            this.humLabel.setForeground(Color.WHITE);
            this.jList2.setForeground(Color.WHITE);
            this.historyList.setForeground(Color.WHITE);
            this.jPanel1.setForeground(Color.WHITE);
            this.jScrollPane2.setForeground(Color.WHITE);
            this.jScrollPane3.setForeground(Color.WHITE);
            this.jScrollPane3.setForeground(Color.WHITE);
            this.pressLabel.setForeground(Color.WHITE);
            this.searchField.setForeground(Color.WHITE);
            this.sunLabel.setForeground(Color.WHITE);
            this.tempLabel.setForeground(Color.WHITE);
            this.searchButton.setBackground(Color.BLACK);
            this.searchButton.setForeground(Color.WHITE);
            this.saveButton.setBackground(Color.BLACK);
            this.saveButton.setForeground(Color.WHITE);
            this.clearButton.setBackground(Color.BLACK);
            this.clearButton.setForeground(Color.WHITE);
            this.dateLabel.setBackground(Color.BLACK);
            this.dateLabel.setForeground(Color.WHITE);
        }else{
            this.cityLabel.setBackground(Color.WHITE);
            this.coordsLabel.setBackground(Color.WHITE);
            this.clearButton.setBackground(Color.WHITE);
            this.saveButton.setBackground(Color.WHITE);
            this.humLabel.setBackground(Color.WHITE);
            this.jList2.setBackground(Color.WHITE);
            this.historyList.setBackground(Color.WHITE);
            this.jPanel1.setBackground(Color.WHITE);
            this.jScrollPane2.setBackground(Color.WHITE);
            this.jScrollPane3.setBackground(Color.WHITE);
            this.jScrollPane3.setBackground(Color.WHITE);
            this.pressLabel.setBackground(Color.WHITE);
            this.searchField.setBackground(Color.WHITE);
            this.sunLabel.setBackground(Color.WHITE);
            this.tempLabel.setBackground(Color.WHITE);
            this.cityLabel.setForeground(Color.BLACK);
            this.coordsLabel.setForeground(Color.BLACK);
            this.clearButton.setForeground(Color.BLACK);
            this.saveButton.setForeground(Color.BLACK);
            this.humLabel.setForeground(Color.BLACK);
            this.jList2.setForeground(Color.BLACK);
            this.historyList.setForeground(Color.BLACK);
            this.jPanel1.setForeground(Color.BLACK);
            this.jScrollPane2.setForeground(Color.BLACK);
            this.jScrollPane3.setForeground(Color.BLACK);
            this.jScrollPane3.setForeground(Color.BLACK);
            this.pressLabel.setForeground(Color.BLACK);
            this.searchField.setForeground(Color.BLACK);
            this.sunLabel.setForeground(Color.BLACK);
            this.tempLabel.setForeground(Color.BLACK);
            this.searchButton.setBackground(Color.WHITE);
            this.searchButton.setForeground(Color.BLACK);
            this.saveButton.setBackground(Color.WHITE);
            this.saveButton.setForeground(Color.BLACK);
            this.clearButton.setBackground(Color.WHITE);
            this.clearButton.setForeground(Color.BLACK);
            this.dateLabel.setBackground(Color.WHITE);
            this.dateLabel.setForeground(Color.BLACK);
        }
    }
    public boolean getBlackThemeEnabled(){
        return blackThemeEnabled;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        historyList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        cityLabel = new javax.swing.JLabel();
        tempLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        pressLabel = new javax.swing.JLabel();
        humLabel = new javax.swing.JLabel();
        coordsLabel = new javax.swing.JLabel();
        sunLabel = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        historyList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        historyList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(historyList);
        historyList.getAccessibleContext().setAccessibleName("historyList");

        searchButton.setText("Search");

        cityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cityLabel.setText("City");

        tempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempLabel.setText("Temperature");

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Date");

        pressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pressLabel.setText("Pressure");

        humLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        humLabel.setText("Humidity");

        coordsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coordsLabel.setText("Coords");

        sunLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sunLabel.setText("Sunrise and sunset");
        sunLabel.setToolTipText("");
        sunLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tempLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(humLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(coordsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sunLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(humLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coordsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sunLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        humLabel.getAccessibleContext().setAccessibleName("Humidity");

        clearButton.setText("Clear");

        saveButton.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3)))
        );

        clearButton.getAccessibleContext().setAccessibleName("clearButton");
        saveButton.getAccessibleContext().setAccessibleName("saveButton");
    }// </editor-fold>//GEN-END:initComponents

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }

    public JLabel getCityLabel() {
        return cityLabel;
    }

    public void setCityLabel(JLabel cityLabel) {
        this.cityLabel = cityLabel;
    }

    public JLabel getCoordsLabel() {
        return coordsLabel;
    }

    public void setCoordsLabel(JLabel coordsLabel) {
        this.coordsLabel = coordsLabel;
    }

    public JLabel getDateLabel() {
        return dateLabel;
    }

    public void setDateLabel(JLabel dateLabel) {
        this.dateLabel = dateLabel;
    }

    public JList<String> getHistoryList() {
        return historyList;
    }

    public JLabel getHumLabel() {
        return humLabel;
    }

    public void setHumLabel(JLabel humLabel) {
        this.humLabel = humLabel;
    }
    
    

    public void setHistoryList(JList<String> historyList) {
        this.historyList = historyList;
    }

    public JLabel getPressLabel() {
        return pressLabel;
    }

    public void setPressLabel(JLabel pressLabel) {
        this.pressLabel = pressLabel;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public JLabel getSunLabel() {
        return sunLabel;
    }

    public void setSunLabel(JLabel sunLabel) {
        this.sunLabel = sunLabel;
    }

    public JLabel getTempLabel() {
        return tempLabel;
    }

    public void setTempLabel(JLabel tempLabel) {
        this.tempLabel = tempLabel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cityLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel coordsLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JList<String> historyList;
    private javax.swing.JLabel humLabel;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel pressLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel sunLabel;
    private javax.swing.JLabel tempLabel;
    // End of variables declaration//GEN-END:variables

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }
    
    
    
    private DefaultListModel<String> historyListModel;
    private List<WeatherInfoModel> weatherList;
    private WeatherInfoModel currentWeather;
    // End of variables declaration                   

    /**
     * init list view for history of weathers
     */
    private void initListView() {
       historyListModel = new DefaultListModel<>();
       weatherList.forEach(x->{
           addElementToHistoryModel(x);
        
       });
       this.getHistoryList().setModel(historyListModel);
       this.getHistoryList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       this.getHistoryList().addListSelectionListener(x->{
           int index = x.getFirstIndex();
           currentWeather = weatherList.get(index);
           setValuesFromWeather(currentWeather);
        });
    }
    private void initListModel() {
        try {
            this.weatherList = new ArrayList<>(WeatherInfoFileManager.readListFromFile());
        } catch (URISyntaxException | IOException ex) {
            this.weatherList = new ArrayList<>();
            ex.printStackTrace();
        }
    }
    
    private void initSaveButton(){
        this.getSaveButton().addActionListener(x->{
            if(currentWeather==null){
                return;
            }
            this.weatherList.add(currentWeather);
            try {
                WeatherInfoFileManager.saveToFile(weatherList);
                addElementToHistoryModel(currentWeather);
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(WeatherComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }
    /**
     * Inits button which clear all the labels
     */
    private void initClearButton(){
        this.getClearButton().addActionListener(x->{
        this.getCityLabel().setText("City");
        this.getPressLabel().setText("Pressure");
        this.getCoordsLabel().setText("Lat");
        this.getDateLabel().setText("Date");
        this.getSunLabel().setText("Sunset");
        this.getTempLabel().setText("Temperature");
        this.getPressLabel().setText("Sunrise");
        this.currentWeather = null;
        });
    }
    
    private void initSearchMechanism() {
        this.getSearchButton().addActionListener(x->searchForTheWeather());
    }

    private String obtainDateFromSeconds(Integer dt) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(dt),ZoneId.systemDefault()).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
        private String obtainHoursFromMillis(Integer dt) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(dt),ZoneId.systemDefault()).format(DateTimeFormatter.ISO_TIME);
    }
/**
 * Sets value from weatherModel to labels
 * @param weatherModel the data model
 */
    private void setValuesFromWeather(WeatherInfoModel weatherModel) {
        double temp = round(weatherModel.getMain().getTemp()-273.15,2);
        this.getCityLabel().setText("City "+weatherModel.getName());
        this.getPressLabel().setText("Pressure "+String.valueOf(weatherModel.getMain().getPressure()));
        this.getCoordsLabel().setText("Lat "+weatherModel.getCoord().getLat()+" Lon "+weatherModel.getCoord().getLon());
        this.getDateLabel().setText("Date "+obtainDateFromSeconds(weatherModel.getDt()));
        this.getTempLabel().setText("Temperature "+String.valueOf(temp)+" C");
        this.getSunLabel().setText("Sunset "+obtainHoursFromMillis(weatherModel.getSys().getSunset())+" Sunrise "+obtainHoursFromMillis(weatherModel.getSys().getSunrise()));
        this.getPressLabel().setText("Pressure "+weatherModel.getMain().getPressure()+" hPa");
        this.getHumLabel().setText("Humidity "+String.valueOf(weatherModel.getMain().getHumidity())+" %");
    }

  private boolean isDoubleOrInt(String doubleOrInt){
    return doubleOrInt.matches("^-?[0-9]+.?[0-9]{0,5}?$");
  }

  /**
   * Adds element to history
   * @param x WeatherInfoModel object
   */
    private void addElementToHistoryModel(WeatherInfoModel x) {
        String date = obtainDateFromSeconds(x.getDt()); 
        String coords = "lat "+x.getCoord().getLat() +" lon "+x.getCoord().getLon();
        historyListModel.addElement(date+" "+coords);
        getHistoryList().setModel(historyListModel);
    }

    private void searchForTheWeather() {
             String searchText = this.getSearchField().getText().trim();
           
           if(searchText.isEmpty()){
               return;
           }
           String jsonWeather;
           if(searchText.contains(",")){
               String[] coords = searchText.split(",");
               if(!isDoubleOrInt(coords[0]) || !isDoubleOrInt(coords[1])){
                   return;
               }
               jsonWeather = ApiHandler.getWeatherInfo(Double.valueOf(coords[0]),Double.valueOf(coords[1]));
           }else{
               jsonWeather = ApiHandler.getWeatherInfo(searchText);
           }
          
            try {
                currentWeather = CommonUtils.getMapper().readValue(jsonWeather,WeatherInfoModel.class);
                setValuesFromWeather(currentWeather);
            } catch (JsonProcessingException ex) {
            }
    }
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
}
