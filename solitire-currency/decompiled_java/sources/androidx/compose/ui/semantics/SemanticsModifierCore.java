package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.b;
import h9.l;
import h9.p;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SemanticsModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsModifierCore implements SemanticsModifier {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static AtomicInteger lastIdentifier = new AtomicInteger(0);
    private final int id;

    @NotNull
    private final SemanticsConfiguration semanticsConfiguration;

    /* JADX INFO: compiled from: SemanticsModifier.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final int generateSemanticsId() {
            return SemanticsModifierCore.lastIdentifier.addAndGet(1);
        }
    }

    public SemanticsModifierCore(int i10, boolean z10, boolean z11, @NotNull l<? super SemanticsPropertyReceiver, k0> properties) {
        t.i(properties, "properties");
        this.id = i10;
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.setMergingSemanticsOfDescendants(z10);
        semanticsConfiguration.setClearingSemantics(z11);
        properties.invoke(semanticsConfiguration);
        this.semanticsConfiguration = semanticsConfiguration;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return b.b(this, lVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SemanticsModifierCore)) {
            return false;
        }
        SemanticsModifierCore semanticsModifierCore = (SemanticsModifierCore) obj;
        return getId() == semanticsModifierCore.getId() && t.d(getSemanticsConfiguration(), semanticsModifierCore.getSemanticsConfiguration());
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return b.d(this, obj, pVar);
    }

    @Override // androidx.compose.ui.semantics.SemanticsModifier
    public int getId() {
        return this.id;
    }

    @Override // androidx.compose.ui.semantics.SemanticsModifier
    @NotNull
    public SemanticsConfiguration getSemanticsConfiguration() {
        return this.semanticsConfiguration;
    }

    public int hashCode() {
        return (getSemanticsConfiguration().hashCode() * 31) + getId();
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}
