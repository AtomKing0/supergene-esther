package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.unit.Velocity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: NestedScrollModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollConnection {

    /* JADX INFO: compiled from: NestedScrollModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public static Object m2771onPostFlingRZ2iAVY(@NotNull NestedScrollConnection nestedScrollConnection, long j10, long j11, @NotNull d<? super Velocity> dVar) {
            return a.a(nestedScrollConnection, j10, j11, dVar);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public static long m2772onPostScrollDzOQY0M(@NotNull NestedScrollConnection nestedScrollConnection, long j10, long j11, int i10) {
            return a.b(nestedScrollConnection, j10, j11, i10);
        }

        @Deprecated
        @Nullable
        /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public static Object m2773onPreFlingQWom1Mo(@NotNull NestedScrollConnection nestedScrollConnection, long j10, @NotNull d<? super Velocity> dVar) {
            return a.c(nestedScrollConnection, j10, dVar);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public static long m2774onPreScrollOzD1aCk(@NotNull NestedScrollConnection nestedScrollConnection, long j10, int i10) {
            return a.d(nestedScrollConnection, j10, i10);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    Object mo301onPostFlingRZ2iAVY(long j10, long j11, @NotNull d<? super Velocity> dVar);

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    long mo302onPostScrollDzOQY0M(long j10, long j11, int i10);

    @Nullable
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    Object mo303onPreFlingQWom1Mo(long j10, @NotNull d<? super Velocity> dVar);

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    long mo304onPreScrollOzD1aCk(long j10, int i10);
}
