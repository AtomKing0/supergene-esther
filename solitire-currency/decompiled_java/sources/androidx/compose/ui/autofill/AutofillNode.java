package androidx.compose.ui.autofill;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Rect;
import h9.l;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Autofill.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
public final class AutofillNode {
    private static int previousId;

    @NotNull
    private final List<AutofillType> autofillTypes;

    @Nullable
    private Rect boundingBox;
    private final int id;

    @Nullable
    private final l<String, k0> onFill;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: Autofill.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int generateId() {
            int i10;
            synchronized (this) {
                AutofillNode.previousId++;
                i10 = AutofillNode.previousId;
            }
            return i10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutofillNode(@NotNull List<? extends AutofillType> autofillTypes, @Nullable Rect rect, @Nullable l<? super String, k0> lVar) {
        t.i(autofillTypes, "autofillTypes");
        this.autofillTypes = autofillTypes;
        this.boundingBox = rect;
        this.onFill = lVar;
        this.id = Companion.generateId();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutofillNode)) {
            return false;
        }
        AutofillNode autofillNode = (AutofillNode) obj;
        return t.d(this.autofillTypes, autofillNode.autofillTypes) && t.d(this.boundingBox, autofillNode.boundingBox) && t.d(this.onFill, autofillNode.onFill);
    }

    @NotNull
    public final List<AutofillType> getAutofillTypes() {
        return this.autofillTypes;
    }

    @Nullable
    public final Rect getBoundingBox() {
        return this.boundingBox;
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final l<String, k0> getOnFill() {
        return this.onFill;
    }

    public int hashCode() {
        int iHashCode = this.autofillTypes.hashCode() * 31;
        Rect rect = this.boundingBox;
        int iHashCode2 = (iHashCode + (rect != null ? rect.hashCode() : 0)) * 31;
        l<String, k0> lVar = this.onFill;
        return iHashCode2 + (lVar != null ? lVar.hashCode() : 0);
    }

    public final void setBoundingBox(@Nullable Rect rect) {
        this.boundingBox = rect;
    }

    public /* synthetic */ AutofillNode(List list, Rect rect, l lVar, int i10, k kVar) {
        this((i10 & 1) != 0 ? v.l() : list, (i10 & 2) != 0 ? null : rect, lVar);
    }
}
