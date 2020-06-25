package com.moodanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerReflector {

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
            throw new MoodAnalyzerException("Method Not Found", MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD);
        } catch (ClassNotFoundException classNotFoundException) {
            //classNotFoundException.printStackTrace();
            throw new MoodAnalyzerException("Class Not Found", MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS);
        }
        return null;
    }

    public static String invokeAnalyzeMood(String className, String methodName, String message) {
        String mood = null;
        try {
            Method methods = MoodAnalyzer.class.getMethod(methodName);
            MoodAnalyzer moodAnalyzer = createMoodAnalyzer(message);
            mood = (String) methods.invoke(moodAnalyzer);

        } catch (NoSuchMethodException noSuchMethodException) {
            throw new MoodAnalyzerException("Method Not Found", MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD);
        } catch (MoodAnalyzerException moodAnalyzerException) {
            moodAnalyzerException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }
        return mood;
    }
}
