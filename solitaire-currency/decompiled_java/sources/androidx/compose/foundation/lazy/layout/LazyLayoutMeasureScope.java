package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyLayoutMeasureScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public interface LazyLayoutMeasureScope extends MeasureScope {
    @NotNull
    /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
    Placeable[] mo608measure0kLqBqw(int i10, long j10);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    float mo291toDpGaN1DYA(long j10);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo292toDpu2uoSUM(float f10);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo293toDpu2uoSUM(int i10);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    long mo294toDpSizekrfVVM(long j10);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    long mo297toSizeXkaWNTQ(long j10);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    long mo298toSp0xMU5do(float f10);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo299toSpkPz2Gy4(float f10);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo300toSpkPz2Gy4(int i10);
}
