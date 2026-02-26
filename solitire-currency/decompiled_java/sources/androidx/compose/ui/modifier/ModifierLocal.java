package androidx.compose.ui.modifier;

import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ModifierLocal.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public abstract class ModifierLocal<T> {

    @NotNull
    private final h9.a<T> defaultFactory;

    public /* synthetic */ ModifierLocal(h9.a aVar, k kVar) {
        this(aVar);
    }

    @NotNull
    public final h9.a<T> getDefaultFactory$ui_release() {
        return this.defaultFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ModifierLocal(h9.a<? extends T> aVar) {
        this.defaultFactory = aVar;
    }
}
