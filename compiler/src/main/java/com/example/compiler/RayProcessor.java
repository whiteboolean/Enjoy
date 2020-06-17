package com.example.compiler;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;


@SupportedAnnotationTypes("com.example.enjoy.Ray")
public class RayProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        Messager messager = processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.NOTE,"===========");
        return false;
    }
}
