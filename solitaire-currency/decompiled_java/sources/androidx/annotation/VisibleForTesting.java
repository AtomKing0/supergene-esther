package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VisibleForTesting.kt */
/* JADX INFO: loaded from: classes.dex */
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface VisibleForTesting {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int NONE = 5;
    public static final int PACKAGE_PRIVATE = 3;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 4;

    /* JADX INFO: compiled from: VisibleForTesting.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int NONE = 5;
        public static final int PACKAGE_PRIVATE = 3;
        public static final int PRIVATE = 2;
        public static final int PROTECTED = 4;

        private Companion() {
        }
    }

    int otherwise() default 2;
}
