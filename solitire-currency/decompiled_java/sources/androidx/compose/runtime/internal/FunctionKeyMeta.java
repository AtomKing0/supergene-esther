package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: FunctionKeyMeta.kt */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@ComposeCompilerApi
@Repeatable(Container.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FunctionKeyMeta {

    /* JADX INFO: compiled from: FunctionKeyMeta.kt */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Container {
        FunctionKeyMeta[] value();
    }

    int endOffset();

    int key();

    int startOffset();
}
