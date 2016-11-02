/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comdriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author samo
 */
public class HomeController implements Initializable {
    private static final String _configDir = "Configs";
    private static final String _new = "New*";
    private static final String _add = "+";
    
    private File[] configFiles;
    
    private Configuration configs;
    
    
    
    
    @FXML
    TabPane mainTabPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initConfigFiles();
        
        if(configFiles == null || configFiles.length == 0)
        {
            loadNewTab();
        }
        else
        {
           // loadTabsFromFiles();
        
        }
        appendAddTab();
        
        try {
            buildConfigPane();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    private void buildConfigPane() throws IOException
    {
       Parent root = FXMLLoader.load(getClass().getResource("BuildConfigPane.fxml"));
       mainTabPane.getTabs().get(0).setContent(root);
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * 
     */
    private void appendAddTab()
    {
        Tab addTab = new Tab();
        addTab.setText(_add);
        mainTabPane.getTabs().add(addTab);
    }
    
    
    
    
    /**
     * 
     */
    private void loadNewTab()
    {
        
        Tab newTab = new Tab();
        newTab.setText(_new);
        mainTabPane.getTabs().add(newTab);
    
    }
    
    
    
    
    
    
    /**
     * 
     */
    private void initConfigFiles()
    {
        File file = new File(_configDir);
        if(!file.exists())
        {
            file.mkdir();
            configFiles = null;
        }
        else
        {
            configFiles = file.listFiles();
        }
    }
    
    
    
    
    

    /**
     * @return the configFiles
     */
    public File[] getConfigFiles() {
        return configFiles;
    }

    /**
     * @param configFiles the configFiles to set
     */
    public void setConfigFiles(File[] configFiles) {
        this.configFiles = configFiles;
    }

    /**
     * @return the configs
     */
    public Configuration getConfigs() {
        return configs;
    }

    /**
     * @param configs the configs to set
     */
    public void setConfigs(Configuration configs) {
        this.configs = configs;
    }
    
}
