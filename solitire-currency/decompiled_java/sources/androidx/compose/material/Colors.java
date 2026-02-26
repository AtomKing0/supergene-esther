package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Colors.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class Colors {

    @NotNull
    private final MutableState background$delegate;

    @NotNull
    private final MutableState error$delegate;

    @NotNull
    private final MutableState isLight$delegate;

    @NotNull
    private final MutableState onBackground$delegate;

    @NotNull
    private final MutableState onError$delegate;

    @NotNull
    private final MutableState onPrimary$delegate;

    @NotNull
    private final MutableState onSecondary$delegate;

    @NotNull
    private final MutableState onSurface$delegate;

    @NotNull
    private final MutableState primary$delegate;

    @NotNull
    private final MutableState primaryVariant$delegate;

    @NotNull
    private final MutableState secondary$delegate;

    @NotNull
    private final MutableState secondaryVariant$delegate;

    @NotNull
    private final MutableState surface$delegate;

    public /* synthetic */ Colors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, boolean z10, k kVar) {
        this(j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, z10);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-pvPzIIM, reason: not valid java name */
    public final Colors m943copypvPzIIM(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, boolean z10) {
        return new Colors(j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, z10, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m944getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m945getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m946getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m947getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m948getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m949getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m950getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m951getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m952getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m953getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m954getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m955getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).m1608unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isLight() {
        return ((Boolean) this.isLight$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: setBackground-8_81llA$material_release, reason: not valid java name */
    public final void m956setBackground8_81llA$material_release(long j10) {
        this.background$delegate.setValue(Color.m1588boximpl(j10));
    }

    /* JADX INFO: renamed from: setError-8_81llA$material_release, reason: not valid java name */
    public final void m957setError8_81llA$material_release(long j10) {
        this.error$delegate.setValue(Color.m1588boximpl(j10));
    }

    public final void setLight$material_release(boolean z10) {
        this.isLight$delegate.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: renamed from: setOnBackground-8_81llA$material_release, reason: not valid java name */
    public final void m958setOnBackground8_81llA$material_release(long j10) {
        this.onBackground$delegate.setValue(Color.m1588boximpl(j10));
    }

    /* JADX INFO: renamed from: setOnError-8_81llA$material_release, reason: not valid java name */
    public final void m959setOnError8_81llA$material_release(long j10) {
        this.onError$delegate.setValue(Color.m1588boximpl(j10));
    }

    /* JADX INFO: renamed from: setOnPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m960setOnPrimary8_81llA$material_release(long j10) {
        this.onPrimary$delegate.setValue(Color.m1588boximpl(j10));
    }

    /* JADX INFO: renamed from: setOnSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m961setOnSecondary8_81llA$material_release(long j10) {
        this.onSecondary$delegate.setValue(Color.m1588boximpl(j10));
    }

    /* JADX INFO: renamed from: setOnSurface-8_81llA$material_release, reason: not valid java name */
    public final void m962setOnSurface8_81llA$material_release(long j10) {
        this.onSurface$delegate.setValue(Color.m1588boximpl(j10));
    }

    /* JADX INFO: renamed from: setPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m963setPrimary8_81llA$material_release(long j10) {
        this.primary$delegate.setValue(Color.m1588boximpl(j10));
    }

    /* JADX INFO: renamed from: setPrimaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m964setPrimaryVariant8_81llA$material_release(long j10) {
        this.primaryVariant$delegate.setValue(Color.m1588boximpl(j10));
    }

    /* JADX INFO: renamed from: setSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m965setSecondary8_81llA$material_release(long j10) {
        this.secondary$delegate.setValue(Color.m1588boximpl(j10));
    }

    /* JADX INFO: renamed from: setSecondaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m966setSecondaryVariant8_81llA$material_release(long j10) {
        this.secondaryVariant$delegate.setValue(Color.m1588boximpl(j10));
    }

    /* JADX INFO: renamed from: setSurface-8_81llA$material_release, reason: not valid java name */
    public final void m967setSurface8_81llA$material_release(long j10) {
        this.surface$delegate.setValue(Color.m1588boximpl(j10));
    }

    @NotNull
    public String toString() {
        return "Colors(primary=" + ((Object) Color.m1606toStringimpl(m951getPrimary0d7_KjU())) + ", primaryVariant=" + ((Object) Color.m1606toStringimpl(m952getPrimaryVariant0d7_KjU())) + ", secondary=" + ((Object) Color.m1606toStringimpl(m953getSecondary0d7_KjU())) + ", secondaryVariant=" + ((Object) Color.m1606toStringimpl(m954getSecondaryVariant0d7_KjU())) + ", background=" + ((Object) Color.m1606toStringimpl(m944getBackground0d7_KjU())) + ", surface=" + ((Object) Color.m1606toStringimpl(m955getSurface0d7_KjU())) + ", error=" + ((Object) Color.m1606toStringimpl(m945getError0d7_KjU())) + ", onPrimary=" + ((Object) Color.m1606toStringimpl(m948getOnPrimary0d7_KjU())) + ", onSecondary=" + ((Object) Color.m1606toStringimpl(m949getOnSecondary0d7_KjU())) + ", onBackground=" + ((Object) Color.m1606toStringimpl(m946getOnBackground0d7_KjU())) + ", onSurface=" + ((Object) Color.m1606toStringimpl(m950getOnSurface0d7_KjU())) + ", onError=" + ((Object) Color.m1606toStringimpl(m947getOnError0d7_KjU())) + ", isLight=" + isLight() + ')';
    }

    private Colors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, boolean z10) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j13), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j14), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j15), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j16), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j17), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j18), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j19), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j20), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.m1588boximpl(j21), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight$delegate = SnapshotStateKt.mutableStateOf(Boolean.valueOf(z10), SnapshotStateKt.structuralEqualityPolicy());
    }
}
