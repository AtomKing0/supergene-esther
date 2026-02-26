package kotlin.reflect;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KType.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KType extends KAnnotatedElement {
    @NotNull
    List<KTypeProjection> getArguments();

    @Nullable
    KClassifier getClassifier();

    boolean isMarkedNullable();

    /* JADX INFO: compiled from: KType.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getArguments$annotations() {
        }

        public static /* synthetic */ void getClassifier$annotations() {
        }
    }
}
