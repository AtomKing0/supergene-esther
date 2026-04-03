package kotlin.reflect;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KTypeParameter.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KTypeParameter extends KClassifier {
    @NotNull
    String getName();

    @NotNull
    List<KType> getUpperBounds();

    @NotNull
    KVariance getVariance();

    boolean isReified();
}
