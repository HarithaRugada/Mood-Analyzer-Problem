package com.moodanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer() throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.moodanalyzer.MoodAnalyzer");
            //try {
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
            //try {
            Object moodObject = moodConstructor.newInstance();
            MoodAnalyzer moodObject1 = (MoodAnalyzer) moodObject;
            return moodObject1;
        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        } catch (NoSuchMethodException noSuchMethodException) {
            //noSuchMethodException.printStackTrace();
            throw new MoodAnalyzerException("Method Not Found",MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD);
        } catch (ClassNotFoundException classNotFoundException) {
            //classNotFoundException.printStackTrace();
            throw new MoodAnalyzerException("Class Not Found",MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS);
        }
        return null;
    }
    public static MoodAnalyzer createMoodAnalyzer(String message) throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.moodanalyzer.MoodAnalyzer");
            //try {
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            //try {
            Object moodObject = moodConstructor.newInstance(message);
            MoodAnalyzer moodObject1 = (MoodAnalyzer) moodObject;
            return moodObject1;
        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        } catch (NoSuchMethodException noSuchMethodException) {
            //noSuchMethodException.printStackTrace();
            throw new MoodAnalyzerException("Method Not Found",MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD);
        } catch (ClassNotFoundException classNotFoundException) {
            //classNotFoundException.printStackTrace();
            throw new MoodAnalyzerException("Class Not Found",MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS);
        }
        return null;
    }
}
