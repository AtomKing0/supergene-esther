package androidx.compose.runtime.internal;

import androidx.compose.runtime.ExperimentalComposeApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Decoy.kt */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@ExperimentalComposeApi
public @interface DecoyImplementation {
    long id();

    String name();
}
