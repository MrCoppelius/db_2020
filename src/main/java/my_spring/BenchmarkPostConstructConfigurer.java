package my_spring;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BenchmarkPostConstructConfigurer implements PostConstructConfigurer {
    @Override
    public <T> Object configure(T t,Class<T> implClass, ApplicationContext context) {
        List<Method> methods  = new ArrayList<>();
        if (t.getClass().isAnnotationPresent(Benchmark.class)) {
            methods.addAll(Arrays.asList(t.getClass().getDeclaredMethods()));
        }
        else {
            Method[] declaredMethods = t.getClass().getDeclaredMethods();
            for (Method method: declaredMethods) {
                if (method.isAnnotationPresent(Benchmark.class)){
                    methods.add(method);
                }
            }
        }
        return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), new Handler<T>(t, methods));
    }


}
