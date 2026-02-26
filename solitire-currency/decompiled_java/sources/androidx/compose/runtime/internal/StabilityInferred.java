package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: StabilityInferred.kt */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@ComposeCompilerApi
@Retention(RetentionPolicy.CLASS)
public @interface StabilityInferred {
    int parameters();
}
