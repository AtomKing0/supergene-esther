package androidx.compose.foundation.layout;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class DoNothingNestedScrollConnection implements NestedScrollConnection {

    @NotNull
    public static final DoNothingNestedScrollConnection INSTANCE = new DoNothingNestedScrollConnection();

    private DoNothingNestedScrollConnection() {
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public /* synthetic */ Object mo301onPostFlingRZ2iAVY(long j10, long j11, z8.d dVar) {
        return androidx.compose.ui.input.nestedscroll.a.a(this, j10, j11, dVar);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public /* synthetic */ long mo302onPostScrollDzOQY0M(long j10, long j11, int i10) {
        return androidx.compose.ui.input.nestedscroll.a.b(this, j10, j11, i10);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public /* synthetic */ Object mo303onPreFlingQWom1Mo(long j10, z8.d dVar) {
        return androidx.compose.ui.input.nestedscroll.a.c(this, j10, dVar);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public /* synthetic */ long mo304onPreScrollOzD1aCk(long j10, int i10) {
        return androidx.compose.ui.input.nestedscroll.a.d(this, j10, i10);
    }
}
