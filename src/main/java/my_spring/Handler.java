package my_spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class Handler<T> implements InvocationHandler {
    private final T  origin;
    private final List<Method> methods;
    public Handler(T origin, List<Method> methods) {
        this.origin = origin;
        this.methods = methods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retVal;
        if (methods.contains(method)) {
            System.out.println("************* BENCHMARK STARTED for method "+ method.getName()+" ****************");
            long start = System.nanoTime();
            retVal = method.invoke(origin, args);
            long end = System.nanoTime();
            System.out.println(end-start);
            System.out.println("************* BENCHMARK ENDED for method "+ method.getName()+" ****************");

        }
        else {
            retVal = method.invoke(origin, args);
        }
        return retVal;
    }
}
