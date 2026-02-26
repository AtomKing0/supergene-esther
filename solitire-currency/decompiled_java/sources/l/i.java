package l;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import com.ironsource.mediationsdk.logger.IronSourceError;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import l.b;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SingletonAsyncImage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: compiled from: SingletonAsyncImage.kt */
    static final class a extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f30186g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f30187h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Modifier f30188i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ l<b.c, b.c> f30189j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ l<b.c, k0> f30190k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Alignment f30191l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ ContentScale f30192m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ float f30193n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ ColorFilter f30194o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ int f30195p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final /* synthetic */ int f30196q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        final /* synthetic */ int f30197r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Object obj, String str, Modifier modifier, l<? super b.c, ? extends b.c> lVar, l<? super b.c, k0> lVar2, Alignment alignment, ContentScale contentScale, float f10, ColorFilter colorFilter, int i10, int i11, int i12) {
            super(2);
            this.f30186g = obj;
            this.f30187h = str;
            this.f30188i = modifier;
            this.f30189j = lVar;
            this.f30190k = lVar2;
            this.f30191l = alignment;
            this.f30192m = contentScale;
            this.f30193n = f10;
            this.f30194o = colorFilter;
            this.f30195p = i10;
            this.f30196q = i11;
            this.f30197r = i12;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            i.a(this.f30186g, this.f30187h, this.f30188i, this.f30189j, this.f30190k, this.f30191l, this.f30192m, this.f30193n, this.f30194o, this.f30195p, composer, this.f30196q | 1, this.f30197r);
        }
    }

    @Composable
    public static final void a(@Nullable Object obj, @Nullable String str, @Nullable Modifier modifier, @Nullable l<? super b.c, ? extends b.c> lVar, @Nullable l<? super b.c, k0> lVar2, @Nullable Alignment alignment, @Nullable ContentScale contentScale, float f10, @Nullable ColorFilter colorFilter, int i10, @Nullable Composer composer, int i11, int i12) {
        l<? super b.c, ? extends b.c> lVarA;
        int i13;
        int iM2027getDefaultFilterQualityfv9h1I;
        Composer composerStartRestartGroup = composer.startRestartGroup(-941517612);
        Modifier modifier2 = (i12 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i12 & 8) != 0) {
            i13 = i11 & (-7169);
            lVarA = b.f30116p.a();
        } else {
            lVarA = lVar;
            i13 = i11;
        }
        l<? super b.c, k0> lVar3 = (i12 & 16) != 0 ? null : lVar2;
        Alignment center = (i12 & 32) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i12 & 64) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f11 = (i12 & 128) != 0 ? 1.0f : f10;
        ColorFilter colorFilter2 = (i12 & 256) != 0 ? null : colorFilter;
        if ((i12 & 512) != 0) {
            i13 &= -1879048193;
            iM2027getDefaultFilterQualityfv9h1I = DrawScope.Companion.m2027getDefaultFilterQualityfv9h1I();
        } else {
            iM2027getDefaultFilterQualityfv9h1I = i10;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-941517612, i13, -1, "coil.compose.AsyncImage (SingletonAsyncImage.kt:99)");
        }
        int i14 = i13 << 3;
        l.a.a(obj, str, g.c(h.a(), composerStartRestartGroup, 6), modifier2, lVarA, lVar3, center, fit, f11, colorFilter2, iM2027getDefaultFilterQualityfv9h1I, composerStartRestartGroup, (i13 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), (i13 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new a(obj, str, modifier2, lVarA, lVar3, center, fit, f11, colorFilter2, iM2027getDefaultFilterQualityfv9h1I, i11, i12));
    }
}
