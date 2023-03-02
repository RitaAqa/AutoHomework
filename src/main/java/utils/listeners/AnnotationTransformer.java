package utils.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * class listener for transformation TestNG annotations
 */
public class AnnotationTransformer implements IAnnotationTransformer {

    /**
     * adds RetryAnalyzer annotation to all test methods
     */
    @Override
    public void transform(ITestAnnotation testannotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {
        testannotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}

