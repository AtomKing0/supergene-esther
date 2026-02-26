package androidx.compose.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: ComposableInferredTarget.kt */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@InternalComposeApi
@Retention(RetentionPolicy.CLASS)
public @interface ComposableInferredTarget {
    String scheme();
}
