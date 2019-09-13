package com.lochana.hangman.repository;

public class DataSourceFactory {


    private DataSourceFactory() {
    }

    public static DataSource create(DataSourceType type, String path){


        if(type == DataSourceType.TEXT){
            return new TextDataSource(path);
        }else if(type == DataSourceType.NUMBER){
            return new  NumberDataSource(path);
        }
        else{
            throw new DataSourceTypeNotFoundException();
        }

    }
}
