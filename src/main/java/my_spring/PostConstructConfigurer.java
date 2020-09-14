package my_spring;

public interface PostConstructConfigurer {
    <T> Object configure(T t, Class<T> implClass, ApplicationContext context);
}
