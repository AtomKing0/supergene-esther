package androidx.compose.foundation.text;

import androidx.compose.runtime.internal.StabilityInferred;
import h9.l;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: KeyboardActions.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class KeyboardActions {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final KeyboardActions Default = new KeyboardActions(null, null, null, null, null, null, 63, null);

    @Nullable
    private final l<KeyboardActionScope, k0> onDone;

    @Nullable
    private final l<KeyboardActionScope, k0> onGo;

    @Nullable
    private final l<KeyboardActionScope, k0> onNext;

    @Nullable
    private final l<KeyboardActionScope, k0> onPrevious;

    @Nullable
    private final l<KeyboardActionScope, k0> onSearch;

    @Nullable
    private final l<KeyboardActionScope, k0> onSend;

    /* JADX INFO: compiled from: KeyboardActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final KeyboardActions getDefault() {
            return KeyboardActions.Default;
        }
    }

    public KeyboardActions() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Nullable
    public final l<KeyboardActionScope, k0> getOnDone() {
        return this.onDone;
    }

    @Nullable
    public final l<KeyboardActionScope, k0> getOnGo() {
        return this.onGo;
    }

    @Nullable
    public final l<KeyboardActionScope, k0> getOnNext() {
        return this.onNext;
    }

    @Nullable
    public final l<KeyboardActionScope, k0> getOnPrevious() {
        return this.onPrevious;
    }

    @Nullable
    public final l<KeyboardActionScope, k0> getOnSearch() {
        return this.onSearch;
    }

    @Nullable
    public final l<KeyboardActionScope, k0> getOnSend() {
        return this.onSend;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KeyboardActions(@Nullable l<? super KeyboardActionScope, k0> lVar, @Nullable l<? super KeyboardActionScope, k0> lVar2, @Nullable l<? super KeyboardActionScope, k0> lVar3, @Nullable l<? super KeyboardActionScope, k0> lVar4, @Nullable l<? super KeyboardActionScope, k0> lVar5, @Nullable l<? super KeyboardActionScope, k0> lVar6) {
        this.onDone = lVar;
        this.onGo = lVar2;
        this.onNext = lVar3;
        this.onPrevious = lVar4;
        this.onSearch = lVar5;
        this.onSend = lVar6;
    }

    public /* synthetic */ KeyboardActions(l lVar, l lVar2, l lVar3, l lVar4, l lVar5, l lVar6, int i10, k kVar) {
        this((i10 & 1) != 0 ? null : lVar, (i10 & 2) != 0 ? null : lVar2, (i10 & 4) != 0 ? null : lVar3, (i10 & 8) != 0 ? null : lVar4, (i10 & 16) != 0 ? null : lVar5, (i10 & 32) != 0 ? null : lVar6);
    }
}
