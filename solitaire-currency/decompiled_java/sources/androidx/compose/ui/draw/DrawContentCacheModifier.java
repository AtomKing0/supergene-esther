package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DrawModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawContentCacheModifier implements DrawCacheModifier {

    @NotNull
    private final CacheDrawScope cacheDrawScope;

    @NotNull
    private final l<CacheDrawScope, DrawResult> onBuildDrawCache;

    /* JADX WARN: Multi-variable type inference failed */
    public DrawContentCacheModifier(@NotNull CacheDrawScope cacheDrawScope, @NotNull l<? super CacheDrawScope, DrawResult> onBuildDrawCache) {
        t.i(cacheDrawScope, "cacheDrawScope");
        t.i(onBuildDrawCache, "onBuildDrawCache");
        this.cacheDrawScope = cacheDrawScope;
        this.onBuildDrawCache = onBuildDrawCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DrawContentCacheModifier copy$default(DrawContentCacheModifier drawContentCacheModifier, CacheDrawScope cacheDrawScope, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cacheDrawScope = drawContentCacheModifier.cacheDrawScope;
        }
        if ((i10 & 2) != 0) {
            lVar = drawContentCacheModifier.onBuildDrawCache;
        }
        return drawContentCacheModifier.copy(cacheDrawScope, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @NotNull
    public final CacheDrawScope component1() {
        return this.cacheDrawScope;
    }

    @NotNull
    public final l<CacheDrawScope, DrawResult> component2() {
        return this.onBuildDrawCache;
    }

    @NotNull
    public final DrawContentCacheModifier copy(@NotNull CacheDrawScope cacheDrawScope, @NotNull l<? super CacheDrawScope, DrawResult> onBuildDrawCache) {
        t.i(cacheDrawScope, "cacheDrawScope");
        t.i(onBuildDrawCache, "onBuildDrawCache");
        return new DrawContentCacheModifier(cacheDrawScope, onBuildDrawCache);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        t.i(contentDrawScope, "<this>");
        DrawResult drawResult$ui_release = this.cacheDrawScope.getDrawResult$ui_release();
        t.f(drawResult$ui_release);
        drawResult$ui_release.getBlock$ui_release().invoke(contentDrawScope);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawContentCacheModifier)) {
            return false;
        }
        DrawContentCacheModifier drawContentCacheModifier = (DrawContentCacheModifier) obj;
        return t.d(this.cacheDrawScope, drawContentCacheModifier.cacheDrawScope) && t.d(this.onBuildDrawCache, drawContentCacheModifier.onBuildDrawCache);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @NotNull
    public final CacheDrawScope getCacheDrawScope() {
        return this.cacheDrawScope;
    }

    @NotNull
    public final l<CacheDrawScope, DrawResult> getOnBuildDrawCache() {
        return this.onBuildDrawCache;
    }

    public int hashCode() {
        return (this.cacheDrawScope.hashCode() * 31) + this.onBuildDrawCache.hashCode();
    }

    @Override // androidx.compose.ui.draw.DrawCacheModifier
    public void onBuildCache(@NotNull BuildDrawCacheParams params) {
        t.i(params, "params");
        CacheDrawScope cacheDrawScope = this.cacheDrawScope;
        cacheDrawScope.setCacheParams$ui_release(params);
        cacheDrawScope.setDrawResult$ui_release(null);
        this.onBuildDrawCache.invoke(cacheDrawScope);
        if (cacheDrawScope.getDrawResult$ui_release() == null) {
            throw new IllegalStateException("DrawResult not defined, did you forget to call onDraw?".toString());
        }
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "DrawContentCacheModifier(cacheDrawScope=" + this.cacheDrawScope + ", onBuildDrawCache=" + this.onBuildDrawCache + ')';
    }
}
