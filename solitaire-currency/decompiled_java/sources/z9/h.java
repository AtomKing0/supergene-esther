package z9;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface h {
    Class<? extends KSerializer<?>> with() default KSerializer.class;
}
