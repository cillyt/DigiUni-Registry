import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Позначає метод як пункт меню.
 *
 * label   — назва пункту, яка відображається користувачу
 * minRole — мінімальний рівень доступу: 1=Користувач, 2=Менеджер, 3=Адміністратор
 * section — до якого розділу належить пункт (student / teacher / university / faculty / department / user)
 * order   — порядок відображення в меню
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MenuOption {
    String label();
    int minRole() default 1;
    String section();
    int order() default 99;
}
