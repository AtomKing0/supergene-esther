package androidx.room;

import androidx.annotation.RequiresApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Upsert.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD})
@RequiresApi(16)
@Retention(RetentionPolicy.CLASS)
public @interface Upsert {
    Class<?> entity() default Object.class;
}
