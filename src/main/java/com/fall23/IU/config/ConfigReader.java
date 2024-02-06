package com.fall23.IU.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// 1 шаблон проектирования Singleton
public class ConfigReader { // считывать данные с файла application.properties и какой браузер запускать

    private static Properties properties;

    private ConfigReader(){ // только 1 объект класса может существовать
        // private constructor -> pattern Singleton -> одиночка
        // Singleton = static = need methods
        // abstract не исп. Почему?

        // Singleton (с англ. «одиночка») — это паттерн проектирования, гарантирующий, что у класса будет только один экземпляр.
        // К этому экземпляру будет предоставлена глобальная, то есть доступная из любой части программы, точка доступа.
        // Если попытаться создать новый объект этого класса, то вернётся уже созданный существующий экземпляр.

        // Например, в любом государстве может быть только одна конституция.
        // Если потребуется её изменить, то нужно будет работать с существующим экземпляром и никак иначе.

        // Другой пример — менеджер паролей.
        // Он создаёт только один объект для каждой учётной записи и возвращает его при запросе — для одной учётной записи не может быть двух разных паролей.
    }

    static { // статик блок (все поля в нем статичные, чтобы каждому не прописывать static и они должны принадлежать этому классу)
        try {
            String path = "src/main/resources/application.properties";
            FileInputStream inputStream = new FileInputStream(path); // Чтение файлов -> ему передали прочитать файл с путем path (inputStream = application.properties)
            properties = new Properties(); // инициализация Properties объекта
            properties.load(inputStream); // load - загружаем inputStream с файлами appication этим properties
            inputStream.close(); // закрыли поток
        }
        catch (IOException e) {
            throw new RuntimeException("File not found");
        }
    }

    public static String getValue(String key){ // or getProperties
        return properties.getProperty(key).trim(); // возврати свойства properties; trim - убери пробелы
    }

    public static void main(String[] args) {
        System.out.println(getValue("browser")); // chrome
        System.out.println(getValue("name")); // Nurzat
    }

}
