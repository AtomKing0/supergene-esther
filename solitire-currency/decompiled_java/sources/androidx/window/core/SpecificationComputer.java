package androidx.window.core;

import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SpecificationComputer.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SpecificationComputer<T> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: SpecificationComputer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public static /* synthetic */ SpecificationComputer startSpecification$default(Companion companion, Object obj, String str, VerificationMode verificationMode, Logger logger, int i10, Object obj2) {
            if ((i10 & 2) != 0) {
                verificationMode = BuildConfig.INSTANCE.getVerificationMode();
            }
            if ((i10 & 4) != 0) {
                logger = AndroidLogger.INSTANCE;
            }
            return companion.startSpecification(obj, str, verificationMode, logger);
        }

        @NotNull
        public final <T> SpecificationComputer<T> startSpecification(@NotNull T t10, @NotNull String tag, @NotNull VerificationMode verificationMode, @NotNull Logger logger) {
            t.i(t10, "<this>");
            t.i(tag, "tag");
            t.i(verificationMode, "verificationMode");
            t.i(logger, "logger");
            return new ValidSpecification(t10, tag, verificationMode, logger);
        }
    }

    /* JADX INFO: compiled from: SpecificationComputer.kt */
    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    @Nullable
    public abstract T compute();

    @NotNull
    protected final String createMessage(@NotNull Object value, @NotNull String message) {
        t.i(value, "value");
        t.i(message, "message");
        return message + " value: " + value;
    }

    @NotNull
    public abstract SpecificationComputer<T> require(@NotNull String str, @NotNull l<? super T, Boolean> lVar);
}
